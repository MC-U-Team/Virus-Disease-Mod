package info.u_team.u_team_core.util.verify;

import java.io.InputStream;
import java.nio.file.*;
import java.util.Optional;
import java.util.jar.*;
import java.util.stream.Stream;

import org.apache.logging.log4j.*;

import com.google.common.io.ByteStreams;

import net.minecraftforge.fml.common.CertificateHelper;
import net.minecraftforge.fml.loading.*;

/**
 * Just a straight copy from the uteamcore 1.15.2 version
 * (https://github.com/MC-U-Team/U-Team-Core/blob/6badd75832468cbb495aac06429749241b782063/src/main/java/info/u_team/u_team_core/util/verify/JarSignVerifier.java)
 * 
 * @author HyCraftHD
 */
public class JarSignVerifier {
	
	private static final Logger LOGGER = LogManager.getLogger("JarSignVerifier");
	
	public static void checkSigned(String modid) {
		final VerifyStatus status = verify(modid);
		if (status == VerifyStatus.SIGNED) {
			LOGGER.info("Mod " + modid + " is signed with a valid certificate.");
		} else if (status == VerifyStatus.UNSIGNED) {
			LOGGER.warn("---------------------------------------------------------------------------------");
			LOGGER.warn("Mod " + modid + " is not signed with a valid certificate but should be signed.");
			LOGGER.warn("Please download the mod only from trusted sources such as curseforge.com!");
			LOGGER.warn("---------------------------------------------------------------------------------");
		} else {
			LOGGER.info("Mod " + modid + " is loaded in dev environment.");
		}
	}
	
	public static VerifyStatus verify(String modid) {
		// We don't need to check sign in dev environment
		if (FMLLoader.getNaming().equals("mcp")) {
			return VerifyStatus.DEV;
		}
		
		final Path path = LoadingModList.get().getModFileById(modid).getFile().getFilePath();
		
		if (Files.isDirectory(path)) {
			return VerifyStatus.DEV;
		}
		
		try (final JarFile jarFile = new JarFile(path.toFile())) {
			
			// Get fingerprint from manifest
			final Optional<String> fingerPrintOptional = Optional.ofNullable(jarFile.getManifest().getMainAttributes().getValue("Fingerprint"));
			
			if (!fingerPrintOptional.isPresent()) {
				return VerifyStatus.UNSIGNED;
			}
			
			// Remove dots and make all characters lowercase
			final String fingerprint = fingerPrintOptional.get().replace(":", "").toLowerCase();
			
			try (Stream<JarEntry> entryStream = jarFile.stream()) {
				// Check sign on every resource excluding directories and the certificate files
				if (entryStream.filter(JarSignVerifier::checkEntryForSign).allMatch(entry -> {
					// Read everything so the certificate gets loaded but trash the input
					try (final InputStream stream = jarFile.getInputStream(entry)) {
						ByteStreams.toByteArray(stream);
					} catch (final Exception ex) {
						return false;
					}
					// Check if finger print is valid
					return CertificateHelper.getFingerprints(entry.getCertificates()).stream().filter(fingerprint::equals).findAny().isPresent();
				})) {
					return VerifyStatus.SIGNED;
				}
			}
			return VerifyStatus.UNSIGNED;
		} catch (final Exception ex) {
			return VerifyStatus.UNSIGNED;
		}
	}
	
	private static boolean checkEntryForSign(JarEntry entry) {
		if (entry.isDirectory()) {
			return false;
		}
		final String name = entry.getName().toUpperCase();
		return !name.endsWith(".SF") && !name.endsWith(".DSA") && !name.endsWith(".EC") && !name.endsWith(".RSA");
	}
	
	public static enum VerifyStatus {
		SIGNED,
		UNSIGNED,
		DEV;
	}
	
}

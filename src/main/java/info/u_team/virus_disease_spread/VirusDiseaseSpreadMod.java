package info.u_team.virus_disease_spread;

import info.u_team.u_team_core.util.annotation.AnnotationManager;
import info.u_team.u_team_core.util.verify.JarSignVerifier;
import net.minecraftforge.fml.common.Mod;

@Mod(VirusDiseaseSpreadMod.MODID)
public class VirusDiseaseSpreadMod {
	
	public static final String MODID = "virusdiseasespread";
	
	public VirusDiseaseSpreadMod() {
		JarSignVerifier.checkSigned(MODID);
		
		AnnotationManager.callAnnotations(MODID);
	}
	
}

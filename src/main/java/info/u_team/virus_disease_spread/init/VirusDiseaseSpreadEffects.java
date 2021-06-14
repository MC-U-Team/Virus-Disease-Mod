package info.u_team.virus_disease_spread.init;

import info.u_team.u_team_core.util.registry.CommonDeferredRegister;
import info.u_team.virus_disease_spread.VirusDiseaseSpreadMod;
import info.u_team.virus_disease_spread.effect.InfectedEffect;
import net.minecraft.potion.Effect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;

public class VirusDiseaseSpreadEffects {
	
	private static final CommonDeferredRegister<Effect> EFFECTS = CommonDeferredRegister.create(ForgeRegistries.POTIONS, VirusDiseaseSpreadMod.MODID);
	
	public static final RegistryObject<InfectedEffect> INFECTED = EFFECTS.register("infected", InfectedEffect::new);
	
	public static void registerMod(IEventBus bus) {
		EFFECTS.register(bus);
	}
	
}

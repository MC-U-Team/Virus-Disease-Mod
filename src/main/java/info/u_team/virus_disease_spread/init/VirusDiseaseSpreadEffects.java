package info.u_team.virus_disease_spread.init;

import info.u_team.u_team_core.util.registry.BaseRegistryUtil;
import info.u_team.virus_disease_spread.VirusDiseaseSpreadMod;
import info.u_team.virus_disease_spread.effect.InfectedEffect;
import net.minecraft.potion.Effect;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = VirusDiseaseSpreadMod.MODID, bus = Bus.MOD)
public class VirusDiseaseSpreadEffects {
	
	public static final Effect INFECTED = new InfectedEffect("infected");
	
	@SubscribeEvent
	public static void register(Register<Effect> event) {
		BaseRegistryUtil.getAllRegistryEntriesAndApplyNames(VirusDiseaseSpreadMod.MODID, Effect.class).forEach(event.getRegistry()::register);
	}
	
}

package info.u_team.virus_disease_spread.init;

import info.u_team.u_team_core.util.registry.BaseRegistryUtil;
import info.u_team.virus_disease_spread.VirusDiseaseSpreadMod;
import info.u_team.virus_disease_spread.potion.InfectedPotion;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = VirusDiseaseSpreadMod.MODID, bus = Bus.MOD)
public class VirusDiseaseSpreadPotions {
	
	public static final Potion INFECTED_NORMAL = new InfectedPotion("infected_normal", 24000 * 8, 0);
	public static final Potion INFECTED_SEVERE = new InfectedPotion("infected_severe", 24000 * 14, 1);
	public static final Potion INFECTED_CRITICAL = new InfectedPotion("infected_critical", 24000 * 25, 2);
	
	@SubscribeEvent
	public static void register(Register<Potion> event) {
		BaseRegistryUtil.getAllRegistryEntriesAndApplyNames(VirusDiseaseSpreadMod.MODID, Potion.class).forEach(event.getRegistry()::register);
	}
	
}

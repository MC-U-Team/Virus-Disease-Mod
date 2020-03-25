package info.u_team.virus_disease_spread.init;

import info.u_team.u_team_core.util.registry.BaseRegistryUtil;
import info.u_team.virus_disease_spread.VirusDiseaseSpreadMod;
import info.u_team.virus_disease_spread.item.ProbabilityTestItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = VirusDiseaseSpreadMod.MODID, bus = Bus.MOD)
public class VirusDiseaseSpreadItems {
	
	public static final ProbabilityTestItem PROBABILITY_TEST = new ProbabilityTestItem("probability_test");
	
	@SubscribeEvent
	public static void register(Register<Item> event) {
		BaseRegistryUtil.getAllRegistryEntriesAndApplyNames(VirusDiseaseSpreadMod.MODID, Item.class).forEach(event.getRegistry()::register);
	}
	
}

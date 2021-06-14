package info.u_team.virus_disease_spread.init;

import info.u_team.u_team_core.util.registry.CommonDeferredRegister;
import info.u_team.virus_disease_spread.VirusDiseaseSpreadMod;
import info.u_team.virus_disease_spread.item.ProbabilityTestItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;

public class VirusDiseaseSpreadItems {
	
	private static final CommonDeferredRegister<Item> ITEMS = CommonDeferredRegister.create(ForgeRegistries.ITEMS, VirusDiseaseSpreadMod.MODID);
	
	public static final RegistryObject<ProbabilityTestItem> PROBABILITY_TEST = ITEMS.register("probability_test", ProbabilityTestItem::new);
	
	public static void registerMod(IEventBus bus) {
		ITEMS.register(bus);
	}
}

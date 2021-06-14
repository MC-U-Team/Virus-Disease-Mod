package info.u_team.virus_disease_spread.data;

import info.u_team.u_team_core.data.GenerationData;
import info.u_team.virus_disease_spread.VirusDiseaseSpreadMod;
import info.u_team.virus_disease_spread.data.provider.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@EventBusSubscriber(modid = VirusDiseaseSpreadMod.MODID, bus = Bus.MOD)
public class VirusDiseaseSpreadDataGenerator {
	
	@SubscribeEvent
	public static void data(GatherDataEvent event) {
		final GenerationData data = new GenerationData(VirusDiseaseSpreadMod.MODID, event);
		if (event.includeClient()) {
			data.addProvider(VirusDiseaseSpreadLanguagesProvider::new);
			data.addProvider(VirusDiseaseSpreadItemModelsProvider::new);
		}
		if (event.includeServer()) {
			data.addProvider(VirusDiseaseSpreadRecipesProvider::new);
		}
	}
	
}

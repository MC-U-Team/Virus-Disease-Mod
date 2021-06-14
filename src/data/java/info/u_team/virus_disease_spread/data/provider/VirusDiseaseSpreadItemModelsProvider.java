package info.u_team.virus_disease_spread.data.provider;

import info.u_team.u_team_core.data.CommonItemModelsProvider;
import info.u_team.u_team_core.data.GenerationData;
import info.u_team.virus_disease_spread.init.VirusDiseaseSpreadItems;

public class VirusDiseaseSpreadItemModelsProvider extends CommonItemModelsProvider {
	
	public VirusDiseaseSpreadItemModelsProvider(GenerationData data) {
		super(data);
	}
	
	@Override
	protected void registerModels() {
		simpleHandheld(VirusDiseaseSpreadItems.PROBABILITY_TEST.get());
	}
	
}

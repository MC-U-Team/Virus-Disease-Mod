package info.u_team.virus_disease_spread.init;

import info.u_team.u_team_core.api.construct.Construct;
import info.u_team.u_team_core.api.construct.IModConstruct;
import info.u_team.u_team_core.util.registry.BusRegister;
import info.u_team.virus_disease_spread.VirusDiseaseSpreadMod;
import info.u_team.virus_disease_spread.config.CommonConfig;
import info.u_team.virus_disease_spread.handler.CommonEventHandler;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig.Type;

@Construct(modid = VirusDiseaseSpreadMod.MODID)
public class VirusDiseaseSpreadCommonConstruct implements IModConstruct {
	
	@Override
	public void construct() {
		ModLoadingContext.get().registerConfig(Type.COMMON, CommonConfig.CONFIG);
		
		BusRegister.registerMod(VirusDiseaseSpreadEffects::registerMod);
		BusRegister.registerMod(VirusDiseaseSpreadItems::registerMod);
		BusRegister.registerMod(VirusDiseaseSpreadPotions::registerMod);
		
		BusRegister.registerForge(CommonEventHandler::registerForge);
	}
	
}

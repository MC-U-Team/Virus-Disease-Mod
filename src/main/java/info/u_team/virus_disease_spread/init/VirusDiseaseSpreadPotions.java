package info.u_team.virus_disease_spread.init;

import info.u_team.u_team_core.util.registry.CommonDeferredRegister;
import info.u_team.virus_disease_spread.VirusDiseaseSpreadMod;
import info.u_team.virus_disease_spread.potion.InfectedPotion;
import net.minecraft.potion.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;

public class VirusDiseaseSpreadPotions {
	
	private static final CommonDeferredRegister<Potion> POTIONS = CommonDeferredRegister.create(ForgeRegistries.POTION_TYPES, VirusDiseaseSpreadMod.MODID);
	
	public static final RegistryObject<InfectedPotion> INFECTED_NORMAL = POTIONS.register("infected_normal", () -> new InfectedPotion(24000 * 8, 0));
	public static final RegistryObject<InfectedPotion> INFECTED_SEVERE = POTIONS.register("infected_severe", () -> new InfectedPotion(24000 * 14, 1));
	public static final RegistryObject<InfectedPotion> INFECTED_CRITICAL = POTIONS.register("infected_critical", () -> new InfectedPotion(24000 * 25, 2));
	
	public static void registerMod(IEventBus bus) {
		POTIONS.register(bus);
	}
	
}

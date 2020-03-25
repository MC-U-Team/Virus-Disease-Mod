package info.u_team.virus_disease_spread.config;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.*;

public class CommonConfig {
	
	public static final ForgeConfigSpec CONFIG;
	private static final CommonConfig INSTANCE;
	
	static {
		final Pair<CommonConfig, ForgeConfigSpec> pair = new Builder().configure(CommonConfig::new);
		CONFIG = pair.getRight();
		INSTANCE = pair.getLeft();
	}
	
	public static CommonConfig getInstance() {
		return INSTANCE;
	}
	
	public final IntValue maxHealth;
	
	public final IntValue howManyDaysInfected;
	
	public final IntValue chancePerTickToGetHigherInfectionProbability;
	
	public final IntValue bedRadius;
	
	private CommonConfig(Builder builder) {
		builder.comment("Settings").push("settings");
		maxHealth = builder.comment("How many health points you have when infected").defineInRange("maxHealth", 4, 1, 20);
		howManyDaysInfected = builder.comment("How many days should a player be infected").defineInRange("howManyDaysInfected", 20, 1, 30);
		chancePerTickToGetHigherInfectionProbability = builder.comment("The lower the value the higher the chance that the infection probability gets higher").defineInRange("chancePerTickToGetHigherInfectionRate", 200, 1, 500);
		bedRadius = builder.comment("The bed radius that defines if the player is in his base. The bed only counts if its the players spawn point").defineInRange("bedRadius", 30, 5, 100);
		builder.pop();
	}
	
}

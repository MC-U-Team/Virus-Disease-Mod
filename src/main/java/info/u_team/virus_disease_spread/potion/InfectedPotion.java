package info.u_team.virus_disease_spread.potion;

import info.u_team.u_team_core.potion.UPotion;
import info.u_team.virus_disease_spread.init.VirusDiseaseSpreadEffects;
import net.minecraft.potion.EffectInstance;

public class InfectedPotion extends UPotion {
	
	public InfectedPotion(String name, int duration, int amplifier) {
		super(name, "infected", new EffectInstance(VirusDiseaseSpreadEffects.INFECTED, duration, amplifier));
	}
}

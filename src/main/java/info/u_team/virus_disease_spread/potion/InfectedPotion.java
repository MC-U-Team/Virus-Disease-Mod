package info.u_team.virus_disease_spread.potion;

import info.u_team.virus_disease_spread.init.VirusDiseaseSpreadEffects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Potion;

public class InfectedPotion extends Potion {
	
	public InfectedPotion(int duration, int amplifier) {
		super("infected", new EffectInstance(VirusDiseaseSpreadEffects.INFECTED.get(), duration, amplifier));
	}
}

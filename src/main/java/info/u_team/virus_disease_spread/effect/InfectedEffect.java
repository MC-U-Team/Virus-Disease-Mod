package info.u_team.virus_disease_spread.effect;

import java.util.Random;

import info.u_team.u_team_core.effect.UEffect;
import info.u_team.virus_disease_spread.config.CommonConfig;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.*;

public class InfectedEffect extends UEffect {
	
	private final Random random;
	
	public InfectedEffect(String name) {
		super(name, EffectType.HARMFUL, 0x258573);
		random = new Random();
	}
	
	@Override
	public void performEffect(LivingEntity entityLivingBase, int amplifier) {
		entityLivingBase.setHealth(CommonConfig.getInstance().maxHealth.get());
		if (random.nextInt(60) == 0) {
			entityLivingBase.addPotionEffect(new EffectInstance(Effects.NAUSEA, 200, Math.max(0, 2 * amplifier - 1)));
		}
		if (random.nextInt(100) == 0) {
			entityLivingBase.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 100, Math.max(0, 2 * amplifier - 1)));
		}
	}
	
	@Override
	public boolean isReady(int duration, int amplifier) {
		return random.nextInt(Math.max(20 - (amplifier * 2), 2)) == 0;
	}
}

package info.u_team.virus_disease_spread.handler;

import info.u_team.virus_disease_spread.config.CommonConfig;
import info.u_team.virus_disease_spread.init.VirusDiseaseSpreadEffects;
import net.minecraft.block.BlockState;
import net.minecraft.block.CauldronBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.PotionEvent.PotionRemoveEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.eventbus.api.IEventBus;

public class CommonEventHandler {
	
	public static void onLivingUpdate(LivingUpdateEvent event) {
		if (!(event.getEntityLiving() instanceof ServerPlayerEntity)) {
			return;
		}
		final ServerPlayerEntity player = (ServerPlayerEntity) event.getEntityLiving();
		final World world = player.getEntityWorld();
		
		if (world.getGameTime() - player.getPersistentData().getInt("washStartTime") > 200) {
			player.getPersistentData().putInt("wash", 0);
		}
		
		if (player.getActivePotionEffect(VirusDiseaseSpreadEffects.INFECTED.get()) != null) {
			if (world.getRandom().nextInt(50) == 0) {
				final PlayerEntity other = world.getClosestPlayer(player, 3);
				if (other != null && player != other) {
					if (other.getActivePotionEffect(VirusDiseaseSpreadEffects.INFECTED.get()) == null) {
						if (player.getDistance(other) < 1) {
							updateInfection(other, 90);
						}
						updateInfection(other, 30);
					}
				}
			}
			return;
		}
		
		if (isInBase(player)) {
			if (world.getRandom().nextInt(500) == 0) {
				updateInfection(player, -1);
			}
		} else {
			if (world.getRandom().nextInt(CommonConfig.getInstance().chancePerTickToGetHigherInfectionProbability.get()) == 0) {
				int value = getInfection(player) + world.getRandom().nextInt(3) + 1;
				if (value >= 100) {
					value = 0;
					player.addPotionEffect(new EffectInstance(VirusDiseaseSpreadEffects.INFECTED.get(), 24000 * CommonConfig.getInstance().howManyDaysInfected.get(), world.getRandom().nextInt(3), false, false));
				}
				setInfection(player, value);
			}
		}
	}
	
	public static void onRightClickBlock(RightClickBlock event) {
		final World world = event.getWorld();
		final BlockPos pos = event.getPos();
		final BlockState state = world.getBlockState(pos);
		final PlayerEntity player = event.getPlayer();
		
		if (world.isRemote() || !(state.getBlock() instanceof CauldronBlock)) {
			return;
		}
		final int level = state.get(CauldronBlock.LEVEL);
		if (level == 0) {
			return;
		}
		player.getPersistentData().putLong("washStartTime", world.getGameTime());
		
		int value = player.getPersistentData().getInt("wash") + 1;
		
		if (value > 90) {
			value = 90;
		}
		
		if (world instanceof ServerWorld) {
			final ServerWorld serverWorld = (ServerWorld) world;
			serverWorld.spawnParticle(ParticleTypes.FALLING_WATER, pos.getX() + 0.5, pos.getY() + 0.8, pos.getZ() + 0.5, 30, 0.3, 0.2, 0.3, 0.1);
		}
		player.sendStatusMessage(new TranslationTextComponent("event.virusdiseasespread.washing_message", (int) Math.floor((value / 90D) * 100)), true);
		
		if (value == 90) {
			value = 0;
			setInfection(player, 0);
			world.setBlockState(pos, state.with(CauldronBlock.LEVEL, level - 1));
		}
		
		player.getPersistentData().putInt("wash", value);
	}
	
	public static void onPotionRemove(PotionRemoveEvent event) {
		if (event.getPotion() == VirusDiseaseSpreadEffects.INFECTED.get()) {
			event.setCanceled(true);
		}
	}
	
	public static void registerForge(IEventBus bus) {
		bus.addListener(CommonEventHandler::onLivingUpdate);
		bus.addListener(CommonEventHandler::onRightClickBlock);
		bus.addListener(CommonEventHandler::onPotionRemove);
	}
	
	// Helper methods for the event handler
	
	private static void setInfection(PlayerEntity player, int value) {
		player.getPersistentData().putInt("infection", value);
	}
	
	private static int getInfection(PlayerEntity player) {
		return player.getPersistentData().getInt("infection");
	}
	
	private static void updateInfection(PlayerEntity player, int value) {
		setInfection(player, Math.max(0, Math.min(100, getInfection(player) + value)));
	}
	
	private static boolean isInBase(ServerPlayerEntity player) {
		if (player.func_241141_L_() != player.world.getDimensionKey()) {
			return false;
		}
		
		final BlockPos spawnPos = player.func_241140_K_();
		if (spawnPos == null) {
			return false;
		}
		return spawnPos.withinDistance(player.getPosition(), CommonConfig.getInstance().bedRadius.get());
	}
	
}

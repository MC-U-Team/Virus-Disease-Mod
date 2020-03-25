package info.u_team.virus_disease_spread.item;

import info.u_team.u_team_core.item.UItem;
import info.u_team.virus_disease_spread.init.VirusDiseaseSpreadItemGroups;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class ProbabilityTestItem extends UItem {
	
	public ProbabilityTestItem(String name) {
		super(name, VirusDiseaseSpreadItemGroups.GROUP, new Properties().maxDamage(10).rarity(Rarity.RARE));
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
		final ItemStack stack = player.getHeldItem(hand);
		if (!world.isRemote()) {
			stack.damageItem(1, player, $ -> {
			});
			player.sendMessage(new TranslationTextComponent("event.virusdiseasespread.infection_prob_message", player.getPersistentData().getInt("infection")));
		}
		return new ActionResult<>(ActionResultType.SUCCESS, stack);
	}
	
}

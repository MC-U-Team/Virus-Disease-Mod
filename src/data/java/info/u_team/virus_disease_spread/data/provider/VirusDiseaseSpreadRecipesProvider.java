package info.u_team.virus_disease_spread.data.provider;

import java.util.function.Consumer;

import info.u_team.u_team_core.data.CommonRecipesProvider;
import info.u_team.u_team_core.data.GenerationData;
import info.u_team.virus_disease_spread.init.VirusDiseaseSpreadItems;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;

public class VirusDiseaseSpreadRecipesProvider extends CommonRecipesProvider {
	
	public VirusDiseaseSpreadRecipesProvider(GenerationData data) {
		super(data);
	}
	
	@Override
	protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
		ShapelessRecipeBuilder.shapelessRecipe(VirusDiseaseSpreadItems.PROBABILITY_TEST.get()) //
				.addIngredient(Ingredient.fromStacks(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.WATER))) //
				.addIngredient(Items.STICK) //
				.addIngredient(Items.IRON_NUGGET) //
				.addCriterion("has_iron_nugget", hasItem(Items.IRON_NUGGET)) //
				.build(consumer);
	}
	
}

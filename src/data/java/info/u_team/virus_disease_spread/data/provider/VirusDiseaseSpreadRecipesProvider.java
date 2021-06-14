package info.u_team.virus_disease_spread.data.provider;

import java.util.function.Consumer;

import info.u_team.u_team_core.data.*;
import info.u_team.virus_disease_spread.init.VirusDiseaseSpreadItems;
import net.minecraft.data.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.*;

public class VirusDiseaseSpreadRecipesProvider extends CommonRecipesProvider {
	
	public VirusDiseaseSpreadRecipesProvider(GenerationData data) {
		super(data);
	}
	
	@Override
	protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
		ShapelessRecipeBuilder.shapelessRecipe(VirusDiseaseSpreadItems.PROBABILITY_TEST) //
				.addIngredient(Ingredient.fromStacks(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.WATER))) //
				.addIngredient(Items.STICK) //
				.addIngredient(Items.IRON_NUGGET) //
				.addCriterion("has_iron_nugget", hasItem(Items.IRON_NUGGET)) //
				.build(consumer);
	}
	
}

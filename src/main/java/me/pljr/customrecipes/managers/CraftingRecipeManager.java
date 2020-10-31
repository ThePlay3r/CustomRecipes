package me.pljr.customrecipes.managers;

import me.pljr.customrecipes.config.CfgCraftingRecipes;
import me.pljr.customrecipes.objects.CraftingRecipe;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ShapedRecipe;

import java.util.Map;

public class CraftingRecipeManager {
    public void load(){
        for (Map.Entry<String, CraftingRecipe> entry : CfgCraftingRecipes.recipes.entrySet()){
            CraftingRecipe craftingRecipe = entry.getValue();
            ShapedRecipe recipe = new ShapedRecipe(craftingRecipe.getResult());
            recipe.shape(craftingRecipe.getRow1(), craftingRecipe.getRow2(), craftingRecipe.getRow3());
            for (Map.Entry<Character, Material> ingredient : craftingRecipe.getIngredients().entrySet()){
                recipe.setIngredient(ingredient.getKey(), ingredient.getValue());
            }
            Bukkit.addRecipe(recipe);
        }
    }
}

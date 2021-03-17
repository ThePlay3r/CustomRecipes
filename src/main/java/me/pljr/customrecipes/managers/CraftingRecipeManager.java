package me.pljr.customrecipes.managers;

import me.pljr.customrecipes.config.CraftingRecipes;
import me.pljr.customrecipes.objects.CraftingRecipe;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ShapedRecipe;

import java.util.Map;

public class CraftingRecipeManager {

    public CraftingRecipeManager(CraftingRecipes craftingRecipes){
        for (Map.Entry<String, CraftingRecipe> entry : craftingRecipes.getRecipes().entrySet()){
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

package me.pljr.customrecipes.managers;

import me.pljr.customrecipes.config.FurnaceRecipes;
import me.pljr.customrecipes.objects.CoreFurnaceRecipe;
import org.bukkit.Bukkit;
import org.bukkit.inventory.FurnaceRecipe;

import java.util.Map;

public class FurnaceRecipeManager {

    public FurnaceRecipeManager(FurnaceRecipes furnaceRecipes){
        for (Map.Entry<String, CoreFurnaceRecipe> entry : furnaceRecipes.getRecipes().entrySet()){
            CoreFurnaceRecipe coreFurnaceRecipe = entry.getValue();
            FurnaceRecipe recipe = new FurnaceRecipe(coreFurnaceRecipe.getResult(), coreFurnaceRecipe.getIngredient());
            Bukkit.addRecipe(recipe);
        }
    }
}

package me.pljr.customrecipes.config;

import me.pljr.customrecipes.objects.CraftingRecipe;
import me.pljr.pljrapi.managers.ConfigManager;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class CfgCraftingRecipes {
    public static HashMap<String, CraftingRecipe> recipes;

    public static void load(ConfigManager config){
        CfgCraftingRecipes.recipes = new HashMap<>();
        ConfigurationSection recipes = config.getConfigurationSection("crafting-recipes");
        if (recipes != null){
            for (String recipe : recipes.getKeys(false)){
                String row1 = config.getString("crafting-recipes."+recipe+".shape.row-1");
                String row2 = config.getString("crafting-recipes."+recipe+".shape.row-2");
                String row3 = config.getString("crafting-recipes."+recipe+".shape.row-3");
                HashMap<Character, Material> ingredients = new HashMap<>();
                ConfigurationSection ingredientsCs = config.getConfigurationSection("crafting-recipes."+recipe+".ingredients");
                for (String ingredient : ingredientsCs.getKeys(false)){
                    ingredients.put(ingredient.charAt(0), config.getMaterial("crafting-recipes."+recipe+".ingredients."+ingredient));
                }
                ItemStack result = config.getSimpleItemStack("crafting-recipes."+recipe+".result");
                CfgCraftingRecipes.recipes.put(recipe, new CraftingRecipe(row1, row2, row3, ingredients, result));
            }
        }
    }
}

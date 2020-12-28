package me.pljr.customrecipes.config;

import me.pljr.customrecipes.objects.CoreFurnaceRecipe;
import me.pljr.pljrapispigot.managers.ConfigManager;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class CfgFurnaceRecipes {
    public static HashMap<String, CoreFurnaceRecipe> recipes;

    public static void load(ConfigManager config){
        CfgFurnaceRecipes.recipes = new HashMap<>();
        ConfigurationSection recipes = config.getConfigurationSection("furnace-recipes");
        if (recipes != null){
            for (String recipe : recipes.getKeys(false)){
                Material ingredient = config.getMaterial("furnace-recipes."+recipe+".ingredient");
                ItemStack result = config.getSimpleItemStack("furnace-recipes."+recipe+".result");
                CfgFurnaceRecipes.recipes.put(recipe, new CoreFurnaceRecipe(ingredient, result));
            }
        }
    }
}

package me.pljr.customrecipes.config;

import lombok.Getter;
import me.pljr.customrecipes.objects.CoreFurnaceRecipe;
import me.pljr.pljrapispigot.managers.ConfigManager;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

@Getter
public class FurnaceRecipes {
    private final HashMap<String, CoreFurnaceRecipe> recipes;

    public FurnaceRecipes(ConfigManager config){
        recipes = new HashMap<>();
        ConfigurationSection recipes = config.getConfigurationSection("furnace-recipes");
        if (recipes != null){
            for (String recipe : recipes.getKeys(false)){
                Material ingredient = config.getMaterial("furnace-recipes."+recipe+".ingredient");
                ItemStack result = config.getSimpleItemStack("furnace-recipes."+recipe+".result");
                this.recipes.put(recipe, new CoreFurnaceRecipe(ingredient, result));
            }
        }
    }
}

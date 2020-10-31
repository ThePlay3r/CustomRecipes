package me.pljr.customrecipes.objects;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class CoreFurnaceRecipe {
    private final Material ingredient;
    private final ItemStack result;

    public CoreFurnaceRecipe(Material ingredient, ItemStack result){
        this.ingredient = ingredient;
        this.result = result;
    }

    public Material getIngredient() {
        return ingredient;
    }

    public ItemStack getResult() {
        return result;
    }
}

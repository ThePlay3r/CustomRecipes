package me.pljr.customrecipes.objects;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class CraftingRecipe {
    private final String row1, row2, row3;
    private final HashMap<Character, Material> ingredients;
    private final ItemStack result;

    public CraftingRecipe(String row1, String row2, String row3, HashMap<Character, Material> ingredients, ItemStack result){
        this.row1 = row1;
        this.row2 = row2;
        this.row3 = row3;
        this.ingredients = ingredients;
        this.result = result;
    }

    public String getRow1() {
        return row1;
    }

    public String getRow2() {
        return row2;
    }

    public String getRow3() {
        return row3;
    }

    public HashMap<Character, Material> getIngredients() {
        return ingredients;
    }

    public ItemStack getResult() {
        return result;
    }
}

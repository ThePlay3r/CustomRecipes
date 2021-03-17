package me.pljr.customrecipes;

import me.pljr.customrecipes.config.CraftingRecipes;
import me.pljr.customrecipes.config.FurnaceRecipes;
import me.pljr.customrecipes.managers.CraftingRecipeManager;
import me.pljr.customrecipes.managers.FurnaceRecipeManager;
import me.pljr.pljrapispigot.managers.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomRecipes extends JavaPlugin {

    private CraftingRecipes craftingRecipes;
    private FurnaceRecipes furnaceRecipes;

    @Override
    public void onEnable() {
        // Plugin startup logic
        setupConfig();
        setupManagers();
    }

    private void setupConfig(){
        saveDefaultConfig();
        ConfigManager configManager = new ConfigManager(this, "config.yml");
        craftingRecipes = new CraftingRecipes(configManager);
        furnaceRecipes = new FurnaceRecipes(configManager);
    }

    private void setupManagers(){
        new CraftingRecipeManager(craftingRecipes);
        new FurnaceRecipeManager(furnaceRecipes);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

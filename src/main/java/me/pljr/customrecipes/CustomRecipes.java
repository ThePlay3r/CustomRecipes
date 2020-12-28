package me.pljr.customrecipes;

import me.pljr.customrecipes.config.CfgCraftingRecipes;
import me.pljr.customrecipes.config.CfgFurnaceRecipes;
import me.pljr.customrecipes.managers.CraftingRecipeManager;
import me.pljr.customrecipes.managers.FurnaceRecipeManager;
import me.pljr.pljrapispigot.managers.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomRecipes extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        setupConfig();
        setupManagers();
    }

    private void setupConfig(){
        saveDefaultConfig();
        ConfigManager configManager = new ConfigManager(this, "config.yml");
        CfgCraftingRecipes.load(configManager);
        CfgFurnaceRecipes.load(configManager);
    }

    private void setupManagers(){
        CraftingRecipeManager craftingRecipeManager = new CraftingRecipeManager();
        craftingRecipeManager.load();
        FurnaceRecipeManager furnaceRecipeManager = new FurnaceRecipeManager();
        furnaceRecipeManager.load();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

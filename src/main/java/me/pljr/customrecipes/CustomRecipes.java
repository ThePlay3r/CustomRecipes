package me.pljr.customrecipes;

import me.pljr.customrecipes.config.CfgCraftingRecipes;
import me.pljr.customrecipes.config.CfgFurnaceRecipes;
import me.pljr.customrecipes.managers.CraftingRecipeManager;
import me.pljr.customrecipes.managers.FurnaceRecipeManager;
import me.pljr.pljrapi.PLJRApi;
import me.pljr.pljrapi.managers.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomRecipes extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        if (!setupPLJRApi()) return;
        setupConfig();
        setupManagers();
    }

    private boolean setupPLJRApi(){
        PLJRApi api = (PLJRApi) Bukkit.getServer().getPluginManager().getPlugin("PLJRApi");
        if (api == null){
            Bukkit.getConsoleSender().sendMessage("§cCustomRecipes: PLJRApi not found, disabling plugin!");
            getServer().getPluginManager().disablePlugin(this);
            return false;
        }else{
            Bukkit.getConsoleSender().sendMessage("§aCustomRecipes: Hooked into PLJRApi!");
            return true;
        }
    }

    private void setupConfig(){
        saveDefaultConfig();
        ConfigManager configManager = new ConfigManager(getConfig(), "§cCustomRecipes:", "config.yml");
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

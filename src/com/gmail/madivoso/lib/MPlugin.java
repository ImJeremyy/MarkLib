package com.gmail.madivoso.lib;

import com.gmail.madivoso.lib.assets.MConfig;
import com.gmail.madivoso.lib.managers.CommandManager;
import com.gmail.madivoso.lib.assets.MCommand;
import com.gmail.madivoso.lib.managers.ConfigManager;
import com.gmail.madivoso.lib.managers.ListenerManager;
import com.gmail.madivoso.lib.assets.MListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public abstract class MPlugin extends JavaPlugin {

    private String name;
    private Logger logger;

    private CommandManager m_cmd;
    private ListenerManager m_lis;
    private ConfigManager m_config;

    public MPlugin(String name) {
        this.name = name;
        this.logger = getLogger();
    }

    public void onEnable() {
        logger.info(name + " has been enabled!");
        initializeManagers();
        registerConfigs();
        registerCommands();
        registerListeners();
        registerAssets();
    }

    public void onDisable() {
        logger.info(name + " has been disabled!");
        pushCache();
    }

    public abstract void registerCommands();

    public abstract void registerListeners();

    public abstract void registerConfigs();

    public void addCommand(MCommand cmd) {
        m_cmd.addCommand(cmd);
    }

    public void addListener(MListener lis) {
        m_lis.addListener(lis);
    }

    public void addConfig(MConfig config) {
        m_config.addConfig(config);
    }

    private void pushCache() {
        for(MConfig config : m_config.getConfigs()) {
            config.push();
        }
    }

    private void initializeManagers() {
        m_cmd = new CommandManager();
        m_lis = new ListenerManager();
        m_config = new ConfigManager();
    }

    private void registerAssets() {
        for(MCommand cmd : m_cmd.getCommands()) {
            getCommand(cmd.getName()).setExecutor(cmd);
        }
        for(MListener lis : m_lis.getListeners()) {
            getServer().getPluginManager().registerEvents(lis, this);
        }
        for(MConfig config : m_config.getConfigs()) {
            config.pull();
        }
    }

}

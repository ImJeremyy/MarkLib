package com.gmail.madivoso.lib;

import com.gmail.madivoso.lib.assets.MConfig;
import com.gmail.madivoso.lib.assets.MDatabase;
import com.gmail.madivoso.lib.managers.CommandManager;
import com.gmail.madivoso.lib.assets.MCommand;
import com.gmail.madivoso.lib.managers.ConfigManager;
import com.gmail.madivoso.lib.managers.DatabaseManager;
import com.gmail.madivoso.lib.managers.ListenerManager;
import com.gmail.madivoso.lib.assets.MListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;
import java.util.logging.Logger;

public abstract class MPlugin extends JavaPlugin {

    private String name;
    private Logger logger;

    private ConfigManager m_config;
    private DatabaseManager m_database;
    private ListenerManager m_lis;
    private CommandManager m_cmd;

    public MPlugin(String name) {
        this.name = name;
        this.logger = getLogger();
    }

    public void onEnable() {
        instantiateAssets();
        initializeManagers();
        registerConfigs();
        registerDatabase();
        registerListeners();
        registerCommands();
        registerAssets();
        logger.info(name + " has been enabled!");
    }

    public void onDisable() {
        pushCache();
        closeDatabase();
        logger.info(name + " has been disabled!");
    }

    public abstract void instantiateAssets();

    public abstract void registerConfigs();

    public abstract void registerDatabase();

    public abstract void registerListeners();

    public abstract void registerCommands();

    public void addConfig(MConfig config) {
        m_config.addConfig(config);
    }

    public void addDatabase(MDatabase database) {
        m_database.addDatabase(database);
    }

    public void addListener(MListener lis) {
        m_lis.addListener(lis);
    }

    public void addCommand(MCommand cmd) {
        m_cmd.addCommand(cmd);
    }

    private void pushCache() {
        for(MConfig config : m_config.getConfigs()) {
            config.push();
        }
    }

    private void closeDatabase() {
        try {
            for (MDatabase db : m_database.getDatabases()) {
                if(db.connectionExists()) db.closeConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initializeManagers() {
        m_cmd = new CommandManager();
        m_lis = new ListenerManager();
        m_config = new ConfigManager();
        m_database = new DatabaseManager();
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

package com.gmail.madivoso.example;

import com.gmail.madivoso.lib.MPlugin;

public class MarkLibTestPlugin extends MPlugin {

    private Config config;
    private Database db;

    public MarkLibTestPlugin() {
        super("MarkLibTest");
    }

    @Override
    public void onEnable() {
        config = new Config(this);
        super.onEnable();
    }

    @Override
    public void registerCommands() {
        super.addCommand(new HelloCommand(config, db));
    }

    @Override
    public void registerListeners() {
        super.addListener(new JoinListener());
    }

    @Override
    public void registerConfigs() {
        super.addConfig(config);
    }

    @Override
    public void registerDatabase() {
        db = new Database(Settings.host, Settings.dbName, Settings.port, Settings.username, Settings.password);
    }
}

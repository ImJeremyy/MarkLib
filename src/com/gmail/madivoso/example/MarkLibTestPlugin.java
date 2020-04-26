package com.gmail.madivoso.example;

import com.gmail.madivoso.lib.MPlugin;

public class MarkLibTestPlugin extends MPlugin {

    private Config config;

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
        super.addCommand(new HelloCommand(config));
    }

    @Override
    public void registerListeners() {
        super.addListener(new JoinListener());
    }

    @Override
    public void registerConfigs() {
        super.addConfig(config);
    }
}

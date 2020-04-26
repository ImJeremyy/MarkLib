package com.gmail.madivoso.lib.managers;

import com.gmail.madivoso.lib.assets.MConfig;

import java.util.ArrayList;
import java.util.List;

public class ConfigManager {

    private List<MConfig> configs;

    public ConfigManager() {
        configs = new ArrayList<>();
    }

    public void addConfig(MConfig config) {
        configs.add(config);
    }

    public List<MConfig> getConfigs() {
        return configs;
    }

}

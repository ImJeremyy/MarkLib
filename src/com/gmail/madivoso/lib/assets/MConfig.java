package com.gmail.madivoso.lib.assets;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;

public abstract class MConfig {

    private File file;
    private FileConfiguration config;

    public abstract void push();

    public abstract void pull();

    protected abstract void defaultConfig();

    protected MConfig(File dataFolder, String name) {
        this(dataFolder.getPath(), name);
    }

    protected MConfig(String path, String name) {
        createFile(path, name);
        defaultConfig();
        pull();
    }

    protected void save() {
        try {
            config.save(file);
        } catch (IOException e) {
            //TODO
        }
    }

    protected void addDefault(String path, String value) {
        if(!config.contains(path)) {
            config.set(path, value);
        }
    }

    protected Object get(String path) {
        return config.get(path);
    }

    protected String getString(String path) {
        return config.getString(path);
    }

    protected double getDouble(String path) {
        return config.getDouble(path);
    }

    protected int getInt(String path) {
        return config.getInt(path);
    }

    protected List<?> getList(String path) {
        return config.getList(path);
    }

    protected void set(String path, String value) {
        config.set(path, value);
    }

    private void createFile(String path, String fileName) {
        file = new File(path, fileName + ".yml");
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
                return;
            }
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

}

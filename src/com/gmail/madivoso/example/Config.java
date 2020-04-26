package com.gmail.madivoso.example;

import com.gmail.madivoso.lib.assets.MConfig;

public class Config extends MConfig {

    private String message; //eg: Hello, %player%!

    public Config(MarkLibTestPlugin plugin) {
        super(plugin.getDataFolder(), "message");
    }

    public String getMessage() {
        return message;
    }

    public void pull() {
        message = super.getString("message");
    }

    public void push() {
        super.set("message", message);
        super.save();
    }

    protected void defaultConfig() {
        super.addDefault("message", "&eHello there, %player%!!");
        super.save();
    }

}

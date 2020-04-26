package com.gmail.madivoso.example;

import com.gmail.madivoso.lib.utility.Util;
import com.gmail.madivoso.lib.assets.MCommand;
import org.bukkit.command.CommandSender;

public class HelloCommand extends MCommand {

    private Config config;

    public HelloCommand(Config config) {
        super("marklibtest", "hello", Util.colourize("&cYou do not have permission to this command!"));
        this.config = config;
    }

    @Override
    public void execute(CommandSender sender, String name, String[] args) {
        String toSend = config.getMessage().replaceAll("%player%", sender.getName());
        sender.sendMessage(Util.colourize(toSend));
    }
}

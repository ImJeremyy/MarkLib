package com.gmail.madivoso.example;

import com.gmail.madivoso.lib.Util;
import com.gmail.madivoso.lib.assets.MListener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener extends MListener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(Util.colourize("&e" + player.getName() + " has joined!"));
    }

}

package com.gmail.madivoso.example;

import com.gmail.madivoso.lib.assets.MDatabase;
import com.gmail.madivoso.lib.utility.MySQLUtil;
import org.bukkit.command.CommandSender;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Database extends MDatabase {

    public Database(String host, String dbName, int port, String user, String pass) {
        super(host, dbName, port, user, pass);
    }

    public void registerPlayer(String player) {
        String name = player;
        try {
            List<String[]> lines = MySQLUtil.getLines(prepareStatement("SELECT * FROM players;"));
            boolean found = false;
            for(String[] line : lines) {
                String user = line[0];
                String hello = line[1];
                if(user.equalsIgnoreCase(name)) {
                    found = true;
                    break;
                }
            }

            if(!found) {
                createStatement("INSERT INTO players (username, hello) VALUES (\'" + name + "\', \'1\');");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewPlayers() {
        try {
            ResultSet rs = prepareStatement("SELECT * FROM players;");
            List<String[]> lines = MySQLUtil.getLines(rs);
            for(String[] s : lines) {
                for(int i = 0; i < s.length; i++) {
                    if(i > 0) {
                        System.out.print(", ");
                    }
                    System.out.print(s[i]);
                }
                System.out.println("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createDatabase() {

    }

}

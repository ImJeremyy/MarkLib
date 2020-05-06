package com.gmail.madivoso.example;

import com.gmail.madivoso.lib.assets.MDatabase;
import com.gmail.madivoso.lib.utility.MySQLUtil;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

public class Database extends MDatabase {

    public Database(String host, String dbName, int port, String user, String pass) {
        super(host, dbName, port, user, pass);
    }

    public void registerPlayer(String player) {
        String name = player;
        try {
            List<String[]> lines = MySQLUtil.getLines(prepareStatement("SELECT * FROM players WHERE username=\'" + player + "\';"));
            boolean found = !lines.isEmpty();
            if(!found) {
                System.out.println("Not found..");
                createStatement("INSERT INTO players (username, hello) VALUES (\'" + name + "\', \'1\');");
            } else {
                System.out.println("Found!");
                String user = lines.get(0)[0];
                int helloCount = Integer.parseInt(lines.get(0)[1]) + 1;
                createStatement("UPDATE players SET hello=\'" + helloCount + "\' WHERE username=\'" + user + "\';");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewPlayers() {
        try {
            ResultSet rs = prepareStatement("SELECT * FROM players;");
            ResultSetMetaData meta = rs.getMetaData();
            for(int i = 1; i <= meta.getColumnCount(); i++) {
                if(i > 1) {
                    System.out.print(", ");
                }
                System.out.print(meta.getColumnLabel(i));
            }
            System.out.println("");
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

    public void defaultDatabase() {

    }

}

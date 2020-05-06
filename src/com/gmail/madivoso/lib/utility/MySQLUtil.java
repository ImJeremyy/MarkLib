package com.gmail.madivoso.lib.utility;

import com.gmail.madivoso.lib.assets.MDatabase;
import com.mysql.cj.protocol.Resultset;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLUtil {

    public static String getMySQLURL(String host, int port, String databaseName) {
        String url = "jdbc:mysql://" + host + ":" + port + "/" + databaseName;
        return url;
    }

    public static String getMySQLURL(MDatabase db) {
        return getMySQLURL(db.getHost(), db.getPort(), db.getDatabaseName());
    }

    public static void displayResultSet(ResultSet rs) throws SQLException {
        ResultSetMetaData meta = rs.getMetaData();
        int columnsNumber = meta.getColumnCount();
        for(int i = 1; i <= columnsNumber; i++) {
            if (i > 1) System.out.print(", ");
            System.out.print(meta.getColumnName(i));
        }
        System.out.println("===========");
        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = rs.getString(i);
                System.out.print(columnValue);
            }
            System.out.println("");
        }
    }

    public static List<String[]> getLines(ResultSet rs) throws SQLException {
        List<String[]> lines = new ArrayList<>();
        ResultSetMetaData meta = rs.getMetaData();
        int columnsNumber = meta.getColumnCount();
        while(rs.next()) {
            String[] data = new String[columnsNumber];
            for(int i = 1; i <= columnsNumber; i++) {
                String value = rs.getString(i);
                data[i-1] = value;
            }
            lines.add(data);
        }
        return lines;
    }

}

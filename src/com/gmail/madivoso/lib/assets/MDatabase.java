package com.gmail.madivoso.lib.assets;

import com.gmail.madivoso.lib.utility.MySQLUtil;

import java.sql.*;

public abstract class MDatabase {

    private String host; 		//host address (eg: "localhost")
    private String database; 	//name of database (eg: "lemon")
    private int port; 			//port (eg: 3306)
    private String username; 	//username for database priveleges (eg: "root")
    private String password; 	//password for database priveleges (eg: "password" or null)

    private Connection con;

    public MDatabase(String host, String databaseName, int port, String username, String password) {
        this.host = host;
        this.database = databaseName;
        this.port = port;
        this.username = username;
        this.password = password;
        if(!connectionExists()) {
            openConnection();
        }
        if(connectionExists()) {
            createDatabase();
        }
    }

    /**
     * Initializes database & tables if not already created.
     */
    public abstract void createDatabase();

    public String getHost() {
        return host;
    }

    public String getDatabaseName() {
        return database;
    }

    public int getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Connection getConnection() {
        return con;
    }

    public ResultSet prepareStatement(String query) throws SQLException {
        PreparedStatement st = con.prepareStatement(query);
        ResultSet rs = st.executeQuery();
        return rs;
    }

    public void createStatement(String query) throws SQLException {
        Statement st = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
        st.execute(query);
    }

    private void openConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(MySQLUtil.getMySQLURL(host, port, database), username, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private boolean connectionExists() {
        try {
            return con != null && !con.isClosed();
        } catch (SQLException ex) {
            return false;
        }
    }

}

package TablesGUI_7_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

    Connection conn;
    Statement statement;
    private String driver = "com.mysql.cj.jdbc.Driver";

    private boolean isConnected = false;
    private String url;

    DatabaseManager(String url) {

        this.url = url;
    }

    public boolean login(String user, String pass) {
        this.connect(user, pass);

        return this.isConnected;
    }

    private void connect(String user, String pass) {
        try {
            Class.forName(driver);
            this.conn = DriverManager.getConnection(url, user, pass);
            this.statement = conn.createStatement();

            System.out.println("Connection success!");
            isConnected = true;
        } catch (Exception e) {
            isConnected = false;
            e.printStackTrace();
        }
    }

    public ResultSet runQuery(String query) {

        ResultSet rs = null;
        try {
            rs = statement.executeQuery(query);
        } catch (SQLException e) {
            isConnected = false;
            e.printStackTrace();
        }
        if (rs != null) {
            return rs;
        } else return null;
    }

	public boolean isConnected() {
		return isConnected;
	}
}
package Registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private final String url = "jdbc:postgresql://localhost:5432/registration_swing";
    private final String user = "postgres";
    private final String password = "2m3410lt";

    public  Connection connect() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the postgreSQL server successfully!");
        }

        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}

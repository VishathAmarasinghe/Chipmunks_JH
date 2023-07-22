package chipmunks_jh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {
    private Connection con;
    public DatabaseConnection(){
        try {
            setCon(DriverManager.getConnection("jdbc:mysql://localhost:3306/LIPS", "root", ""));
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    public void closeDBcon() 
    {
        try {
            getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
}
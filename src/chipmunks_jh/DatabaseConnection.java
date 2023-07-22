package chipmunks_jh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {

    private Connection con;

    public DatabaseConnection() {
        try {
            setCon(DriverManager.getConnection("jdbc:mysql://localhost:3306/LIPS", "root", ""));
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void closeDBcon() {
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

    public void InsertBook(String ISBN, String Title, String CatID) throws SQLException {
        String statement = "INSERT INTO `Book`(`ISBN`, `TItle`, `CatID`) VALUES (?,?,?)";
        PreparedStatement ps = getCon().prepareStatement(statement);
        try {
            ps = getCon().prepareStatement(statement);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ps.setString(1, ISBN);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        ps.setString(1, Title);
        ps.setString(1, CatID);
        ps.executeUpdate();
        closeDBcon();
    }

    public void InsertCategory(String Category) throws SQLException {
        String statement = "INSERT INTO `Category`(`CatName`) VALUES (?)";
        PreparedStatement ps = getCon().prepareStatement(statement);
        try {
            ps = getCon().prepareStatement(statement);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ps.setString(1, Category);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        ps.executeUpdate();
        closeDBcon();

    }

    public int FindCategory(String CatName) throws ClassNotFoundException, SQLException {
        Statement statement = getCon().createStatement();
        String stmt = "SELECT `CatName` FROM `Category`";
        ResultSet rst = statement.executeQuery(stmt);
        if (rst.next()) {
            if (rst.getString(1) == CatName) {
                return 1;
            } else {
                return 0;
            }
        }
        closeDBcon();
        return 0;
    }
}

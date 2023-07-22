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
    }

    public void databaseConnection() throws ClassNotFoundException, SQLException {
        setCon(DriverManager.getConnection("jdbc:mysql://localhost:3306/LIPS", "root", ""));
    }

    public void closeDBcon() throws SQLException {
        getCon().close();
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public void InsertBook(String ISBN, String Title, String CatID) throws SQLException, ClassNotFoundException {
        databaseConnection();
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
        ps.setString(2, Title);
        ps.setString(3, CatID);
        ps.executeUpdate();

    }

    public void InsertCategory(String Category) throws SQLException, ClassNotFoundException {
        databaseConnection();
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

    }

    public int FindCategory(String CatName) throws ClassNotFoundException, SQLException {
        databaseConnection();
        Statement statement = getCon().createStatement();
        String stmt = "SELECT `CatName` FROM `Category`";
        ResultSet rst = statement.executeQuery(stmt);
        if (rst.next()) {
            if (rst.getString(1) == null ? CatName == null : rst.getString(1).equals(CatName)) {
                return 1;
            } else {
                return 0;
            }
        }
        closeDBcon();
        return 0;
    }

    public void UpdatetBook(String ISBN, String Title, String CatID) throws SQLException, ClassNotFoundException {
        databaseConnection();
        String statement = "UPDATE `Book` SET `ISBN`=?,`TItle`=?,`CatID`=? WHERE ISBN=ISBN;";
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
        ps.setString(2, Title);
        ps.setString(3, CatID);
        ps.executeUpdate();
    }
    public void reMoveBook(String ISBN) throws ClassNotFoundException, SQLException{
        databaseConnection();
        String statement="DELETE FROM `Book` WHERE ISBN = "+ISBN;
        PreparedStatement ps= getCon().prepareStatement(statement); 
        ps.executeUpdate();
        closeDBcon();
    }
}

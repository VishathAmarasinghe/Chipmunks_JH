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
            ps.setString(1, ISBN);
            ps.setString(2, Title);
        ps.setString(3, "1");
        ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        

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

    public boolean FindCategory(String CatName) throws ClassNotFoundException, SQLException {
        databaseConnection();
        Statement statement = getCon().createStatement();
        String stmt = "select count(*) from Category where CatName= '"+CatName+"'";
        ResultSet rst = statement.executeQuery(stmt);
        if (rst.next()) {
            if (rst.getInt(1)==0) {
                return false;
            } else {
                return true;
            }
        }
        closeDBcon();
        return false;
    }

    public void UpdatetBook(String ISBN, String Title, String CatID) throws SQLException, ClassNotFoundException {
        databaseConnection();
        String statement = "UPDATE `Book` SET `TItle`=?,`CatID`=? WHERE ISBN= '"+ISBN+"'";
        PreparedStatement ps = getCon().prepareStatement(statement);
        try {
            ps = getCon().prepareStatement(statement);
            ps.setString(1, Title);
        ps.setString(2, "1");
        ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void reMoveBook(String ISBN) throws ClassNotFoundException, SQLException{
        databaseConnection();
        String statement="DELETE FROM `Book` WHERE ISBN = '"+ISBN+"'";
        PreparedStatement ps= getCon().prepareStatement(statement); 
        ps.executeUpdate();
        closeDBcon();
    }
        public boolean ISBNChek(String ISBN) throws ClassNotFoundException, SQLException {
        databaseConnection();
        Statement statement = getCon().createStatement();
        String stmt = "select count(*) from book where ISBN='"+ISBN+"'";
        ResultSet rst = statement.executeQuery(stmt);
        if (rst.next()) {
            if (rst.getInt(1)==0) {
                return false;
            } else {
                return true;
            }
        }
        closeDBcon();
        return false;
    }
     public boolean ISBNcheckINcopy(int ISBN) throws ClassNotFoundException, SQLException{
         databaseConnection();
        Statement statement = getCon().createStatement();
        String stmt = "select count(*) from Book_copy where ISBN='"+ISBN+"'";
        ResultSet rst = statement.executeQuery(stmt);
        if (rst.next()) {
            if (rst.getInt(1)==0) {
                return false;
            } else {
                return true;
            }
        }
        closeDBcon();
        return false;
     }
     public void rData() throws ClassNotFoundException, SQLException{
         databaseConnection();
        Statement statement = getCon().createStatement();
        String stmt = "SELECT * FROM `Book`";
        ResultSet rst = statement.executeQuery(stmt);
        while(rst.next()){
            System.out.println(rst.getString(1)+"   "+rst.getString(2)+"    "+rst.getString(3));
        }
        closeDBcon();
     }
}

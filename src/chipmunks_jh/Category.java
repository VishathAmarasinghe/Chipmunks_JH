package chipmunks_jh;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Category extends Book {

    protected int categoryID;
    protected String categoryName;

    public Category() {
    }

    public Category(int categoryID, String categoryName) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }

    public Category(int categoryID, String categoryName, int ISBN, String Title) {
        super(ISBN, Title);
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void showCategory() {
        System.out.println("Category id: " + categoryID);
        System.out.println("Category name: " + categoryName);
    }

    public boolean checkCategory(String Category) {
        DatabaseConnection d1=new DatabaseConnection();
        boolean value = false;
        try {
            value = d1.FindCategory(Category);
            System.out.println(value);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }
    return value;
        
        
    }

}

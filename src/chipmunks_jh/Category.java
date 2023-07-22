package chipmunks_jh;

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
        int value=d1.FindCategory(Category);
        if (value==0) {
            return false;
        }else{
            return true;
        }
        
        
    }

}

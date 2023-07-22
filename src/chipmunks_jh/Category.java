package chipmunks_jh;

public class Category extends Book{
    protected int categoryID;
    protected String categoryName;

    public Category(int categoryID, String categoryName, int ISBN, String Title) {
        super(ISBN, Title);
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }


    public Category() {
    }

    public Category(int categoryID, String categoryName) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }
    
    public void showCategory(){
        System.out.println("Category id: "+categoryID);
        System.out.println("Category name: "+categoryName);
    }
    

    public boolean checkCategory(String Category){
        return true;
    }
    

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chipmunks_jh;

/**
 *
 * @author Akila
 */
public class Book {
   protected int ISBN;
   protected String Title;

    public Book(int ISBN, String Title) {
        this.ISBN = ISBN;
        this.Title = Title;
    }
   
   public Book(){
       
   }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }
   
    
   
    public void addBook(){
        
    }
    
    
    public void removeBook(){
        
    }
   
    
    public void updateBook(){
        
    }
    
    
   
    
    
}

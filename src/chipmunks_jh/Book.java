/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chipmunks_jh;

import java.util.Scanner;

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
        System.out.println("Adding a new Book");
        System.out.println("Enter the ISBN");
        Scanner scan=new  Scanner(System.in);
        try {
            int isbn=scan.nextInt();
            if (checkIsbn(isbn)) {
                String title=scan.nextLine();
                String category=scan.nextLine();
                Category c1=new Category();
                if (c1.checkCategory(category)) {
                    
                }else{
                    System.out.println("current Category is not in the category list");
                }

            }else{
                System.out.println("ISBN is already exisits");
            }
        } catch (Exception e) {
        }
        
        
    }
    
    
    public void removeBook(){
        
    }
   
    
    public void updateBook(){
        
    }
    
    
    private boolean checkIsbn(int isbn){
        return false;
        
    }
    
    
   
    
    
}

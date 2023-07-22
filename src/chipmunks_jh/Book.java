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
                System.out.println("Enter Title");
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
        System.out.println("Remove book a Book");
        System.out.println("Enter the ISBN");
        Scanner scan=new  Scanner(System.in);
        try {
            int isbn=scan.nextInt();
            if (checkIsbn(isbn)) {
                if (checkBookInReservation(isbn)) {
                    
                }else{
                    System.out.println("Areu sure you want to delete(Y/N)");
                    String values= scan.nextLine();
                    try {
                        if (values=="y") {
                            
                        }else{
                            System.out.println("invalid");
                        }
                    } catch (Exception e) {
                    }
                  
                }

            }else{
                System.out.println("ISBN is already exisits");
            }
        } catch (Exception e) {
        }

    }
   
    
    public void updateBook(){
        System.out.println("Update a Book");
        System.out.println("Enter the ISBN");
        Scanner scan=new  Scanner(System.in);
        try {
            int isbn=scan.nextInt();
            if (checkIsbn(isbn)) {
                System.out.println("Update a book");
                System.out.println("Update a new Title");
                String newTitle=scan.nextLine();
                System.out.println("Enter  new Category");
                String category=scan.nextLine();
                Category c1=new Category();
                if (c1.checkCategory(category)) {
                    System.out.println("Enter new Author");
                    String newautor=scan.nextLine();
                    Author a1=new Author();
                    if (a1.checkAuthor(newautor)) {
                        //update functionality
                    }else{
                        System.out.println("author is not available in the database");
                    }
                    
                }else{
                    System.out.println("current Category is not in the category list");
                }

                

            }else{
                System.out.println("ISBN is already exisits");
            }
        } catch (Exception e) {
        }
    }
    
    public void viewAllBooks(){
        
    }
    
    
    private boolean checkIsbn(int isbn){
        return false;
        
    }
    
    private boolean checkBookInReservation(int ISBM){
        return true;
    }
    
    
   
    
    
}

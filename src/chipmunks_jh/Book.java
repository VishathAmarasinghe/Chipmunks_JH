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
            setISBN(scan.nextInt());
            if (checkIsbn(getISBN())) {
                System.out.println("Enter Title");
                setTitle(scan.nextLine());
                Category c1=new Category();
                c1.setCategoryName(scan.nextLine());
                
                if (c1.checkCategory(c1.getCategoryName())) {
                    
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
            System.out.println("Do you want to delete book or book copy(book copy-1, book-2)");
            int checkvalue=scan.nextInt();
            if (checkvalue==1) {
                deletecopy();
            }else if (checkvalue==2) {
                deleteAllBooks();
            }else{
                System.out.println("invalid input");
            }
{
                
            }
            
        } catch (Exception e) {
        }

    }
   
    
    public void updateBook(){
        System.out.println("Update a Book");
        System.out.println("Enter the ISBN");
        Scanner scan=new  Scanner(System.in);
        try {
            setISBN(scan.nextInt());
            if (checkIsbn(getISBN())) {
                System.out.println("Update a book");
                System.out.println("Update a new Title");
                setTitle(scan.nextLine());
                System.out.println("Enter  new Category");
                Category c1=new Category();
                c1.setCategoryName(scan.nextLine());
                
                if (c1.checkCategory(c1.getCategoryName())) {
                    System.out.println("Enter new Author");
                    
                    Author a1=new Author();
                    String newautor=scan.nextLine();
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
    
    
    public void deleteAllBooks(){
        
        
    }
    
    public void deletecopy(){
        Scanner scan=new Scanner(System.in);
        int isbn=scan.nextInt();
            if (checkIsbn(isbn)) {
                if (checkBookInReservation(isbn)) {
                    
                }else{
                    System.out.println("Areu sure you want to delete(Y/N)");
                    String values= scan.nextLine();
                    try {
                        if (values.equalsIgnoreCase("y")) {
                            
                        }else{
                            System.out.println("invalid");
                        }
                    } catch (Exception e) {
                    }
                  
                }

            }else{
                System.out.println("ISBN is already exisits");
            }
    }
    
    
    private boolean checkIsbn(int isbn){
        return false;
        
    }
    
    private boolean checkBookInReservation(int ISBM){
        return true;
    }
    
    
   
    
    
}

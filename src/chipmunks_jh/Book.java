/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chipmunks_jh;

import java.sql.SQLException;
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

    public Book() {

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

    public void addBook() {
        System.out.println("Adding a new Book");
        System.out.println("Enter the ISBN");
        Scanner scan = new Scanner(System.in);
        try {
            setISBN(scan.nextInt());
            System.out.println(getISBN());
            if (!checkIsbn(getISBN())) {
                System.out.println("Enter Title");
                Validations v1 = new Validations();
                scan.nextLine();
                setTitle(scan.nextLine());
                if (!v1.checkStringvalidation(getTitle())) {
                    setTitle("");
                } else {
                    Category c1 = new Category();
                     System.out.println("Enter Category");
                    c1.setCategoryName(scan.nextLine());
                    if (!v1.checkStringvalidation(c1.getCategoryName())) {
                        c1.setCategoryName("");
                    } else {
                        if (c1.checkCategory(c1.getCategoryName())) {
                            DatabaseConnection d1=new DatabaseConnection();
                            d1.InsertBook(String.valueOf(getISBN()), getTitle(),c1.getCategoryName());
                            System.out.println("Book added successfully!!!!");

                        } else {
                            System.out.println("current Category is not in the category list");
                        }
                    }
                }

            } else {
                System.out.println("ISBN is already exisits");
            }
        } catch (Exception e) {
        }

    }

    public void removeBook() {
        System.out.println("Remove book a Book");
        //
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Do you want to delete book or book copy(book copy-1, book-2)");
            int checkvalue = scan.nextInt();
            if (checkvalue == 1) {
                deletecopy();
            } else if (checkvalue == 2) {
                deleteAllBooks();
            } else {
                System.out.println("invalid input");
            }
            {

            }

        } catch (Exception e) {
            System.out.println("invalid INput");
        }

    }

    public void updateBook() {
        System.out.println("Update a Book");
        System.out.println("Enter the ISBN");
        Scanner scan = new Scanner(System.in);
        try {
            setISBN(scan.nextInt());
            if (checkIsbn(getISBN())) {
                System.out.println("Update a book");
                System.out.println("Update a new Title");
                scan.nextLine();
                setTitle(scan.nextLine());
                System.out.println("Enter  new Category");
                Category c1 = new Category();
                c1.setCategoryName(scan.nextLine());

                if (c1.checkCategory(c1.getCategoryName())) {
                    System.out.println("Enter new Author");

                    Author a1 = new Author();
                    String newautor = scan.nextLine();
                    if (a1.checkAuthor(newautor)) {
                        //update functionality
                        DatabaseConnection d2=new DatabaseConnection();
                        d2.UpdatetBook(String.valueOf(getISBN()), getTitle(), c1.getCategoryName());
                        System.out.println("Updated success fully!!!!!!!");
                    } else {
                        System.out.println("author is not available in the database");
                    }

                } else {
                    System.out.println("current Category is not in the category list");
                }

            } else {
                System.out.println("ISBN is wrong");
            }
        } catch (Exception e) {
        }
    }

    public void ListAllBooks() throws ClassNotFoundException, SQLException {
        System.out.println("List all available Books");
        DatabaseConnection dbc= new DatabaseConnection();
        dbc.rData();
    }

    public void deleteAllBooks() {
        
    }

    public void deletecopy() throws ClassNotFoundException, SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the ISBN");
        int isbn = scan.nextInt();
        if (checkIsbn(isbn)) {
            if (checkBookInReservation(isbn)) {

            } else {
                System.out.println("Areu sure you want to delete(Y/N)");
                scan.nextLine();
                String values = scan.nextLine();
                try {
                    if (values.equalsIgnoreCase("y")) {
                        DatabaseConnection dbc= new DatabaseConnection();
                        dbc.reMoveBook(String.valueOf(isbn));
                        System.out.println("Book deleted successfully");

                    } else {
                        System.out.println("Error Founded in deletion");
                    }
                } catch (Exception e) {
                    System.out.println("Error Found");
                }

            }

        } else {
            System.out.println("ISBN is not Exist");
        }
    }

    private boolean checkIsbn(int isbn) throws ClassNotFoundException, SQLException {
        DatabaseConnection dbc = new DatabaseConnection();
        System.out.println(dbc.ISBNChek(String.valueOf(isbn)));
        return dbc.ISBNChek(String.valueOf(isbn));
   

    }

    private boolean checkBookInReservation(int ISBM) throws ClassNotFoundException, SQLException {
        DatabaseConnection dbc= new DatabaseConnection();
        return dbc.ISBNcheckINcopy(ISBM);
      
    }

    //Check if book list exists (true if at least 1 record is available)
    private boolean checkBookList() {
        return true;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chipmunks_jh;

import java.util.Scanner;

public class Chipmunks_JH {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        boolean ex=true;
        while(ex){
            
            System.out.println("");
            System.out.println("");
            System.out.println("");
        System.out.println("Welcome To the library management System UOK");
        System.out.println("Please Choose an option");
        System.out.println("1.Add a new Book");
        System.out.println("2.Update an exisiting book");
        System.out.println("3.Remove an exisitng book");
        System.out.println("4.Lending a book");
        System.out.println("5.Return a book");
        System.out.println("6.Listing all available books");
        System.out.println("7.Exit");

        Scanner scan = new Scanner(System.in);

        try {
            int mainfuncValue = scan.nextInt();
            Book b1 = new Book();
            Reservation r1 = new Reservation();

            switch (mainfuncValue) {
                case 1:
                    b1.addBook();
                    break;
                case 2:
                    b1.updateBook();
                    break;
                case 3:
                    b1.removeBook();
                    break;
                case 4:
                    r1.lendBook();
                    break;
                case 5:
                    r1.returnBook();
                    break;
                case 6:
       
                    b1.ListAllBooks();
                    break;
                case 7:
                    ex=false;
                default:
                    System.out.println("The number you entered is not in the range of functionality");
            }
        } catch (Exception e) {
            System.out.println("Invalid input");
        }

        // TODO code application logic here
    }
    }
}

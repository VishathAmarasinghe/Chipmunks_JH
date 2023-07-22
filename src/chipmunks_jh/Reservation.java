package chipmunks_jh;

import java.util.Date;
import java.util.Scanner;

public class Reservation {

    private int reservationID;

    public void lendBook() {
        System.out.println("Lending a Book");
        System.out.println("Please enter the ISBN: ");
        Scanner scan = new Scanner(System.in);
        try {
            int isbn = scan.nextInt();
            if (checkIsbn(isbn)) {
                if(checkBookInReservation(isbn)){
                    
                }else{
                
                }
            }else{
            
            }
        } catch (Exception e) {
        }
    }

    public void returnBook() {
        System.out.println("Returning a Book");
        System.out.println("Please enter the ISBN: ");
        Scanner scan = new Scanner(System.in);
        try {
            int isbn = scan.nextInt();
            if (checkIsbn(isbn)) {
                if(checkBookInReservation(isbn)){
                    
                }else{
                
                }
            }else{
            
            }
        } catch (Exception e) {
        }
    }

    private boolean checkIsbn(int isbn) {
        return false;

    }

    private boolean checkBookInReservation(int ISBM) {
        return true;
    }
}

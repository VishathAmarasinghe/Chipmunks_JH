/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chipmunks_jh;

/**
 *
 * @author Akila
 */
public class Validations {

    public Validations() {
    }
    
    
    
    public boolean checkStringvalidation(String s){
        if (s.length()!=0) {
            if (s.charAt(0)==' ') {
                System.out.println("invalid input");
                return true;
            }else{
                System.out.println("valid input");
                return true;
            }
        }else{
            System.out.println("invalid input");
            return false;
        }
    }
    
}

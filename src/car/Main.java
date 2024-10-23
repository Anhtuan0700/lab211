/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
   private static final Scanner in = new Scanner(System.in);

    private static String checkInputString() throws Exception {
        while (true) {
            String result = in.nextLine();
            if (result.length() == 0) {
                throw new Exception("Not empty");
            } else {
                return result;
            }
        }
    }

    private static int checkInputInt() throws Exception{
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                if (result <= 0) {
                    throw new Exception("Price greater than zero");
                }
                return result;
            } catch (NumberFormatException ex) {
                throw new Exception("Price is digit");
            }

        }
    }



 

  

    public static void main(String[] args) throws Exception {
        Car c = new Car();
        c.InputCar();
    }
    
}

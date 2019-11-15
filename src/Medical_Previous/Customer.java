/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medical_Previous;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author 2ndyrGroupB
 */
public class Customer extends RegisteredUsers {

    Pharmacist b;
    Scanner user = new Scanner(System.in);
    private HashMap<String, Integer> Medquantity = new HashMap<String, Integer>();

    public Customer(String role, String Firstname, String Lastname, int Age, String Username, String Password) {
        super(role, Firstname, Lastname, Age, Username, Password);
    }

    public Customer() {
    }

    public HashMap<String, Integer> getMedquantity() {
        return Medquantity;
    }

    public void setMedquantity(HashMap<String, Integer> Medquantity) {
        this.Medquantity = Medquantity;
    }

    public void viewOrder() {
        System.out.println("\n-----------------------------------------------------Your Order---------------------------------------------------------");
        System.out.printf("%30s %5s %20s %5s %20s %5s %15s %5s", "Medicine Name", "|", "Brand Name", "|", "Generic Name", "|", "Price", "\n");
        for (int x = 0; x < b.getReceipt().size(); ++x) {
            System.out.println(b.getReceipt().get(x));
        }
    }

}

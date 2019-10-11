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

    Scanner user = new Scanner(System.in);

    public Customer(String role, String Firstname, String Lastname, int Age, String Username, String Password) {
        super(role, Firstname, Lastname, Age, Username, Password);
    }

    public Customer() {
    }

    public void order(HashMap<String, Integer> a) {
        Pharmacist b = new Pharmacist();
        System.out.println("-------------------------------------------------Order Now-----------------------------------------------------");
        String order = input("Medicine's Name");
        int orderNum = inputInt("Quantity");
        if (a.containsKey(order)) {
            a.replace(order, a.get(order) - orderNum);
            System.out.println("You're order is ready!");
            b.showPurchase(order);
        } else {
            System.out.println("Can't find Medicine name");
        }
    }

    public void viewOrder() {
        Pharmacist a = new Pharmacist();
        System.out.println("\n-----------------------------------------------------Your Order---------------------------------------------------------");
        System.out.printf("%30s %5s %20s %5s %20s %5s %15s %5s", "Medicine Name", "|", "Brand Name", "|", "Generic Name", "|", "Price", "\n");
        for (int x = 0; x < a.getReceipt().size(); ++x) {
            System.out.println(a.getReceipt().get(x));
        }
    }

}

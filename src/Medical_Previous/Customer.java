/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medical_Previous;

import java.util.Scanner;

/**
 *
 * @author 2ndyrGroupB
 */
public class Customer extends Medicine implements method {

    public static Scanner user = new Scanner(System.in);
    Pharmacist pharmacist;

    public Customer(String GenericName, String BrandName, double Medprice, String illness) {
        super(GenericName, BrandName, Medprice, illness);
    }

    public String input(String label) {
        System.out.print(label + ": ");
        return user.next();
    }

    @Override
    public int inputInt(String label) {
        System.out.print(label + ": ");
        return user.nextInt();
    }

    /**
     *
     * @param label
     * @return
     */
    @Override
    public String classifyRole(String label) {
        System.out.print(label + ": ");
        String role = user.next();
        if (role.equalsIgnoreCase("Admin")) {
            return "Admin";
        } else if (role.equalsIgnoreCase("Customer")) {
            return "Costumer";
        } else {
            return "Invalid Input";
        }
    }

    public void viewOrder() {
        System.out.println("\n-----------------------------------------------------Your Order---------------------------------------------------------");
        System.out.printf("%30s %5s %20s %5s %20s %5s %15s %5s", "Medicine Name", "|", "Brand Name", "|", "Generic Name", "|", "Price", "\n");
        for (int x = 0; x < pharmacist.getReceipt().size(); ++x) {
            System.out.println(pharmacist.getReceipt().get(x));
        }
    }

}

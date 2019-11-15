/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medical_Previous;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 2ndyrGroupB
 */
public abstract class RegisteredUsers extends Account implements method {

    Scanner user = new Scanner(System.in);
    private List<Account> registered = new ArrayList<Account>();

    public RegisteredUsers() {
    }

    public RegisteredUsers(String role, String Firstname, String Lastname, int Age, String Username, String Password) {
        super(role, Firstname, Lastname, Age, Username, Password);
    }

    public Scanner getUser() {
        return user;
    }

    public void setUser(Scanner user) {
        this.user = user;
    }

    public List<Account> getRegistered() {
        return registered;
    }

    public void setRegistered(List<Account> registered) {
        this.registered = registered;
    }

    public void showMed(ArrayList<Medicine> a,String illness) {
        System.out.printf("%20s %5s %20s %5s %15s %5s", "Generic Name", "|", "Brand Name", "|", "Price", "\n");
        for (int i = 0; i < a.size(); ++i) {
            Medicine current = a.get(i);
            if (current.getIllness().equalsIgnoreCase(illness)) {
                System.out.println(current);
            }
        }
    }

    @Override
    public String input(String label) {
        System.out.print(label + ": ");
        return user.next();
    }

    @Override
    public int inputInt(String label) {
        System.out.print(label + ": ");
        return user.nextInt();
    }

    @Override
    public String classifyRole(String label) {
        System.out.print(label + ": ");
        String role = user.next();
        if (role.equalsIgnoreCase("Admin")) {
            return "Admin";
        } else if (role.equalsIgnoreCase("Customer")) {
            return "Customer";
        } else {
            return "Invalid Input";
        }
    }

}

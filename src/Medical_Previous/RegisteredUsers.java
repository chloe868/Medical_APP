/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medical_Previous;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 2ndyrGroupB
 */
public class RegisteredUsers extends Account {

    private static List<Account> registered = new ArrayList<Account>();

    public RegisteredUsers(String role, String Firstname, String Lastname, int Age, String Username, String Password) {
        super(role, Firstname, Lastname, Age, Username, Password);
    }

    public static List<Account> getRegistered() {
        return registered;
    }

    public static void setRegistered(List<Account> registered) {
        RegisteredUsers.registered = registered;
    }
}

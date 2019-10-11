/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medical_Previous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author herrerach_sd2082
 */
public class Pharmacist extends RegisteredUsers {

    Scanner user = new Scanner(System.in);
    private ArrayList<Medicine> tambal = new ArrayList<Medicine>();
    private ArrayList<Medicine> receipt = new ArrayList<Medicine>();
    private HashMap<String, Integer> Medquantity = new HashMap<String, Integer>();
    Customer customer = new Customer();
    Pharmacist b;

    public Pharmacist(String role, String Firstname, String Lastname, int Age, String Username, String Password) {
        super(role, Firstname, Lastname, Age, Username, Password);
    }

    public Pharmacist() {
    }

    public List<Medicine> getTambal() {
        return tambal;
    }

    public void setTambal(ArrayList<Medicine> tambal) {
        this.tambal = tambal;
    }

    public List<Medicine> getReceipt() {
        return receipt;
    }

    public void setReceipt(ArrayList<Medicine> receipt) {
        this.receipt = receipt;
    }

    public HashMap<String, Integer> getMedquantity() {
        return Medquantity;
    }

    public void setMedquantity(HashMap<String, Integer> Medquantity) {
        this.Medquantity = Medquantity;
    }

    public void ViewInventory() {
        for (int i = 0; i < tambal.size(); ++i) {
            Medquantity.put(tambal.get(i).getGenericName(), 12);
        }
        System.out.println("\n----------------------------------------------------INVENTORY-----------------------------------------------\n");
        Medquantity.forEach((k, v) -> System.out.println("Medicine: " + k + "\twith Quantity:" + v + "\n"));
    }

    public void AddMed() {

    }

    public void RemoveMed() {

    }

    public void showPurchase(String name) {
        System.out.printf("%20s %5s %20s %5s %15s %5s", "Generic Name", "|", "Brand Name", "|", "Price", "\n");
        for (int i = 0; i < tambal.size(); ++i) {
            Medicine current = tambal.get(i);
            if (current.getGenericName().equalsIgnoreCase(name)) {
                System.out.println(current);
                receipt.add(current);
            }
        }
    }

    public void printReceipt() {
        if (!receipt.isEmpty()) {
            System.out.println("----------------------------------------------Receipt-----------------------------------------");
            System.out.printf("%20s %5s %20s %5s %15s %5s", "Generic Name", "|", "Brand Name", "|", "Price", "\n");
            double payables = 0;
            for (int i = 0; i < receipt.size(); ++i) {
                System.out.println(receipt.get(i));
                payables += receipt.get(i).getMedprice();
            }
            receipt.clear();
            System.out.println("\nTotal Payables: " + payables);
            System.out.println("------------------------------------------------END OF TRANSACTION----------------------------------------------------------------------\n");
        } else {
            System.out.println("Thank You!!!");
        }
    }

    public void printdiscount() {
        if (!receipt.isEmpty()) {
            System.out.println("----------------------------------------------Receipt-----------------------------------------");
            System.out.printf("%20s %5s %20s %5s %15s %5s", "Generic Name", "|", "Brand Name", "|", "Price", "\n");
            double payables = 0;
            for (int i = 0; i < receipt.size(); ++i) {
                System.out.println(receipt.get(i));
                payables += receipt.get(i).getMedprice();
            }
            receipt.clear();
            System.out.println("\nTotal Payables: " + (payables - (payables * 0.20)));
            System.out.println("------------------------------------------------END OF TRANSACTION----------------------------------------------------------------------\n");
        } else {
            System.out.println("Thank You!!!");
        }
    }

    public void processRegistered() {
        boolean identity = true;
        Account currentUser = null;
        while (identity) {
            String choice = input("Press 1 to Register\nPress 2 to login\nPress 3 to Exit\nChoice");
            switch (choice) {
                case "1":
                    System.out.println("\n---------------------------------------------REGISTER ACCOUNT---------------------------------------------\n");
                    String role = input("\nRegister as a:(Admin/Customer)\nChoice");
                    String firstName = input("FirstName");
                    String lastName = input("LastName");
                    int Age = inputInt("Age");
                    String Username = input("UserName");
                    String Password = input("Password");
                    getRegistered().add(new Account(role, firstName, lastName, Age, Username, Password));
                    break;
                case "2":
                    System.out.println("\n----------------------------------------------LOGIN ACCOUNT------------------------------------------------------");
                    String LoginuserName = input("Username");
                    String LoginpassWord = input("Password");

                    for (int i = 0; i < getRegistered().size(); ++i) {
                        Account acc = getRegistered().get(i);

                        if (LoginuserName.equals(acc.getUsername()) && LoginpassWord.equals(acc.getPassword())) {
                            if (acc.getRole().equalsIgnoreCase("Customer")) {
                                System.out.println("\n-----------------------------------Welcome to TAMBALAN" + " " + acc.getFirstname() + "---------------------------------\n");
                                currentUser = acc;
                                String choose = "0";
                                while (choose != "4") {
                                    choose = input("\nWhat do you want to do?\nPress 1 View medicine\nPress 2 Order Medicine\nPress 3 to View Order\nPress 4 Exit\nChoice");

                                    if (currentUser.getAge() >= 18) {
                                        System.out.println("-----------------------------Welcome and Enjoy Shopping" + " " + currentUser.getFirstname() + "--------------------------\n");
                                    } else {
                                        System.out.println("-----------------------------Welcome and Enjoy Shopping" + " " + currentUser.getFirstname() + "--------------------------\n");
                                        System.out.println("\n---------------------------LIST OF MEDICINES------------------------------\n");
                                        System.out.println("\n************************** MEDICINE FOR COUGH *****************************\n");
                                        showMed(this.tambal, "Cough");
                                        System.out.println("\n*********************** MEDICINE FOR ALLERGIES *****************************\n");
                                        showMed(this.tambal, "Allergies");
                                        System.out.println("\n********************** MEDICINE FOR BODY PAIN ******************************\n");
                                        showMed(this.tambal, "Body Pain");
                                        System.out.println("\n*********************** MEDICINE FOR HEADACHE *****************************\n");
                                        showMed(this.tambal, "Headache");
                                        System.out.println("********************YOU ARE NOT ALLOWED TO PURCHASE ANYTHING********************\n");
                                        System.out.println("**********************************Thank You***********************************");
                                        break;
                                    }
                                    switch (choose) {
                                        case "1":
                                            System.out.println("\n---------------------------LIST OF MEDICINES------------------------------\n");
                                            System.out.println("\n************************** MEDICINE FOR COUGH *****************************\n");
                                            showMed(this.tambal, "Cough");
                                            System.out.println("\n*********************** MEDICINE FOR ALLERGIES *****************************\n");
                                            showMed(this.tambal, "Allergies");
                                            System.out.println("\n********************** MEDICINE FOR BODY PAIN ******************************\n");
                                            showMed(this.tambal, "Body Pain");
                                            System.out.println("\n*********************** MEDICINE FOR HEADACHE *****************************\n");
                                            showMed(this.tambal, "Headache");
                                            break;
                                        case "2":
                                            customer.order(this.Medquantity);
                                            break;
                                        case "3":
                                            customer.viewOrder();
                                        case "4":
                                            choose = "4";
                                            if (acc.getAge() >= 60) {
                                                printdiscount();
                                            } else {
                                                printReceipt();
                                            }
                                            break;
                                        default:
                                            System.out.println("Invalid");
                                            break;
                                    }
                                }
                            } else if (acc.getRole().equalsIgnoreCase("Admin")) {
                                String Adminchoose = "0";
                                while (Adminchoose != "4") {
                                    Adminchoose = input("\nWhat do you want to do?\nPress 1 View Inventory\nPress 2 Add Medicine\nPress 3 Delete Medicine\nPress 4 Exit\nChoice");
                                    switch (Adminchoose) {
                                        case "1":
                                            ViewInventory();
                                            break;
                                        case "2":
                                            System.out.println("\n-------------------------------------ADD MEDICINE-------------------------------------------------\n");
                                            break;
                                        case "3":
                                            System.out.println("\n-------------------------------------DELETE MEDICINE-------------------------------------------------\n");
                                            break;
                                        case "4":
                                            Adminchoose = "4";
                                            System.out.println("\n----------------------------THANK YOU-----------------------------\n");
                                            break;
                                        default:
                                            System.out.println("Invalid");
                                            break;
                                    }
                                }
                            }
                        }
                    }
                case "3":
                    System.out.println("Thank You!!!");
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}

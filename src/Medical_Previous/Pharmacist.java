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
 * @author herrerach_sd2082
 */
public class Pharmacist extends RegisteredUsers {

    Scanner user = new Scanner(System.in);
    private ArrayList<Medicine> tambal = new ArrayList<Medicine>();
    private ArrayList<Medicine> receipt = new ArrayList<Medicine>();
    private ArrayList<Medicine> Storage = new ArrayList<Medicine>();
    Customer customer = new Customer();
    Pharmacist b;
    Storage store;

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

    public ArrayList<Medicine> getStorage() {
        return Storage;
    }

    public void setStorage(ArrayList<Medicine> Storage) {
        this.Storage = Storage;
    }

    public void MedStorage(Medicine med) {
        tambal.add(med);
    }

    public void ViewInventory() {
        System.out.println("\n----------------------------------------------------INVENTORY-----------------------------------------------\n");
        customer.getMedquantity().forEach((k, v) -> System.out.println("Medicine: " + k + " = " + "\twith Quantity:" + v + "\n"));
    }

    public void AddMed() {
        String illness = (input("Medicine for: "));
        if (illness.equalsIgnoreCase("Cough") || illness.equalsIgnoreCase("Allergies") || illness.equalsIgnoreCase("BodyPain") || illness.equalsIgnoreCase("Headache")) {
            MedStorage(new Medicine(input("Generic Name: "), input("Brand Name: "), inputInt("price: "), illness));
        } else {
            System.out.println("\nNo Storage for that medicine\n");
        }
    }

    public void RemoveMed() {
        String del = (input("\nWhat medicine you want to delete: "));
        for (int i = 0; i < tambal.size(); ++i) {
            if (del.equals(tambal.get(i).getGenericName())) {
                tambal.remove(tambal.indexOf(tambal.get(i)));
                System.out.println("\nMedicine is successfully deleted\n");
            }
        }
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
        for (int i = 0; i < tambal.size(); ++i) {
            customer.getMedquantity().put(tambal.get(i).getGenericName(), 12);
        }
        boolean identity = true;
        Account currentUser = null;
        while (identity) {
            String choice = input("Press 1 to Register\nPress 2 to login\nPress 3 to Exit\nChoice");
            switch (choice) {
                case "1":
                    System.out.println("\n---------------------------------------------REGISTER ACCOUNT---------------------------------------------\n");
                    String role = input("\nRegister as a:(Customer)Choice");
                    String firstName = input("FirstName");
                    String lastName = input("LastName");
                    int Age = inputInt("Age");
                    String Username = input("UserName");
                    String Password = input("Password");
                    getRegistered().add(new Account(role, firstName, lastName, Age, Username, Password));
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
                                    choose = input("\nWhat do you want to do?\nPress 1 View medicine\nPress 2 Order Medicine\nPress 3 View Order\nPress 4 Exit\nChoice");

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
                                    }
                                    switch (choose) {
                                        case "1":
                                            if (currentUser.getAge() >= 18) {
                                                System.out.println("\n---------------------------LIST OF MEDICINES------------------------------\n");
                                                System.out.println("\n************************** MEDICINE FOR COUGH *****************************\n");
                                                showMed(this.tambal, "Cough");
                                                System.out.println("\n*********************** MEDICINE FOR ALLERGIES *****************************\n");
                                                showMed(this.tambal, "Allergies");
                                                System.out.println("\n********************** MEDICINE FOR BODY PAIN ******************************\n");
                                                showMed(this.tambal, "Body Pain");
                                                System.out.println("\n*********************** MEDICINE FOR HEADACHE *****************************\n");
                                                showMed(this.tambal, "Headache");
                                            } else {
                                                System.out.println("You are not authorized beyond this line");
                                            }
                                            break;
                                        case "2":
                                            if (currentUser.getAge() >= 18) {
                                                String order = input("Medicine's Name");
                                                int orderNum = inputInt("Quantity");
                                                if (customer.getMedquantity().containsKey(order)) {
                                                    customer.getMedquantity().replace(order, customer.getMedquantity().get(order) - orderNum);
                                                    System.out.println("You're order is ready!");
                                                    showPurchase(order);
                                                } else {
                                                    System.out.println("Medicine is not available");
                                                }
                                            } else {
                                                System.out.println("You are not authorized beyond this line");
                                            }
                                            break;
                                        case "3":
                                            if (currentUser.getAge() >= 18) {
                                                System.out.println("\n-----------------------------------------------------Your Order---------------------------------------------------------");
                                                // System.out.printf("%30s %5s %20s %5s %20s %5s %15s %5s", "Medicine Name", "|", "Brand Name", "|", "Generic Name", "|", "Price", "\n");
                                                for (int x = 0; x < receipt.size(); ++x) {
                                                    System.out.println(receipt.get(x));
                                                }
                                            } else {
                                                System.out.println("You are not authorized beyond this line");
                                            }
                                            break;
                                        case "4":
                                            choose = "4";
                                            if (currentUser.getAge() >= 18) {
                                                if (acc.getAge() >= 60) {
                                                    printdiscount();
                                                } else {
                                                    printReceipt();
                                                }
                                            }else {
                                                System.out.println("You are not authorized beyond this line");
                                            }
                                            break;
                                        default:
                                            System.out.println("Invalid");
                                            break;
                                    }
                                }
                                break;
                            } else if (acc.getRole().equalsIgnoreCase("Admin")) {
                                String Adminchoose = "0";
                                while (Adminchoose != "5") {
                                    Adminchoose = input("\nWhat do you want to do?\nPress 1 View Inventory\nPress 2 Add Medicine\nPress 3 Delete Medicine\nPress 4 VIew Medicine\nPress 5 Exit\nChoice");
                                    switch (Adminchoose) {
                                        case "1":
                                            ViewInventory();
                                            break;
                                        case "2":
                                            System.out.println("\n-------------------------------------ADD MEDICINE-------------------------------------------------\n");
                                            AddMed();
                                            break;
                                        case "3":
                                            System.out.println("\n-------------------------------------DELETE MEDICINE-------------------------------------------------\n");
                                            RemoveMed();
                                            break;
                                        case "4":
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
                                        case "5":
                                            Adminchoose = "5";
                                            System.out.println("\n----------------------------THANK YOU-----------------------------\n");
                                            break;
                                        default:
                                            System.out.println("Invalid");
                                    }
                                }
                            }
                        }
                    }
                    break;
                case "3":
                    identity = false;
                    System.out.println("Thank You!!!");
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

}

package com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookSystem {

    private ArrayList<AddressBookContacts> contacts = new ArrayList<>();
    public void addContacts(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first name : ");
        String firstName = sc.nextLine();

        System.out.println("Enter last name : ");
        String lastName = sc.nextLine();

        System.out.println("Enter Address : ");
        String address = sc.nextLine();

        System.out.println("Enter city : ");
        String city = sc.nextLine();

        System.out.println("Enter the state : ");
        String state = sc.nextLine();

        System.out.println("Enter zip code : ");
        String zip = sc.nextLine();

        System.out.println("Enter phone number : ");
        String phone = sc.nextLine();

        System.out.println("Enter email : ");
        String email = sc.nextLine();

        AddressBookContacts c1 = new AddressBookContacts(firstName,lastName,address,city,state,zip,phone,email);
        contacts.add(c1);
        System.out.println("CONTACTS ADDED SUCCESFULLY!!!");
        //return;
    }

    public void editContacts(){
        System.out.println("\n Enter the first name of the contact to edit : \n");
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();

        for (AddressBookContacts abc : contacts){
            if (abc.getFirstName().equalsIgnoreCase(name)){
                System.out.println("Enter new first name : ");
                abc.setFirstName(sc.nextLine());

                System.out.println("Enter the new last name : ");
                abc.setLastName(sc.nextLine());

                System.out.println("Enter the new Address : ");
                abc.setAddress(sc.nextLine());

                System.out.println("Enter the new city name : ");
                abc.setCity(sc.nextLine());

                System.out.println("Enter the zip code : ");
                abc.setZip(sc.nextLine());

                System.out.println("Enter the new phone number : ");
                abc.setPhoneNo(sc.nextLine());

                System.out.println("Enter the new email : ");
                abc.setEmail(sc.nextLine());

                System.out.println("CONTACT UPDATED SUCCESSFULLY!!!");
                return;
            }
        }
        System.out.println("Contact not found!!!");

    }


    public void deleteContacts(){
        System.out.println("Enter the first name of te contact to be deleted : ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        for (AddressBookContacts abc : contacts){
            if (abc.getFirstName().equalsIgnoreCase(name)){
                contacts.remove(abc);
                System.out.println("CONTACT DELETED SUCCESSFULLY !!! ");
                return;
            }
        }

        System.out.println("CONTACT NOT FOUND!!!");
    }

    public void displayContacts(){
        if (contacts.isEmpty()){
            System.out.println("The contact list is empty!!!");
            return;
        }

        for (AddressBookContacts c : contacts){
            System.out.println(c);
        }
    }


//
//    public static void main(String[] args) {
//        System.out.println("WELCOME TO ADDRESS BOOK PROGRAM!!!");
////
////        AddressBookSystem abs = new AddressBookSystem();
////        Scanner sc = new Scanner(System.in);
////        int choice;
////
////        do{
////            System.out.println("\nMenu:");
////            System.out.println("1. Add Contact ");
////            System.out.println("2. Edit Contact ");
////            System.out.println("3. Delete Contact ");
////            System.out.println("4. Display All Contacts");
////            System.out.println("5. Exit ");
////            System.out.print("Enter your choice: ");
////
////            choice = sc.nextInt();
////            sc.nextLine();
////
////            switch (choice){
////                case 1 :
////                    abs.addContacts();
////                    break;
////                case 2 :
////                    abs.editContacts();
////                    break;
////                case 3 :
////                    abs.deleteContacts();
////                    break;
////                case 4 :
////                    abs.displayContacts();
////                    break;
////                case 5 :
////                    System.out.println("Thank you....BYE BYE !!!!");
////                     break;
////                default:
////                    System.out.println("INVALID CHOICE ENTERED!!!");
////                    break;
////            }
////
////        } while (choice !=5);
////





private static Map<String, AddressBookSystem> addressBooks = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Create New Address Book");
            System.out.println("2. Open Existing Address Book");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Address Book Name: ");
                    String abName = sc.nextLine();
                    addressBooks.put(abName, new AddressBookSystem());
                    System.out.println("Address Book '" + abName + "' created.");
                    break;

                case 2:
                    System.out.print("Enter Address Book Name: ");
                    String name = sc.nextLine();
                    AddressBookSystem abs = addressBooks.get(name);

                    if (abs == null) {
                        System.out.println("Address Book not found.");
                    } else {
                        runAddressBookMenu(abs);
                    }
                    break;

                case 3:
                    System.out.println("Thank you!");
                    return;
            }
        }
    }

    private static void runAddressBookMenu(AddressBookSystem abs) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nAddress Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display Contacts");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: abs.addContacts(); break;
                case 2: abs.editContacts(); break;
                case 3: abs.deleteContacts(); break;
                case 4: abs.displayContacts(); break;
            }
        } while (choice != 5);
    }

}

package com.streams;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBookStr {

    static HashMap<String, AddressBookStr> addressBook = new HashMap<>();
    static ArrayList<ContactsStr> contacts = new ArrayList<>();

    public static void createAddressBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Address Book name : ");
        String bookName = sc.nextLine();
        if (addressBook.containsKey(bookName)) {
            System.out.println("AddressBook already exists!! Use another name");
        } else {
            addressBook.put(bookName, new AddressBookStr());
            System.out.println("Address Book Created");
        }

    }


    public void createContact() {
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

        Optional<ContactsStr> createContacts = contacts.stream().filter(c -> c.getFirstName().equalsIgnoreCase(firstName) && c.getLastName().equalsIgnoreCase(lastName)).findFirst();

        if (createContacts.isPresent()) {
            System.out.println("UNABLE TO ADD CONTACT!!! The contact with the entered FirstName / LastName is already present!!!");
        } else {
            ContactsStr c1 = new ContactsStr(firstName, lastName, address, city, state, zip, phone, email);
            contacts.add(c1);
            System.out.println("CONTACTS ADDED SUCCESFULLY!!!");
        }


    }


    public void editContacts() {
        System.out.println("\n Enter the first name of the contact to edit : \n");
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();

        Optional<ContactsStr> editContacts = contacts.stream().filter(c -> c.getFirstName().equalsIgnoreCase(name)).findFirst();

        if (editContacts.isPresent()) {
            ContactsStr abc = editContacts.get();

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

        System.out.println("Contact not found!!!");

    }


    public void deleteContacts() {
        System.out.println("Enter the first name of the contact to be deleted : ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        Optional<ContactsStr> deleteContacts = contacts.stream().filter(c -> c.getFirstName().equalsIgnoreCase(name)).findFirst();

        if (deleteContacts.isPresent()) {
            ContactsStr abc = deleteContacts.get();
            contacts.remove(abc);
            System.out.println("CONTACT DELETED SUCCESSFULLY !!! ");
            return;
        }

        System.out.println("CONTACT NOT FOUND!!!");
    }


    public void displayContacts() {

        if (contacts.isEmpty()) {
            System.out.println("Contacts list is empty");
        } else {
            contacts.stream().forEach(System.out::println);
        }

    }


    public void filterByCity() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the city name : ");
        String city = sc.nextLine();

        if (contacts.stream().anyMatch(c -> c.getCity().equalsIgnoreCase(city))) {
            List<ContactsStr> cityFilter = contacts.stream().filter(c -> c.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
            cityFilter.forEach(System.out::println);
        } else
            System.out.println("No contacts has been found for the city which you have entered!!!");
    }


    public void countByCity() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the city name to count the number of persons in the city : ");
        String cityNameForCount = sc.nextLine();

        if (contacts.stream().anyMatch(c -> c.getCity().equalsIgnoreCase(cityNameForCount))) {
            Long cityCountFilter = contacts.stream().filter(c -> c.getCity().equalsIgnoreCase(cityNameForCount)).count();
            System.out.println("No of persons in the city " + cityNameForCount + " is : " + cityCountFilter);
        } else {
            System.out.println("No contacts has been found for the city which you have entered!!!");
        }
    }


    public  void countByState(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the state name to count the number of persons in the city : ");
        String stateNameForCount = sc.nextLine();

        if (contacts.stream().anyMatch(c->c.getState().equalsIgnoreCase(stateNameForCount))){
            Long stateCount = contacts.stream().filter(c->c.getState().equalsIgnoreCase(stateNameForCount)).count();
            System.out.println("No of persons in the city " + stateNameForCount + " is : " + stateCount);
        }
    }


    public static void searchPersonsByCity() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the city name to search across all available AddressBooks : ");
        String city = sc.nextLine();
        List<ContactsStr> result =
                addressBook.values().stream()
                        .flatMap(ab -> ab.contacts.stream())
                        .filter(c -> c.getCity().equalsIgnoreCase(city))
                        .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("No contacts found in city: " + city);
        } else {
            System.out.println("\nPeople living in " + city + ":");
            result.forEach(System.out::println);
        }
    }


    public static void searchPersonsByState() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the state name to search across all available AddressBooks : ");
        String state = sc.nextLine();

        List<ContactsStr> result = addressBook.values().stream().flatMap(ab -> ab.contacts.stream()).filter(c -> c.getState().equalsIgnoreCase(state)).collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("No contacts found in State : " + state);
        } else {
            System.out.println("\n People living in " + state + ":");
            result.forEach(System.out::println);
        }
    }


    public static void searchPersonsByName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first name to search across all available AddressBooks : ");
        String name = sc.nextLine();

        List<ContactsStr> result = addressBook.values().stream().flatMap(c->c.contacts.stream()).filter(c->c.getFirstName().equalsIgnoreCase(name)).collect(Collectors.toList());
        if (result.isEmpty()){
            System.out.println("No contacts found for the name of : " + name);
        } else {
            System.out.println("\n People with the name of " + name + ":");
            result.forEach(System.out::println);
        }
    }

    public static void viewByCityDictionary() {
        Map<String, List<ContactsStr>> cityDict = new HashMap<>();

        addressBook.values().forEach(book ->
                book.contacts.forEach(contact -> {
                    cityDict.computeIfAbsent(contact.getCity().toLowerCase(), k -> new ArrayList<>()).add(contact);
                })
        );

        if (cityDict.isEmpty()) {
            System.out.println("No contacts available in any AddressBook.");
            return;
        }

        System.out.println("\n==== VIEW BY CITY (DICTIONARY) ====");
        cityDict.forEach((city, people) -> {
            System.out.println("\nCity : " + city);
            people.forEach(System.out::println);
        });
    }


    public static void viewByStateDictionary() {
        Map<String, List<ContactsStr>> stateDict = new HashMap<>();

        addressBook.values().forEach(book ->
                book.contacts.forEach(contact -> {
                    stateDict.computeIfAbsent(contact.getState().toLowerCase(), k -> new ArrayList<>()).add(contact);
                })
        );

        if (stateDict.isEmpty()) {
            System.out.println("No contacts available in any AddressBook.");
            return;
        }

        System.out.println("\n==== VIEW BY STATE (DICTIONARY) ====");
        stateDict.forEach((state, people) -> {
            System.out.println("\nState : " + state);
            people.forEach(System.out::println);
        });
    }


    public static void sortByFirstName(){
        List<ContactsStr> sortedByName = contacts.stream().sorted(Comparator.comparing(ContactsStr::getFirstName)).collect(Collectors.toList());
        if (sortedByName.isEmpty()){
            System.out.println("No contacts has been found!!!");
        }
        else {
        System.out.println(sortedByName);
        }
    }

    public static void sortByCity(){
        List<ContactsStr> sortedByCity = contacts.stream().sorted(Comparator.comparing(ContactsStr::getCity)).collect(Collectors.toUnmodifiableList());

        if (sortedByCity.isEmpty()){
            System.out.println("No contacts has been found!!!");
        }
        else {
            System.out.println(sortedByCity);
        }
    }

    public static void sortByState(){
        List<ContactsStr> sortedByCity = contacts.stream().sorted(Comparator.comparing(ContactsStr::getState)).collect(Collectors.toUnmodifiableList());
        if (sortedByCity.isEmpty()){
            System.out.println("No contacts has been found!!!");
        }
        else {
            System.out.println(sortedByCity);
        }
    }


    public static void sortByZip(){
        List<ContactsStr> sortedByZip = contacts.stream().sorted(Comparator.comparing(ContactsStr::getZip)).collect(Collectors.toUnmodifiableList());

        if (sortedByZip.isEmpty()){
            System.out.println("No contacts has been found!!!");
        }
        else {
            System.out.println(sortedByZip);
        }
    }


    public void contactMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n---- CONTACT MENU ----");
            System.out.println("1. Create new contact");
            System.out.println("2. Update an existing contact");
            System.out.println("3. Delete an existing contact");
            System.out.println("4. Display all the contacts");
            System.out.println("5. Display the contact by their city name");
            System.out.println("6. Display the count of the persons by the city name");
            System.out.println("7. Display the count of the persons by the state name");
            System.out.println("8. Back to AddressBook menu");
            System.out.println("Enter your choice");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createContact();
                    break;

                case 2:
                    editContacts();
                    break;

                case 3:
                    deleteContacts();
                    break;

                case 4:
                    displayContacts();
                    break;

                case 5:
                    filterByCity();
                    break;

                case 6:
                    countByCity();
                    break;

                case 7:
                    countByState();
                    break;

                case 8:
                    System.out.println("Entering back to Address Book menu");
                    break;

                default:
                    System.out.println("Please enter a valid choice!!!");
            }

        } while (choice != 8);

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choicemain = 0;

        do {
            System.out.println("\n==== ADDRESS BOOK SYSTEM ====");
            System.out.println("1. Create AddressBook");
            System.out.println("2. Open AddressBook");
            System.out.println("3. Show All AddressBooks");
            System.out.println("4. Search Person by City (All AddressBooks)");
            System.out.println("5. Search Person by State (All AddressBooks)");
            System.out.println("6. Search Person by First Name (All AddressBooks)");
            System.out.println("7. View by City (Dictionary)");
            System.out.println("8. View by State (Dictionary)");
            System.out.println("9. View Sorted List (Sort by First Name)");
            System.out.println("10. View Sorted List (Sort by City)");
            System.out.println("11. View Sorted List (Sort by State)");
            System.out.println("12. View Sorted List (Sort by Zip)");
            System.out.println("13. Exit");
            System.out.print("Enter choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a valid number.");
                sc.nextLine();
                continue;
            }

            choicemain = sc.nextInt();
            sc.nextLine();
            switch (choicemain) {

                case 1:
                    createAddressBook();
                    break;
//                    System.out.print("Enter new AddressBook name: ");
//                    String newBook = sc.nextLine();
//
//                    if (addressBook.containsKey(newBook)) {
//                        System.out.println("AddressBook already exists!");
//                    } else {
//                        addressBook.put(newBook, new AddressBookStr());
//                        System.out.println("AddressBook created!");
//                    }
//                    break;



                case 2:
                    System.out.print("Enter AddressBook name to open: ");
                    String openBook = sc.nextLine();

                    if (!addressBook.containsKey(openBook)) {
                        System.out.println("AddressBook not found!");
                    } else {
                        AddressBookStr selected = addressBook.get(openBook);
                        selected.contactMenu();
                    }
                    break;

                case 3:
                    System.out.println("\nAvailable AddressBooks:");
                    addressBook.keySet().forEach(System.out::println);
                    break;

                case 4:
                    searchPersonsByCity();
                    break;

                case 5:
                    searchPersonsByState();
                    break;

                case 6:
                    searchPersonsByName();
                    break;

                case 7:
                    viewByCityDictionary();
                    break;

                case 8:
                    viewByStateDictionary();
                    break;

                case 9:
                    sortByFirstName();
                    break;


                case 10:
                    sortByCity();
                    break;

                case 11:
                    sortByState();
                    break;

                case 12:
                    sortByZip();
                    break;

                case 13:
                    System.out.println("Thank you. Bye!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choicemain != 13);

    }

}
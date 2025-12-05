package com.iostreams;


import java.util.HashMap;
import java.util.Map;

public class AddressBookManager {
    private final Map<String, AddressBookStreams> addressBooks = new HashMap<>();

    public void addAddressBook(String name) {
        if (addressBooks.containsKey(name)) {
            System.out.println("Address Book already exists.");
            return;
        }
        addressBooks.put(name, new AddressBookStreams(name));
        System.out.println("Address Book added successfully.");
    }

    public AddressBookStreams getAddressBook(String name) {
        return addressBooks.get(name);
    }

    public void printAddressBooks() {
        addressBooks.keySet().forEach(System.out::println);
    }
}

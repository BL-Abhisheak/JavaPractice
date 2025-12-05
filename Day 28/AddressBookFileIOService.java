package com.iostreams;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AddressBookFileIOService {
    public static String FILE_NAME = "address_book-file.txt";

    public void writeData(List<ContactsStreams> contacts) {
        StringBuffer contactBuffer = new StringBuffer();
        contacts.forEach(c -> {
            contactBuffer.append(c.toString().concat("\n"));
        });

        try {
            Files.write(Paths.get(FILE_NAME), contactBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ContactsStreams parseContact(String line) {
        line = line.replace("Contact{", "").replace("}", "");

        String[] parts = line.split(",(?=(?:[^']*'[^']*')*[^']*$)");

        String firstName = parts[0].split("=")[1].trim().replace("'", "");
        String lastName = parts[1].split("=")[1].trim().replace("'", "");
        String address = parts[2].split("=")[1].trim().replace("'", "");
        String city = parts[3].split("=")[1].trim().replace("'", "");
        String state = parts[4].split("=")[1].trim().replace("'", "");
        String zipCode = String.valueOf(Integer.parseInt(parts[5].split("=")[1].trim()));
        String phoneNumber = String.valueOf(Long.parseLong(parts[6].split("=")[1].trim()));
        String email = parts[7].split("=")[1].trim().replace("'", "");

        return new ContactsStreams(firstName, lastName, address, city, state, zipCode, phoneNumber, email);
    }

    public List<ContactsStreams> readData() {
        List<ContactsStreams> contacts = new ArrayList<>();
        try {
            Files.lines(new File(FILE_NAME).toPath())
                    .forEach(line ->
                            contacts.add(parseContact(line)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    public void printData() {
        try {
            Files.lines(new File(FILE_NAME).toPath())
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long countEntries() {
        long entries = 0;
        try {
            entries = Files.lines(new File(FILE_NAME).toPath())
                    .count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entries;
    }

    public void writeCSV(List<ContactsStreams> contacts, String csvFileName) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFileName))) {

            String[] header = {"firstName", "lastName", "address", "city", "state", "zipCode", "phoneNumber", "email"};
            writer.writeNext(header);

            for (ContactsStreams c : contacts) {
                String[] row = {
                        c.getFirstName(),
                        c.getLastName(),
                        c.getAddress(),
                        c.getCity(),
                        c.getState(),
                        String.valueOf(c.getZip()),
                        String.valueOf(c.getPhoneNo()),
                        c.getEmail()
                };
                writer.writeNext(row);
            }

            System.out.println("CSV file written successfully: " + csvFileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<ContactsStreams> readCSV(String csvFileName) {
        List<ContactsStreams> contacts = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(csvFileName))) {

            reader.readNext();

            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {

                String firstName = nextLine[0];
                String lastName = nextLine[1];
                String address = nextLine[2];
                String city = nextLine[3];
                String state = nextLine[4];
                String zipCode = String.valueOf(Integer.parseInt(nextLine[5]));
                String phoneNumber = String.valueOf(Long.parseLong(nextLine[6]));
                String email = nextLine[7];

                contacts.add(new ContactsStreams(firstName, lastName, address, city, state, zipCode, phoneNumber, email));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return contacts;
    }

    public void writeJSON(List<ContactsStreams> contacts, String jsonFileName) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();   // pretty JSON output

        try (FileWriter writer = new FileWriter(jsonFileName)) {
            gson.toJson(contacts, writer);
            System.out.println("JSON file written successfully: " + jsonFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<ContactsStreams> readJSON(String jsonFileName) {
        List<ContactsStreams> contacts = new ArrayList<>();
        Gson gson = new Gson();

        try (FileReader reader = new FileReader(jsonFileName)) {

            Type contactListType = new TypeToken<List<ContactsStreams>>() {}.getType();
            contacts = gson.fromJson(reader, contactListType);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return contacts;
    }

}
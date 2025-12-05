package com.iostreams;

import java.io.*;

public class FileIO {

    public static void main(String[] args) {


        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write("file is getting created...");
            writer.write("\n This is the second line...");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try (BufferedReader reader = new BufferedReader(new FileReader("output.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}

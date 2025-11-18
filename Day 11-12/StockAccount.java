package com.practice;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class StockAccount {

    ArrayList<CompanyShares> list = new ArrayList<>();

    public StockAccount(String filename) {
        load(filename);
    }

    public void load(String filename) {
        try {
            File file = new File(filename);
            if (!file.exists()) {
                System.out.println("File not found. Creating new account.");
                return;
            }

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String data[] = line.split(",");

                String symbol = data[0];
                int shares = Integer.parseInt(data[1]);
                String date = data[2];

                CompanyShares cs = new CompanyShares(symbol, shares, date);
                list.add(cs);
            }
        } catch (Exception e) {
            System.out.println("Error loading file.");
        }
    }

    public double valueOf() {

        double total = 0;

        for (CompanyShares cs : list) {

            double price = 50;   // simple flat price for beginners

            total += cs.numberOfShares * price;
        }

        return total;
    }

    public void buy(int amount, String symbol) {

        for (CompanyShares cs : list) {
            if (cs.symbol.equalsIgnoreCase(symbol)) {
                cs.numberOfShares += amount;
                cs.dateTime = new Date().toString();
                return;
            }
        }

        CompanyShares newShare = new CompanyShares(symbol, amount, new Date().toString());
        list.add(newShare);
    }

    public void sell(int amount, String symbol) {

        for (CompanyShares cs : list) {
            if (cs.symbol.equalsIgnoreCase(symbol)) {

                if (amount > cs.numberOfShares) {
                    System.out.println("Not enough shares to sell!");
                    return;
                }

                cs.numberOfShares -= amount;
                cs.dateTime = new Date().toString();
                return;
            }
        }

        System.out.println("No such stock found in your account.");
    }

    public void save(String filename) {
        try {
            FileWriter fw = new FileWriter(filename);

            for (CompanyShares cs : list) {
                fw.write(cs.symbol + "," + cs.numberOfShares + "," + cs.dateTime + "\n");
            }

            fw.close();
            System.out.println("Account saved.");
        } catch (Exception e) {
            System.out.println("Error saving file.");
        }
    }

    public void printReport() {
        System.out.println("\n===== STOCK REPORT =====");

        for (CompanyShares cs : list) {
            System.out.println("Symbol: " + cs.symbol);
            System.out.println("Shares: " + cs.numberOfShares);
            System.out.println("Last Updated: " + cs.dateTime);
            System.out.println("-------------------------");
        }

        System.out.println("Total Account Value: $" + valueOf());
        System.out.println("===========================\n");
    }


    public static void main(String[] args) {

        StockAccount acc = new StockAccount("account.txt");

        acc.buy(10, "AAPL");
        acc.sell(5, "AAPL");
        acc.buy(20, "TSLA");

        acc.printReport();

        acc.save("account.txt");
    }
}

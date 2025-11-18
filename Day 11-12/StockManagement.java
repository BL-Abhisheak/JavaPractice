package com.practice;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Scanner;

public class StockManagement {

    int totalValueofStack = 0;
    int overallTotalValue = 0;

    private ArrayList<Stocks> stocks = new ArrayList<>();

    public void addStack(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the stock name : ");
        String stockName = sc.nextLine();

        System.out.println("Enter the number of stocks : ");
        int noOfStocks = sc.nextInt();

        System.out.println("Enter the Number of shares : ");
        int noOfshares =  sc.nextInt();

        System.out.println("Enter the share price : ");
        int sharePrice = sc.nextInt();

        Stocks s1 = new Stocks(stockName,noOfStocks,noOfshares,sharePrice);
        stocks.add(s1);
        System.out.println("Created stocks succesfully!!!!");
    }


    public void eachStockValue() {
        System.out.println("Enter the stock name to calculate the total stock value : ");
        Scanner sc = new Scanner(System.in);
        String stockName = sc.nextLine();

        boolean found = false;

        for (Stocks s : stocks) {
            if (s.getStockname().equalsIgnoreCase(stockName)) {

                int totalValue = (int) (s.getNoOfShares() * s.getSharePrice());
                System.out.println("Total value of stock " + stockName + " = " + totalValue);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Stock not found!");
        }
    }



    public void totalValueOfAllStocks() {

        int grandTotal = 0;

        for (Stocks s : stocks) {

            int stockValue = (int) (s.getNoOfShares() * s.getSharePrice());

            grandTotal += stockValue;
        }

        System.out.println("Total value of all stocks = " + grandTotal);
    }




    public static void main(String[] args) {
        StockManagement sm1 = new StockManagement();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Stock Management Menu ");
            System.out.println("1. Create a new Stock ");
            System.out.println("2. Calculate the stock value by Stock name ");
            System.out.println("3. View the total value of all Stocks");;
            System.out.println("4. Return to main menu ");
            System.out.println("5. Exit");
            System.out.println("Enter your choice : ");

            while (!sc.hasNextInt()){
                System.out.println("Invalid input!! Please enter a valid number");
                sc.next();
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1 : sm1.addStack(); break;
                case 2 : sm1.eachStockValue(); break;
                case 3 : sm1.totalValueOfAllStocks(); break;
                case 4 :
                    System.out.println("Returning to main menu....");
                    break;
                case 5 :
                    System.out.println("Exiting the program... BYE BYE !!!");
                    break;
                default:
                    System.out.println("Invalid choice!! Please enter a number between 1 and 5 ");

            }

        } while (choice!=5);

    }

}

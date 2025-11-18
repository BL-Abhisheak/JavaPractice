package com.practice;

public class Stocks {
     private String stockname;
     private int noOfStocks;
     private int noOfShares;
     private int sharePrice;


    public Stocks(String stockname, int noOfStocks, int noOfShares, int sharePrice) {
        this.stockname = stockname;
        this.noOfStocks = noOfStocks;
        this.noOfShares = noOfShares;
        this.sharePrice = sharePrice;
    }

    public String getStockname() {
        return stockname;
    }

    public void setStockname(String stockname) {
        this.stockname = stockname;
    }

    public int getNoOfShares() {
        return noOfShares;
    }

    public int getNoOfStocks() {
        return noOfStocks;
    }

    public void setNoOfStocks(int noOfStocks) {
        this.noOfStocks = noOfStocks;
    }

    public void setNoOfShares(int noOfShares) {
        noOfShares = noOfShares;
    }

    public double getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(int sharePrice) {
        this.sharePrice = sharePrice;
    }
}

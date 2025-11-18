package com.practice;

public class Account {

    public String withdraw(int accBal, int withdrawAmnt) {

        if (accBal < 0) {
            return "Invalid Account Balance!!!";
        }

        if (withdrawAmnt < 0) {
            return "Amount cannot be in negative!! Enter a valid amount....";
        }

        if (withdrawAmnt > accBal) {
            return "Insufficient Balance";
        } else if (withdrawAmnt == accBal) {
            return "WITHDRAW SUCCESSFUL!! The available balance after withdrawal is : 0";
        } else {
            int remainingBal = accBal - withdrawAmnt;
            return "WITHDRAW SUCCESSFUL!! The available balance after withdrawal is : " + remainingBal;
        }
    }

    public static void main(String[] args) {
        Account ac = new Account();
        System.out.println(ac.withdraw(10000,7000));  // 3000
        System.out.println(ac.withdraw(5000,1000));   // 4000
        System.out.println(ac.withdraw(1000,1200));   // Insufficient
        System.out.println(ac.withdraw(-1000,500));   // Invalid Account Balance!!!
        System.out.println(ac.withdraw(1000,-500));   // Amount cannot be in negative!!
    }
}

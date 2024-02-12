package com.Relearn;

import java.util.ArrayList;

record Customer (String name, ArrayList<Double> transactions){
    public Customer(String name, double initialDeposit){
        this(name.toLowerCase(), new ArrayList<Double>(500));

        transactions.add(initialDeposit);
    }
}

public class Bank {

    public static void main(String[] args) {
        Bank bank = new Bank("Chilo");
        bank.addNewCustomer("Loku Y",490.00);
        System.out.println(bank);

        bank.addTransaction("Loku Y", 300_000);
        bank.addTransaction("Loku Y", 270.00);
        bank.addTransaction("Loku Y", -47_000.00);
        bank.addTransaction("Loku y", -200000);

        bank.printStateMentOfAccount("Loku y");


        Customer sarah = new Customer("Sarah pj", 35000);
//        // even though we have Sarah as a customer, she still cannot be in our bank, until the calling code calls the addNewCustomer() method
        bank.addNewCustomer("Sarah Pj", 480_000);
        bank.addTransaction("Sarah pj", -71900);
        bank.printStateMentOfAccount("Sarah pj");

    }





    private String bankName;
    private ArrayList<Customer> customers = new ArrayList<>(5000);

    public Bank(String name){
        this.bankName = name;
    }



    private Customer getCustomer(String customerName){
        for (var customer : customers){
            if (customer.name().equalsIgnoreCase(customerName)){
                return customer;
            }
        }
        System.out.printf("Customer %s could not be found! %n", customerName);

        return null;
    }


    public void addNewCustomer(String name, double depositAmount){
        if (getCustomer(name) == null){
            Customer customer = new Customer(name, depositAmount);
            customers.add(customer);
            System.out.println("New customer added! " + customer);
        }


    }

    public void addTransaction(String name, double transactionAmount){
        Customer customer = getCustomer(name);
        if (customer != null) customer.transactions().add(transactionAmount);
        //auto-unboxing, because the ArrayList we are adding to is a wrapper Double, and we're getting a primitive double from our method parameter data

    }

    public void printStateMentOfAccount(String customerName){
        Customer customer = getCustomer(customerName);
        if (customer == null)
            return;

        System.out.println("---".repeat(10));
        System.out.printf("Customer name: %s %n", customer.name());
        System.out.println("Transactions:");

        for (double ttr : customer.transactions()) //here's our auto unboxing, becuase our transactions list takes a wrapper class 'Double'
            System.out.printf("#%10.3f (#%s) %n", ttr, ttr < 0 ? "debit" : "credit");

        System.out.println("---".repeat(10));

    }

    @Override
    public String toString() {
        return "Bank{" +
                "bankName='" + bankName + '\'' +
                ", customers=" + customers +
                '}';
    }
}

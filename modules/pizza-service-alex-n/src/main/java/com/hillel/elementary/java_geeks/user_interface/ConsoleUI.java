package com.hillel.elementary.java_geeks.user_interface;

import com.hillel.elementary.java_geeks.utils.Converter;

import java.util.Scanner;

public class ConsoleUI {

    static Scanner scanner = new Scanner(System.in);

    void showHello() {
        display("##### This is Pizza service #####");
    }

    void showOptions() {
        display("########## Categories ###########");
        display("Chose category:");
        display("1. Order");
        display("2. Pizza");
        display("3. Customer");
        display("4. EXIT.");
    }

    void showOrderOptions() {
        display("######## Order options ##########");
        display("What do you want to do? :");
        display("1. Create order");
        display("2. Get order status");
        display("3. Back");
    }

    void showPizzaOptions() {
        display("######### Pizza options #########");
        display("What do you want to do? :");
        display("1. List all pizzas");
        display("2. Back");
    }

    void showCustomerOptions() {
        display("####### Customer options ########");
        display("What do you want to do? :");
        display("1. List all customers");
        display("2. Back");
    }

    void display(String massage) {
        System.out.println(massage);
    }

    int getOrderId() {
        display("Enter order id:");
        return getIntUserAnswer(0, Integer.MAX_VALUE);
    }

    int[] getPizzaIdsFromUser(int maxId) {

        int[] pizzaIds = new int[0];
        boolean repeat = true;

        while (repeat) {
            display("Enter pizzas id's split by comas:");
            pizzaIds = Converter.convertUserStringToPizzaIds(getStringUserAnswer());
            for (int i = 0; i < pizzaIds.length; i++) {
                if (pizzaIds[i] > maxId) {
                    display("Sorry but there is now pizza with id=" + pizzaIds[i] + " in data base.");
                    pizzaIds = null;
                }
            }
            if (pizzaIds == null || pizzaIds.length == 0) {
                display("Something is wrong. Try again");
                repeat = true;
            } else {
                repeat = false;
            }
        }
        return pizzaIds;
    }

    String getStringUserAnswer() {

        boolean repeat = true;
        String userAnswer = null;

        while (repeat) {
            if (scanner.hasNext()) {
                userAnswer = scanner.next();
            }
            if (userAnswer == null || userAnswer.isEmpty()) {
                display("Something is wrong. Try again");
                repeat = true;
            } else {
                repeat = false;
            }
        }
        return userAnswer;
    }

    int getIntUserAnswer(int minInt, int maxInt) {

        boolean repeat = true;
        int userAnswer = -1;

        while (repeat) {
            try {
                if (scanner.hasNextInt()) {
                    userAnswer = scanner.nextInt();
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            if (userAnswer > maxInt || userAnswer < minInt) {
                display("Something is wrong. Try again");
                repeat = true;
            } else {
                repeat = false;
            }
        }
        return userAnswer;
    }

    String getCustomerName() {
        display("########### New Order ###########");
        display("Customer name:");
        return getStringUserAnswer();
    }

    void freeResources() {
        scanner.close();
    }
}



package com.hillel.elementary.java_geeks.user_interface;

import com.hillel.elementary.java_geeks.domain.Customer;
import com.hillel.elementary.java_geeks.domain.Order;
import com.hillel.elementary.java_geeks.domain.Pizza;
import com.hillel.elementary.java_geeks.services.CookService;
import com.hillel.elementary.java_geeks.services.CustomerService;
import com.hillel.elementary.java_geeks.services.OrderService;
import com.hillel.elementary.java_geeks.services.PizzaService;

import java.util.Collection;

import static com.hillel.elementary.java_geeks.user_interface.InterfaceState.ORDER;
import static com.hillel.elementary.java_geeks.user_interface.InterfaceState.ROOT;
import static com.hillel.elementary.java_geeks.user_interface.InterfaceState.PIZZA;
import static com.hillel.elementary.java_geeks.user_interface.InterfaceState.CUSTOMER;

public class Controller {

    private static final int ANSWER_ONE = 1;
    private static final int ANSWER_TWO = 2;
    private static final int ANSWER_THREE = 3;
    private static final int ANSWER_FOUR = 4;

    private InterfaceState currentState = ROOT;
    private ConsoleUI consoleUI = new ConsoleUI();

    private CustomerService customerService;
    private OrderService orderService;
    private PizzaService pizzaService;
    private CookService cookService;

    public Controller(CustomerService customerService,
                      OrderService orderService,
                      PizzaService pizzaService,
                      CookService cookService) {
        this.customerService = customerService;
        this.orderService = orderService;
        this.pizzaService = pizzaService;
        this.cookService = cookService;
    }

    public void runUserInterface() {

        consoleUI.showHello();

        while (true) {
            startDialogue();
        }
    }

    private void startDialogue() {
        switch (currentState) {

            case ROOT:
                consoleUI.showOptions();
                readRootResponse();
                break;

            case ORDER:
                consoleUI.showOrderOptions();
                readOrderResponse();
                break;

            case PIZZA:
                consoleUI.showPizzaOptions();
                readPizzaResponse();
                break;

            case CUSTOMER:
                consoleUI.showCustomerOptions();
                readCustomerResponse();
                break;

            default:
                break;
        }
    }

    private void readRootResponse() {
        switch (consoleUI.getIntUserAnswer(ANSWER_ONE, ANSWER_FOUR)) {

            case ANSWER_ONE:
                currentState = ORDER;
                break;

            case ANSWER_TWO:
                currentState = PIZZA;
                break;

            case ANSWER_THREE:
                currentState = CUSTOMER;
                break;

            case ANSWER_FOUR:
                consoleUI.freeResources();
                System.exit(0);
                break;

            default:
                break;
        }
    }

    private void readOrderResponse() {
        switch (consoleUI.getIntUserAnswer(ANSWER_ONE, ANSWER_THREE)) {

            case ANSWER_ONE:
                orderCreationDialog();
                break;

            case ANSWER_TWO:
                consoleUI.display(orderService.getOrderStatusInfo(consoleUI.getOrderId()));
                break;

            case ANSWER_THREE:
                currentState = ROOT;
                break;

            default:
                break;

        }
    }

    private void readPizzaResponse() {
        switch (consoleUI.getIntUserAnswer(ANSWER_ONE, ANSWER_TWO)) {

            case ANSWER_ONE:
                Collection<Pizza> pizzas = pizzaService.getAllPizzas();
                for (Pizza pizza : pizzas) {
                    consoleUI.display(pizza.toString());
                }
                break;

            case ANSWER_TWO:
                currentState = ROOT;
                break;

            default:
                break;
        }
    }

    private void readCustomerResponse() {
        switch (consoleUI.getIntUserAnswer(ANSWER_ONE, ANSWER_TWO)) {

            case ANSWER_ONE:
                Collection<Customer> customers = customerService.getAllCustomers();
                for (Customer customer : customers) {
                    consoleUI.display(customer.toString());
                }
                break;

            case ANSWER_TWO:
                currentState = ROOT;
                break;

            default:
                break;
        }
    }

    private void orderCreationDialog() {
        Customer registeredCustomer = customerService.registerCustomer(consoleUI.getCustomerName());
        int[] pizzaIds = consoleUI.getPizzaIdsFromUser(pizzaService.getAllPizzas().size() - 1);
        Order order = orderService.saveOrder(registeredCustomer, pizzaIds);
        cookService.passOrderToCook(order);
        consoleUI.display(order.toString());
    }
}

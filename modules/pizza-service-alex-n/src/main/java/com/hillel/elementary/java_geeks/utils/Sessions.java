package com.hillel.elementary.java_geeks.utils;

import com.hillel.elementary.java_geeks.domain.Pizza;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class Sessions {

    private Sessions() {
    }

    public static ArrayList<Pizza> getPizzasList(HttpSession session, String attrName) {
        Object attribute = session.getAttribute(attrName);
        if (attribute != null) {
            return (ArrayList<Pizza>) attribute;
        }
        return null;
    }

    public static void addPizzaToSessionOrder(HttpSession session, String attrName, Pizza pizza) {
        Object attribute = session.getAttribute(attrName);
        ArrayList<Pizza> pizzas;
        if (attribute != null) {
            pizzas = (ArrayList<Pizza>) attribute;
        } else {
            pizzas = new ArrayList<>();
        }
        pizzas.add(pizza);
        session.setAttribute(attrName, pizzas);
    }

    public static int getSessionOrderPizzasCount(HttpSession session, String attrName) {
        Object attribute = session.getAttribute(attrName);
        if (attribute != null) {
            return ((ArrayList<Pizza>) attribute).size();
        }
        return 0;
    }
}

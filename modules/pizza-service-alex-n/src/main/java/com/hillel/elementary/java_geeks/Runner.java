package com.hillel.elementary.java_geeks;

import com.hillel.elementary.java_geeks.configs.Context;
import com.hillel.elementary.java_geeks.configs.DefaultPizzaServiceContext;
import com.hillel.elementary.java_geeks.configs.PizzaServiceConfig;
import com.hillel.elementary.java_geeks.repositories.CustomerRepo;
import com.hillel.elementary.java_geeks.repositories.InMemCustomerRepo;
import com.hillel.elementary.java_geeks.repositories.JsonPizzaRepo;
import com.hillel.elementary.java_geeks.repositories.PizzaRepo;
import com.hillel.elementary.java_geeks.repositories.InMemOrderRepo;
import com.hillel.elementary.java_geeks.repositories.OrderRepo;
import com.hillel.elementary.java_geeks.services.CustomerService;
import com.hillel.elementary.java_geeks.services.DefaultCustomerService;
import com.hillel.elementary.java_geeks.services.DefaultPizzaService;
import com.hillel.elementary.java_geeks.services.PizzaService;
import com.hillel.elementary.java_geeks.services.DefaultOrderService;
import com.hillel.elementary.java_geeks.services.OrderService;
import com.hillel.elementary.java_geeks.services.DefaultCookService;
import com.hillel.elementary.java_geeks.services.CookService;
import com.hillel.elementary.java_geeks.user_interface.Controller;

public final class Runner {

    private Runner() {
    }

    public static void main(String[] args) throws Exception {

        Context context = new DefaultPizzaServiceContext(new PizzaServiceConfig());
        Controller controller = context.getBean("controller");
        controller.runUserInterface();
    }
}

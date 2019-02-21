package com.hillel.elementary.java_geeks;

import com.hillel.elementary.java_geeks.configs.Context;
import com.hillel.elementary.java_geeks.configs.DefaultPizzaServiceContext;
import com.hillel.elementary.java_geeks.configs.PizzaServiceConfig;
import com.hillel.elementary.java_geeks.user_interface.Controller;

public final class Runner {

    private Runner() {
    }

    public static void main(String[] args) {

        Context context = DefaultPizzaServiceContext.getInstance(new PizzaServiceConfig());
        Controller controller = context.getBean("controller");
        controller.runUserInterface();
    }
}

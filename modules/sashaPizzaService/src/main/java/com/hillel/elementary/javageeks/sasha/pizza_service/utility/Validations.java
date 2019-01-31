package com.hillel.elementary.javageeks.sasha.pizza_service.utility;

import java.util.Objects;

public class Validations {
    public static void checkNotNull(Object object,String fieldName){
        if(object == null){
            throw new IllegalStateException(String.format("%s should not be null",fieldName));
        }
    }
}

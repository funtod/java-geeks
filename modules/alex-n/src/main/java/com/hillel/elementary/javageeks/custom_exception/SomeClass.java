package com.hillel.elementary.javageeks.custom_exception;

public class SomeClass {

    public final void first() throws GlobalException {
        throw new GlobalException("Some of possible reasons cause an exception");
    }

    public final void second() throws SpecificException {
        try {
            first();
        } catch (GlobalException e) {
            throw new SpecificException("Some definite reasons cause an exception");
        }
    }

    class GlobalException extends Exception {
        GlobalException(String message) {
            super(message);
        }
    }

    class SpecificException extends GlobalException {
        SpecificException(String message) {
            super(message);
        }
    }
}

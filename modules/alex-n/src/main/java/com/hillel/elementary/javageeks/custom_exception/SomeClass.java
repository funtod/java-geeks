package com.hillel.elementary.javageeks.custom_exception;

public class SomeClass {

    public static void main(String[] args) {
        SomeClass someClass = new SomeClass();
        try {
            someClass.second();
        } catch (SpecificException e) {
            e.printStackTrace();
        }
    }

    public void first() throws GlobalException {
        throw new GlobalException("Some of possible reasons cause an exception");
    }

    public void second() throws SpecificException {
        try {
            first();
        } catch (GlobalException e) {
            throw new SpecificException("Some definite reasons cause an exception");
        }
    }

    class GlobalException extends Exception{
        public GlobalException(String message) {
            super(message);
        }
    }

    class SpecificException extends GlobalException{
        public SpecificException(String message) {
            super(message);
        }
    }
}

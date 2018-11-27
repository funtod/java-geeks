package com.hillel.elementary.javageeks.examples.exceptions;

public class Executor {

    public Object execute(Task task, int numberOfAttempts) {
        Object result = null;
        for (int actualNumberOfAttempts = 0; actualNumberOfAttempts < numberOfAttempts; actualNumberOfAttempts++) {
            try {
                result = task.run();
            } catch (Exception e) {
                if (actualNumberOfAttempts + 1 == numberOfAttempts) {
                    throw new ExecutionException(e);
                }
            }
        }
        return result;
    }
}

interface Task {
    public Object run();
}

class ExecutionException extends RuntimeException {
    ExecutionException(Exception e) {
        super(e);
    }
}

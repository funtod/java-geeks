package com.hillel.elementary.javageeks.examples.exceptions;

import java.io.IOException;
import java.util.Scanner;

public class Validator {

    /**
     *
     * @param ins
     * @throws IllegalArgumentException
     */
    public void validate(int[] ins) throws IOException {

        for (int i = 0; i < ins.length; i++) {
            if (ins[i]< 0)
                throw new IOException();
        }

    }

    public void useValidate() throws Exception {
        validate(new int[0]);
        try(Scanner scanner = new Scanner(System.in);) {
            scanner.nextInt();
        } catch (IllegalArgumentException e) {
            System.out.println("Something bad happened");
        }
    }
}

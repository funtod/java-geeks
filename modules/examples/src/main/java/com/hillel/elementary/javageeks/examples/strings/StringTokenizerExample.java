package com.hillel.elementary.javageeks.examples.strings;

import java.util.Objects;
import java.util.StringTokenizer;

public class StringTokenizerExample {

    public static Product[] parseProducts(String text) {
        StringTokenizer linesTokenizer = new StringTokenizer(text, "\n\r");
        Product[] products = new Product[linesTokenizer.countTokens()];
        int productCount = 0;

        while(linesTokenizer.hasMoreElements()) {
            String line = linesTokenizer.nextToken();
            StringTokenizer stringTokenizer = new StringTokenizer(line, "|");

            while (stringTokenizer.hasMoreElements()) {
                Integer id = Integer.parseInt(stringTokenizer.nextToken());
                Double price = Double.parseDouble(stringTokenizer.nextToken());
                String username = stringTokenizer.nextToken();

                Product product = new Product(id, price, username);
                products[productCount++] = product;
            }
        }

        return products;
    }
}


class Product {
    private int id;
    private Double price;
    private String userName;

    public Product(int id, Double price, String userName) {
        this.id = id;
        this.price = price;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || this.getClass() != other.getClass()) return false;
        Product product = (Product) other;
        return id == product.id &&
                Objects.equals(price, product.price) &&
                Objects.equals(userName, product.userName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, price, userName);
    }
}

package com.geekbrains.app;

public class Product {
    private int id;
    private String title;
    private float cost;

    public Product(int id, String title, float cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "[" + id + "]" + title + " - " + String.format("%.2f", cost) +" руб.";
    }
}

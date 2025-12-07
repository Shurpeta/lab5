package com.shurpeta.models;

public abstract class Tariff {
    String name;
    double price;
    int clients;

    public Tariff(String name, double price, int clients) {
        this.name = name;
        this.price = price;
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Тариф '" + name + "' | Ціна: " + price + " | Клієнтів: " + clients;
    }
}
package ru.tests.hw.shop;

import java.util.Objects;

public class Product {
    private Integer cost; // Стоимость продукта
    private String title; // Название

    public Product(String title, Integer cost) {
        this.cost = cost;
        this.title = title;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return cost.equals(product.cost) && title.equals(product.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cost, title);
    }
}
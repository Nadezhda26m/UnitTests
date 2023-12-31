package ru.tests.hw.shop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shop {
    private List<Product> products;

    public Shop(List<Product> products) {
        this.products = products;
    }

    public Shop() {
        products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice() {
        List<Product> productList = new ArrayList<>(products);
        productList.sort(Comparator.comparingInt(Product::getCost));
        return productList;
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct() {
        return products.stream()
                .max(Comparator.comparingInt(Product::getCost))
                .orElse(null);
    }

}
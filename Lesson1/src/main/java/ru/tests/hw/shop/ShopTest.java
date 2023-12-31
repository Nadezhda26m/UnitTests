package ru.tests.hw.shop;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

    /*
    Задание 2. Мы хотим улучшить функциональность нашего интернет-магазина.
    Ваша задача - добавить два новых метода в класс Shop:
    Метод sortProductsByPrice(), который сортирует список продуктов по стоимости.
    Метод getMostExpensiveProduct(), который возвращает самый дорогой продукт.
    1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов
    (правильное количество продуктов, верное содержимое корзины).
    2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
    3. Напишите тесты для проверки корректности работы метода sortProductsByPrice
    (проверьте правильность сортировки).
    Используйте класс Product для создания экземпляров продуктов и класс Shop для написания
    методов сортировки и тестов.
     */

public class ShopTest {

    public static void main(String[] args) {

        // проверка содержимого корзины
        checkEmptyProductsList();

        checkCreateProductsList();

        // проверка метода сортировки
        checkMethodSortProductsByPriceWithEmptyList();

        checkMethodSortProductsByPrice();

        // проверка получения самого дорогого продукта
        checkMethodGetMostExpensiveProduct();
    }

    private static void checkEmptyProductsList() {
        Shop shop = new Shop();
        assertThat(shop.getProducts())
                .isEmpty();
        assertThat(new Shop(new ArrayList<>()).getProducts())
                .isEmpty();
    }

    private static void checkCreateProductsList() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Картошка", 45));
        products.add(new Product("Огурец", 200));
        products.add(new Product("Морковь", 50));
        products.add(new Product("Лук", 80));

        Shop shop = new Shop(products);
        assertThat(shop.getProducts())
                .isNotEmpty()
                .hasSize(4)
                .containsAll(List.of(
                        new Product("Картошка", 45),
                        new Product("Лук", 80),
                        new Product("Морковь", 50),
                        new Product("Огурец", 200)));

        shop = new Shop();
        shop.setProducts(products);

        assertThat(shop.getProducts())
                .isNotEmpty()
                .hasSize(4)
                .containsAll(List.of(
                        new Product("Картошка", 45),
                        new Product("Лук", 80),
                        new Product("Морковь", 50),
                        new Product("Огурец", 200)));

        products.add(new Product("Морковь", 50));
        shop.setProducts(products);

        assertThat(shop.getProducts())
                .isNotEmpty()
                .hasSize(5)
                .containsAll(List.of(
                        new Product("Картошка", 45),
                        new Product("Лук", 80),
                        new Product("Морковь", 50),
                        new Product("Морковь", 50),
                        new Product("Огурец", 200)));
    }

    private static void checkMethodSortProductsByPriceWithEmptyList() {
        Shop shop = new Shop();
        assertThat(shop.sortProductsByPrice())
                .isEmpty();
    }

    private static void checkMethodSortProductsByPrice() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Картошка", 45));
        products.add(new Product("Огурец", 200));
        products.add(new Product("Морковь", 50));
        products.add(new Product("Лук", 80));

        Shop shop = new Shop(products);

        assertThat(shop.sortProductsByPrice())
                .isNotEmpty()
                .hasSize(4)
                .containsExactlyElementsOf(List.of(
                        new Product("Картошка", 45),
                        new Product("Морковь", 50),
                        new Product("Лук", 80),
                        new Product("Огурец", 200)));

        products = new ArrayList<>();
        products.add(new Product("Картошка", 45));
        products.add(new Product("Картошка", 45));
        products.add(new Product("Картошка", 45));

        shop.setProducts(products);

        assertThat(shop.sortProductsByPrice())
                .isNotEmpty()
                .hasSize(3)
                .containsExactlyElementsOf(List.of(
                        new Product("Картошка", 45),
                        new Product("Картошка", 45),
                        new Product("Картошка", 45)));

        products = new ArrayList<>();
        products.add(new Product("Картошка", 45));
        products.add(new Product("Помидор", 46));
        products.add(new Product("Салат", 45));
        products.add(new Product("Петрушка", 43));
        products.add(new Product("Укроп", 45));

        shop.setProducts(products);

        assertThat(shop.sortProductsByPrice())
                .isNotEmpty()
                .hasSize(5)
                .containsAll(List.of(
                        new Product("Помидор", 46),
                        new Product("Картошка", 45),
                        new Product("Петрушка", 43),
                        new Product("Салат", 45),
                        new Product("Укроп", 45)
                ))
                .startsWith(new Product("Петрушка", 43))
                .endsWith(new Product("Помидор", 46));
    }

    private static void checkMethodGetMostExpensiveProduct() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Картошка", 45));
        products.add(new Product("Огурец", 200));
        products.add(new Product("Морковь", 50));
        products.add(new Product("Лук", 80));

        Shop shop = new Shop(products);

        assertThat(shop.getMostExpensiveProduct())
                .isEqualTo(new Product("Огурец", 200));

        products = new ArrayList<>();
        products.add(new Product("Огурец", 200));
        products.add(new Product("Морковь", 50));
        products.add(new Product("Помидор", 200));
        products.add(new Product("Яблоко", 200));

        shop.setProducts(products);

        assertThat(shop.getMostExpensiveProduct())
                .isNotNull()
                .isIn(List.of(
                        new Product("Огурец", 200),
                        new Product("Яблоко", 200),
                        new Product("Помидор", 200)
                ));

        shop = new Shop();

        assertThat(shop.getMostExpensiveProduct())
                .isNull();
    }

}
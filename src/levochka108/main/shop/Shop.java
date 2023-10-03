package levochka108.main.shop;

import java.util.Collections;
import java.util.List;

public class Shop {
    private List<Product> products;

    // Конструктор и другие методы магазина

    public void sortProductsByPrice() {
        Collections.sort(products, (product1, product2) ->
                Double.compare(product1.getPrice(), product2.getPrice())
        );
    }

    public Product getMostExpensiveProduct() {
        if (products.isEmpty()) {
            return null; // Вернуть null, если список продуктов пуст
        }
        return Collections.max(products, (product1, product2) ->
                Double.compare(product1.getPrice(), product2.getPrice())
        );
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

}

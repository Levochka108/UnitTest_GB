package levochka108.main.shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ShopTest {
    private Shop shop;

    @BeforeEach
    public void setUp() {
        // Инициализация магазина и продуктов перед каждым тестом
        shop = new Shop();
        List<Product> products = new ArrayList<>();
        products.add(new Product("Product A", 10.0));
        products.add(new Product("Product B", 5.0));
        products.add(new Product("Product C", 15.0));
        shop.setProducts(products);
    }

    @Test
    public void testSortProductsByPrice() {
        shop.sortProductsByPrice();
        List<Product> sortedProducts = shop.getProducts();
        // Проверяем, что продукты отсортированы по возрастанию цены
        assertThat(sortedProducts).extracting(Product::getPrice)
                .containsExactly(5.0, 10.0, 15.0);
    }

    @Test
    public void testGetMostExpensiveProduct() {
        Product mostExpensive = shop.getMostExpensiveProduct();
        // Проверяем, что возвращается самый дорогой продукт
        assertThat(mostExpensive).isNotNull();
        assertThat(mostExpensive.getName()).isEqualTo("Product C");
        assertThat(mostExpensive.getPrice()).isEqualTo(15.0);
    }

    @Test
    public void testGetMostExpensiveProductEmptyShop() {
        // Проверяем, что при пустом магазине метод возвращает null
        shop.setProducts(new ArrayList<>());
        Product mostExpensive = shop.getMostExpensiveProduct();
        assertThat(mostExpensive).isNull();
    }
}

package uk.co.danielbryant.djshopping.productcatalogue.services;

import uk.co.danielbryant.djshopping.productcatalogue.model.Product;

import java.math.BigDecimal;
import java.util.*;

public class ProductService {

    //{productId, Product}
    private Map<String, Product> fakeProductDAO = new HashMap<>();

    public ProductService() {
        fakeProductDAO.put("1", new Product("1", "Classic", "Chicken, cabbage, cucumber, tomato", new BigDecimal(1.20)));
        fakeProductDAO.put("2", new Product("2", "Cheeser", "Chicken, cabbage, cheese", new BigDecimal(4.10)));
        fakeProductDAO.put("3", new Product("3", "Bacon", "Chicken, bacon, cucumber, mustard", new BigDecimal(45.50)));
        fakeProductDAO.put("4", new Product("4", "Teriyaki", "Chicken, teriyaki sauce", new BigDecimal(25.80)));
        fakeProductDAO.put("5", new Product("5", "Village", "Beef, mushrooms, potatoes", new BigDecimal(154.10)));
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(fakeProductDAO.values());
    }

    public Optional<Product> getProduct(String id) {
        return Optional.ofNullable(fakeProductDAO.get(id));
    }
}

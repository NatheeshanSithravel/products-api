package com.example.lecture3.service;

import com.example.lecture3.dto.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    public List<Product> getAllProducts() {
        return products;
    }

    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }

    public Product addProduct(Product product) {
        product.setId(nextId);
        nextId += 1L;
        products.add(product);
        return product;
    }

    public String deleteProduct(Long id) {
        boolean isDeleted = products.removeIf(product -> product.getId().equals(id));
        if (isDeleted) {
            return "Deleted successfully";
        }

        return "ID not found";
    }
}
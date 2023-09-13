package com.treino.treino.repository;

import com.treino.treino.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<Product> products = new ArrayList<>();
    public Product save(Product product){
        products.add(product);
        return product;
    }

    public Product findById(Long id){
        return products.stream().filter(product -> product.getId().equals(product.getId()))
                .findFirst().orElse(null);
    }

    public List<Product> findAll(){
        return products;
    }

    public Product update(Product product){
        products.removeIf(product1 -> product1.getId().equals(product.getId()));
        products.add(product);
        return product;
    }

    public void deleteById(Long id){
        products.removeIf(product1 -> product1.getId().equals(id));
    }
}

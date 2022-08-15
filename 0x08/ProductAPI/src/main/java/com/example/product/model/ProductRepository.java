package com.example.product.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ProductRepository {

    private List<Product> list = new ArrayList<Product>();

    public List<Product> getAllProducts() {
        return list;
    }

    public Product getProductById(Integer id) {
        Long longId = Long.valueOf(id);
        return list.stream().filter(product -> Objects.equals(product.getId(), longId)).findFirst().orElse(null);
    }

    public void addProduct(Product s) {
        list.add(s);
    }

    public void updateProduct(Product s) {
        Integer intId = s.getId().intValue();
        int index = list.indexOf(getProductById(intId));
        list.set(index,s);
    }

    public void removeProduct(Product s) {
        list.remove(s);
    }

    public void addList(List<Product> listOfProducts) {
        list.addAll(listOfProducts);
    }
}

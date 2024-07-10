package org.example.bai_thi_md3.service;

import org.example.bai_thi_md3.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> selectAll();

    void createProduct(Product product);
}

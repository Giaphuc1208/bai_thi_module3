package org.example.bai_thi_md3.repositories;

import org.example.bai_thi_md3.models.Product;

import java.util.List;

public interface IProductRepo {
    List<Product> selectAll();

    void createProduct(Product product);
}

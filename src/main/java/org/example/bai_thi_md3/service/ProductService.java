package org.example.bai_thi_md3.service;

import org.example.bai_thi_md3.models.Product;
import org.example.bai_thi_md3.repositories.IProductRepo;
import org.example.bai_thi_md3.repositories.ProductRepo;

import java.util.List;

public class ProductService implements IProductService{
    private static IProductRepo productRepo = new ProductRepo();
    @Override
    public List<Product> selectAll() {
        return productRepo.selectAll();
    }

    @Override
    public void createProduct(Product product) {
        productRepo.createProduct(product);
    }
}

package org.example.bai_thi_md3.controller;

import org.example.bai_thi_md3.models.Product;
import org.example.bai_thi_md3.service.IProductService;
import org.example.bai_thi_md3.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product/*")
public class ProductServlet extends HttpServlet {
    private static IProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String url = req.getPathInfo();
        switch (url){
            case "/list":
                selectAll(req,resp);
                break;
            case "/create":
                showFormCreate(req,resp);
                break;

        }
    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/create.jsp").forward(req,resp);
    }

    private void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.selectAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/views/products.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String url = req.getPathInfo();
        switch (url){
            case "/create":
                createProduct(req,resp);
                break;
        }
    }

    private void createProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Product product = new Product();
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        double discount = Double.parseDouble(req.getParameter("discount"));
        int stock = Integer.parseInt(req.getParameter("stock"));
        product.setName(name);
        product.setPrice(price);
        product.setDiscount(discount);
        product.setStock(stock);
        productService.createProduct(product);
        resp.sendRedirect("/product/list");
    }
}

package service;

import dao.ProductDAO;

public class ProductService {

    private final ProductDAO productDao;

    public ProductService() {
        this.productDao = new ProductDAO();
    }
}

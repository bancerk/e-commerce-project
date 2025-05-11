package service;

import dao.ProductDAO;
import exception.ExceptionMessagesConstants;
import exception.PatikaStoreException;
import model.Product;
import model.User;
import model.enums.Role;

import java.util.List;

public class ProductService {

    private final ProductDAO productDAO;

    public ProductService() {
        this.productDAO = new ProductDAO();
    }

    public void save(Product product, User user) throws PatikaStoreException {

        if (!Role.ADMIN.equals(user.getRole())) {
            throw new PatikaStoreException(ExceptionMessagesConstants.USER_IS_NOT_ADMIN);
        }
        product.setCreatedUser(user);
        product.setUpdatedUser(user);
        productDAO.save(product);

        System.out.println("Ürün kaydedildi.");
    }

    public List<Product> getAll() {
        return productDAO.findAll();
    }

    public void deleteById(long id) {
        productDAO.delete(id);
        System.out.println("Ürün silindi: " + id);
    }
}

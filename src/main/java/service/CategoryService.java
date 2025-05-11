package service;

import dao.CategoryDAO;
import exception.ExceptionMessagesConstants;
import exception.PatikaStoreException;
import model.Category;
import model.User;
import model.enums.Role;

import java.util.List;

public class CategoryService {

    private final CategoryDAO categoryDAO;

    public CategoryService() {
        this.categoryDAO = new CategoryDAO();
    }

    public void save(String name, User user) throws PatikaStoreException {

        if (!Role.ADMIN.equals(user.getRole())) {
            throw new PatikaStoreException(ExceptionMessagesConstants.USER_IS_NOT_ADMIN);
        }

        categoryDAO.save(new Category(name, user, user));

        System.out.println("Kategori oluşturuldu!");
    }

    public List<Category> getAll() {
        return categoryDAO.findAll();
    }

    public void deleteById(long id) {
        categoryDAO.delete(id);
        System.out.println("Kategori Silindi.");
    }

    public Category getById(long productCategoryId) throws PatikaStoreException {

        Category foundCategory = CategoryDAO.findById(productCategoryId);

        if (foundCategory == null) {
            throw new PatikaStoreException(ExceptionMessagesConstants.CATEGORY_NOT_FOUND);
        }
        System.out.println("Kategori Bulundu: " + foundCategory);
        return foundCategory;
    }
}

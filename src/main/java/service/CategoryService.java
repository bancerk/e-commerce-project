package service;

import dao.categoryDAO;
import exception.ExceptionMessagesConstants;
import exception.PatikaStoreException;
import model.Category;
import model.User;
import model.enums.Role;

public class CategoryService {

    private final categoryDAO categoryDAO;

    public CategoryService() {
        this.categoryDAO = new categoryDAO();
    }

    public void save(String name, User user) throws PatikaStoreException {

        if (!Role.ADMIN.equals(user.getRole())) {
            throw new PatikaStoreException(ExceptionMessagesConstants.USER_IS_NOT_ADMIN);
        }

        categoryDAO.save(new Category(name,user,user));

        System.out.println("Kategori oluşturuldu!");
    }
}

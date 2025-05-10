package service;

import dao.UserDAO;
import exception.ExceptionMessagesConstants;
import exception.PatikaStoreException;
import model.User;
import model.enums.Role;
import util.PasswordUtil;

public class UserService {

    private final UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }

    public void save(String userName, String password, Role role) throws PatikaStoreException {

        User foundUser = userDAO.findByUserName(userName);

        if (foundUser != null) {
            throw new PatikaStoreException(ExceptionMessagesConstants.USER_EMAIL_ALREADY_EXISTS);
        }

        userDAO.save(new User(userName,PasswordUtil.hash(password), Role.SUPPORT));
        System.out.println("Kayıt başarılı!");


    }

    public User login(String userName, String password) throws PatikaStoreException {

        User foundUser = userDAO.findByUserName(userName);

        if (foundUser != null) {
            String hashedPassword = PasswordUtil.hash(password);
            if (!hashedPassword.equals(foundUser.getPassword())) {
                throw new PatikaStoreException(ExceptionMessagesConstants.USER_PASSWORD_DOES_NOT_MATCH);
            }
        } else {
            throw new PatikaStoreException(ExceptionMessagesConstants.USER_PASSWORD_DOES_NOT_MATCH);
        }
        System.out.println("Giriş Başarılı!");
        System.out.println("Hoş Geldin " + foundUser.getUsername() + " !");

        return foundUser;
    }
}

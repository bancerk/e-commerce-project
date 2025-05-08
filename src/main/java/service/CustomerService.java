package service;

import dao.CustomerDAO;
import exception.ExceptionMessagesConstants;
import exception.PatikaStoreException;
import model.Customer;
import util.PasswordUtil;

public class CustomerService {
    
    private final CustomerDAO customerDao;
    
    public CustomerService() {
        customerDao = new CustomerDAO();
    }

    public void save(String name, String email, String password) throws PatikaStoreException {

        boolean isExist = customerDao.existByEmail(email);

        if (isExist) {
            throw new PatikaStoreException(ExceptionMessagesConstants.CUSTOMER_EMAIL_ALREADY_EXISTS);
        }

        Customer customer = new Customer(name,email, PasswordUtil.hash(password));
        customerDao.save(customer);
        System.out.println("Kayıt Başarılı.");
    }

    public void login(String email, String password) throws PatikaStoreException {
        boolean isExist = customerDao.existByEmail(email);

        if (!isExist) {
            throw new PatikaStoreException(ExceptionMessagesConstants.CUSTOMER_EMAIL_DOES_NOT_EXIST);
        }

        String hashedPassword = PasswordUtil.hash(password);

        Customer foundCustomer = CustomerDAO.findByEmail(email);

        if (foundCustomer != null) {
            boolean passwordEquals = foundCustomer.getCustomerPassword().equals(hashedPassword);
            if (!passwordEquals) {
                throw new PatikaStoreException(ExceptionMessagesConstants.CUSTOMER_PASSWORD_DOES_NOT_MATCH);
            }else {
                System.out.println("Kullanıcı sisteme giriş yaptı !");
            }
        }
    }
}

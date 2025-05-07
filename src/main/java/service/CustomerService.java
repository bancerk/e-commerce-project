package service;

import dao.CustomerDao;
import exception.ExceptionMessagesConstants;
import exception.PatikaStoreException;
import model.Customer;
import util.PasswordUtil;

public class CustomerService {
    
    private CustomerDao customerDao;
    
    public CustomerService() {
        customerDao = new CustomerDao();
    }

    public void save(String name, String email, String password) {

        boolean isExist = customerDao.existByEmail(email);

        if (isExist) {
            throw new PatikaStoreException(ExceptionMessagesConstants.CUSTOMER_EMAIL_ALREADY_EXISTS);
        }

        Customer customer = new Customer(name,email, PasswordUtil.hash(password));
        customerDao.save(customer);
        System.out.println("Kayıt Başarılı.");
    }
}

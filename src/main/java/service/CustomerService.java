package service;

import dao.CustomerDao;
import model.Customer;
import util.PasswordUtil;

public class CustomerService {
    
    private CustomerDao customerDao;
    
    public CustomerService() {
        customerDao = new CustomerDao();
    }

    public void save(String name, String email, String password) {

        Customer customer = new Customer(name,email, PasswordUtil.hash(password));

        customerDao.save(customer);
        
        System.out.println("Kayıt Başarılı.");
    }
}

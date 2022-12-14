package com.bootcoding.restaurant.service;

import com.bootcoding.restaurant.dao.CustomerDao;
import com.bootcoding.restaurant.model.Customer;
import com.bootcoding.restaurant.utils.AddressGenerator;
import com.bootcoding.restaurant.utils.EmailIdGenerator;
import com.bootcoding.restaurant.utils.NameGenerator;
import com.bootcoding.restaurant.utils.PhoneNumberGenerator;

public class CustomerService {
    private CustomerDao customerDAO;

    public CustomerService(){
        customerDAO = new CustomerDao();
    }

    public void createDummyCustomers(){
        for(int i = 0; i < 100; i++){
            Customer customer = new Customer();
            customer.setCustomerId(i + 1);
            customer.setName(NameGenerator.getName());
            customer.setAddress(AddressGenerator.getAddress());
            customer.setEmailId(EmailIdGenerator.
                    getEmailId(customer.getName()));
            customer.setCity("Nagpur");
            customer.setState("Maharashtra");
            customer.setPhonenumber(PhoneNumberGenerator.getPhoneNumber());

            customerDAO.insertCustomerDao(customer);

        }
    }

    public void createTable() {
        customerDAO.createTable();
    }
}

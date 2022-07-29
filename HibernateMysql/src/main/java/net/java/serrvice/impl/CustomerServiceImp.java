package net.java.serrvice.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import net.java.entity.Customer;
import net.java.repository.CustomerRepository;
import net.java.serrvice.CustomerService;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
    
    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        //Customer customer = new Customer();
        customer.setId(1);
        customer.setFirstName("Mg");
        customer.setLastName("Hla");
        customer.setEmail("mghla@gmail.com");
        this.customerRepository.save(customer);

    }

    @Override
    @Transactional
    public Customer getCustomer(int id) {
        return customerRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void deleteCustomer(int theId) {
        customerRepository.deleteById(theId);
    }

    
}

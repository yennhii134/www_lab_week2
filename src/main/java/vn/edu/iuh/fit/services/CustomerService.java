package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.models.Customer;
import vn.edu.iuh.fit.repositories.CustomerRepository;

import java.util.List;
import java.util.Optional;

public class CustomerService {
    private CustomerRepository customerRepository;
    public CustomerService(){
        customerRepository = new CustomerRepository();
    }
    public Optional<Customer> findById(long id){
        return customerRepository.findById(id);
    }
    public List<Customer> getAll(){
        return customerRepository.getAll();
    }
    public boolean add(Customer customer){
        return customerRepository.add(customer);
    }
    public Optional<Boolean> update(Customer customer){
        Optional<Customer> optional = findById(customer.getId());

        if (optional.isEmpty())
            return Optional.empty();

        return Optional.of(customerRepository.update(customer));
    }
    public boolean insert(Customer customer){
        return customerRepository.add(customer);
    }
}

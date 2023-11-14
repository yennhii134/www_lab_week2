package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.enums.EmployeeStatus;
import vn.edu.iuh.fit.models.Customer;
import vn.edu.iuh.fit.models.Employee;
import vn.edu.iuh.fit.repositories.CustomerRepository;
import vn.edu.iuh.fit.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class CustomerService {
    private CustomerRepository customerRepository;
    public CustomerService(){
        customerRepository = new CustomerRepository();
    }
    public void insertEmp(Customer customer){
        customerRepository.insertCustomer(customer);
    }
    public Optional<Customer> findById(long id){
        return customerRepository.findById(id);
    }
    public boolean deleteCustomer(long id){
        Optional<Customer> optional = findById(id);
        if(optional.isPresent()){
            Customer customer = optional.get();
            return true;
        }
        return false;
    }
    public boolean activeCustomer(long id){
        Optional<Customer> optional = findById(id);
        if(optional.isPresent()){
            Customer customer = optional.get();
            return true;
        }
        return false;
    }
    public List<Customer> getAllCustomer(){
        return customerRepository.getAllCustomer();
    }

}

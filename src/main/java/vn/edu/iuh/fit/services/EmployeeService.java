package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.enums.EmployeeStatus;
import vn.edu.iuh.fit.models.Employee;
import vn.edu.iuh.fit.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeService {
    private EmployeeRepository employeeRepository;
    public EmployeeService(){
        employeeRepository = new EmployeeRepository();
    }
    public boolean insert(Employee employee){
       return employeeRepository.add(employee);
    }
    public Optional<Boolean> update(Employee employee){
        Optional<Employee> optional = findById(employee.getId());

        if (optional.isEmpty())
            return Optional.empty();

        return Optional.of(employeeRepository.update(employee));
    }
    public Optional<Employee> findById(long id){
        return employeeRepository.findById(id);
    }
    public boolean delete(long id){
        Optional<Employee> optional = findById(id);
        if(optional.isPresent()){
            Employee employee = optional.get();
            employee.setEmployeeStatus(EmployeeStatus.TERMINATED);
            return true;
        }
        return false;
    }
    public boolean activeEmp(long id){
        Optional<Employee> optional = findById(id);
        if(optional.isPresent()){
            Employee employee = optional.get();
            employee.setEmployeeStatus(EmployeeStatus.ACTIVE);
            return true;
        }
        return false;
    }
    public List<Employee> getAll(){
        return employeeRepository.getAll();
    }

}

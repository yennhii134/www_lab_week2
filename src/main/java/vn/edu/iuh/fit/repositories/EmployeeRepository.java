package vn.edu.iuh.fit.repositories;


import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.enums.EmployeeStatus;
import vn.edu.iuh.fit.models.Employee;

import java.util.List;
import java.util.Optional;

public class EmployeeRepository extends CRUDRepository<Employee>{

    public EmployeeRepository(){
        super();
       logger = LoggerFactory.getLogger(this.getClass().getName());
    }
    public void setEmployeeStatus(Employee employee, EmployeeStatus status) {
        employee.setEmployeeStatus(status);
    }

    public Optional<Employee> findById(long id){
        try {
            return Optional.of(em.find(Employee.class, id));
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return Optional.empty();
    }
    public List<Employee> getAll() {
        return em.createNamedQuery("Employee.getAll", Employee.class).
                setParameter("status",EmployeeStatus.ACTIVE).
                getResultList();
    }
}

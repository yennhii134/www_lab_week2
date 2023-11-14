package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import vn.edu.iuh.fit.enums.EmployeeStatus;
import vn.edu.iuh.fit.models.Employee;

import java.util.List;
import java.util.Optional;

public class EmployeeRepository {
    private EntityManager em;
    private EntityTransaction trans;
    public EmployeeRepository(){
        em = Persistence.createEntityManagerFactory("lab_week_2")
                .createEntityManager();
        trans = em.getTransaction();
    }
    public void setEmployeeStatus(Employee employee, EmployeeStatus status) {
        employee.setEmployeeStatus(status);
    }
    public void insertEmp(Employee employee){
        try {
            trans.begin();
            em.persist(employee);
            trans.commit();
        }catch (Exception e){
            trans.rollback();
            e.printStackTrace();
        }
    }
    public void setStatus(Employee employee, EmployeeStatus status){
        employee.setEmployeeStatus(status);
    }
    public void updateEmp(Employee employee){
        try {
            trans.begin();
            em.merge(employee);
            trans.commit();
        }catch (Exception e){
            trans.rollback();
            e.printStackTrace();
        }
    }
    public Optional<Employee> findById(long id){
        TypedQuery<Employee> query = em.createQuery("select e from Employee e where e.id=:id", Employee.class);
        query.setParameter("id", id);
        Employee emp = query.getSingleResult();
        return emp == null ? Optional.empty() : Optional.of(emp);
    }
    public List<Employee> getAllEmp() {
        return em.createNamedQuery("Employee.findAll", Employee.class).
                setParameter("status",EmployeeStatus.ACTIVE).
                getResultList();
    }
}

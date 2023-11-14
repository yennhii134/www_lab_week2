package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import vn.edu.iuh.fit.enums.EmployeeStatus;
import vn.edu.iuh.fit.models.Customer;
import vn.edu.iuh.fit.models.Employee;

import java.util.List;
import java.util.Optional;

public class CustomerRepository {
    private EntityManager em;
    private EntityTransaction trans;
    public CustomerRepository(){
        em = Persistence.createEntityManagerFactory("lab_week_2")
                .createEntityManager();
        trans = em.getTransaction();
    }
    public void insertCustomer(Customer customer){
        try {
            trans.begin();
            em.persist(customer);
            trans.commit();
        }catch (Exception e){
            trans.rollback();
            e.printStackTrace();
        }
    }
    public void updateCustomer(Customer customer){
        try {
            trans.begin();
            em.merge(customer);
            trans.commit();
        }catch (Exception e){
            trans.rollback();
            e.printStackTrace();
        }
    }
    public Optional<Customer> findById(long id){
        TypedQuery<Customer> query = em.createQuery("select c from Customer c where c.id=:id", Customer.class);
        query.setParameter("id", id);
        Customer customer = query.getSingleResult();
        return customer == null ? Optional.empty() : Optional.of(customer);
    }
    public List<Customer> getAllCustomer() {
        return em.createNamedQuery("Customer.findAll", Customer.class).
                getResultList();
    }
}

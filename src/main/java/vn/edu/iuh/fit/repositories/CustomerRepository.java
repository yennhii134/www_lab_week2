package vn.edu.iuh.fit.repositories;

import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.models.Customer;

import java.util.List;
import java.util.Optional;

public class CustomerRepository extends CRUDRepository<Customer> {
    public CustomerRepository(){
        super();
        logger = LoggerFactory.getLogger(this.getClass().getName());
    }
    public List<Customer> getAll(){
        return em.createNamedQuery("Customer.getAll", Customer.class).getResultList();
    }
    public Optional<Customer> findById(long id){
        try {
            return Optional.of(em.find(Customer.class, id));
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return Optional.empty();
    }
}

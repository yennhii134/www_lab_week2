package vn.edu.iuh.fit.repositories;

import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.models.Order;
import vn.edu.iuh.fit.models.Product;

import java.util.List;
import java.util.Optional;

public class OrderRepository extends CRUDRepository<Order> {
    public OrderRepository(){
        super();
        logger = LoggerFactory.getLogger(this.getClass().getName());
    }
    public List<Order> getAll(){
        return em.createNamedQuery("Order.getAll", Order.class).getResultList();
    }
    public Optional<Order> findById(long id){
        try {
            return Optional.of(em.find(Order.class, id));
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return Optional.empty();
    }
}

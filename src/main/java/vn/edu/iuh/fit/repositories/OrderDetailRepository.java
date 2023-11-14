package vn.edu.iuh.fit.repositories;

import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.models.OrderDetail;

import java.util.List;
import java.util.Optional;

public class OrderDetailRepository extends CRUDRepository<OrderDetail> {
    public OrderDetailRepository(){
        super();
        logger = LoggerFactory.getLogger(this.getClass().getName());
    }
    public List<OrderDetail> getAll(){
        return em.createNamedQuery("OrderDetail.getAll", OrderDetail.class).getResultList();
    }
    public Optional<OrderDetail> findById(long orderId, long productId){
        try {
            OrderDetail orderDetail = em.createNamedQuery("OrderDetail.findById", OrderDetail.class)
                    .setParameter("orderId", orderId)
                    .setParameter("productId",productId)
                    .getSingleResult();
            return Optional.of(orderDetail);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return Optional.empty();
    }
}

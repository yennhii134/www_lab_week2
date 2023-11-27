package vn.edu.iuh.fit.repositories;

import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.models.Customer;
import vn.edu.iuh.fit.models.Product;

import java.util.List;
import java.util.Optional;

public class ProductRepository extends CRUDRepository<Product> {
    public ProductRepository(){
        super();
        logger = LoggerFactory.getLogger(this.getClass().getName());
    }
    public List<Product> getAll(){
        return em.createNamedQuery("Product.getAll", Product.class).getResultList();
    }
    public Optional<Product> findById(long id){
        try {
            return Optional.of(em.find(Product.class, id));
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return Optional.empty();
    }
}

package vn.edu.iuh.fit.repositories;

import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.models.ProductImage;

import java.util.List;
import java.util.Optional;

public class ProductImageRepository extends CRUDRepository<ProductImage> {
    public ProductImageRepository(){
        super();
        logger = LoggerFactory.getLogger(this.getClass().getName());
    }
    public List<ProductImage> getAll(){
        return em.createNamedQuery("ProductImage.getAll", ProductImage.class).getResultList();
    }
    public Optional<ProductImage> findById(long id){
        try {
            return Optional.of(em.find(ProductImage.class, id));
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return Optional.empty();
    }
}

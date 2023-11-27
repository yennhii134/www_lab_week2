package vn.edu.iuh.fit.repositories;

import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.models.ProductPrice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class ProductPriceRepository extends CRUDRepository<ProductPrice> {
    public ProductPriceRepository(){
        super();
        logger = LoggerFactory.getLogger(this.getClass().getName());
    }
    public List<ProductPrice> getAll(){
        return em.createNamedQuery("ProductPrice.getAll", ProductPrice.class)
                .getResultList();
    }
    public Optional<ProductPrice> findById(long productId, LocalDateTime date){
        try {
            ProductPrice productPrice = em.createNamedQuery("ProductPrice.findById", ProductPrice.class)
                    .setParameter("productId", productId)
                    .setParameter("priceDateTime",date)
                    .getSingleResult();
            return Optional.of(productPrice);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return Optional.empty();
    }
    public List<ProductPrice> getPriceLastest(){
        return em.createNamedQuery("ProductPrice.getPriceLatest", ProductPrice.class).getResultList();
    }
}

package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.models.ProductPrice;
import vn.edu.iuh.fit.repositories.ProductPriceRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class ProductPriceService {
    private ProductPriceRepository productPriceRepository;
    public ProductPriceService(){
        productPriceRepository = new ProductPriceRepository();
    }
    public Optional<ProductPrice> findById(long id, LocalDateTime priceDateTime){
        return productPriceRepository.findById(id,priceDateTime);
    }
    public List<ProductPrice> getAll(){
        return productPriceRepository.getAll();
    }
    public boolean add(ProductPrice productPrice){
        return productPriceRepository.add(productPrice);
    }
    public Optional<Boolean> update(ProductPrice productPrice){
        Optional<ProductPrice> optional = findById(productPrice.getProduct().getId(),productPrice.getPriceDateTime());

        if (optional.isEmpty())
            return Optional.empty();

        return Optional.of(productPriceRepository.update(productPrice));
    }
    public boolean insert(ProductPrice productPrice){
        return productPriceRepository.add(productPrice);
    }
    public List<ProductPrice> getPriceLastest(){
        return productPriceRepository.getPriceLastest();
    }
}

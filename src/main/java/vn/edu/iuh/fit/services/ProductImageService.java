package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.models.ProductImage;
import vn.edu.iuh.fit.repositories.ProductImageRepository;

import java.util.List;
import java.util.Optional;

public class ProductImageService{
    private ProductImageRepository productImageRepository;
    public ProductImageService(){
        productImageRepository = new ProductImageRepository();
    }
    public Optional<ProductImage> findById(long id){
        return productImageRepository.findById(id);
    }
    public List<ProductImage> getAll(){
        return productImageRepository.getAll();
    }
    public boolean add(ProductImage productImage){
        return productImageRepository.add(productImage);
    }
    public Optional<Boolean> update(ProductImage productImage){
        Optional<ProductImage> optional = findById(productImage.getId());

        if (optional.isEmpty())
            return Optional.empty();

        return Optional.of(productImageRepository.update(productImage));
    }
    public boolean insert(ProductImage productImage){
        return productImageRepository.add(productImage);
    }
}

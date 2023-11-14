package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.models.Customer;
import vn.edu.iuh.fit.models.Product;
import vn.edu.iuh.fit.repositories.CustomerRepository;
import vn.edu.iuh.fit.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductService {
    private ProductRepository productRepository;
    public ProductService(){
        productRepository = new ProductRepository();
    }
    public Optional<Product> findById(long id){
        return productRepository.findById(id);
    }
    public List<Product> getAll(){
        return productRepository.getAll();
    }
    public boolean add(Product product){
        return productRepository.add(product);
    }
    public Optional<Boolean> update(Product product){
        Optional<Product> optional = findById(product.getId());

        if (optional.isEmpty())
            return Optional.empty();

        return Optional.of(productRepository.update(product));
    }
    public boolean insert(Product product){
        return productRepository.add(product);
    }
}

package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.enums.ProductStatus;

import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "product_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", length = 150, nullable = false)
    private String name;
    @Column(name = "description", length = 250)
    private String description;
    @Column(name = "unit", length = 25)
    private String unit;
    @Column(name = "manufacturer_name", length = 100)
    private String manufacturerName;
    @Column(name = "status", nullable = false)
    private ProductStatus productStatus;
    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;
    @OneToMany(mappedBy = "product")
    private List<ProductImage> productImages;
    @OneToMany(mappedBy = "product")
    private List<ProductPrice> productPrices;

    public Product(){

    }
    public Product(long id, String name, String description, String unit, String manufacturerName, ProductStatus productStatus, List<OrderDetail> orderDetails, List<ProductImage> productImages, List<ProductPrice> productPrices) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturerName = manufacturerName;
        this.productStatus = productStatus;
        this.orderDetails = orderDetails;
        this.productImages = productImages;
        this.productPrices = productPrices;
    }

    public Product(String name, String description, String unit, String manufacturerName, ProductStatus productStatus, List<OrderDetail> orderDetails, List<ProductImage> productImages, List<ProductPrice> productPrices) {
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturerName = manufacturerName;
        this.productStatus = productStatus;
        this.orderDetails = orderDetails;
        this.productImages = productImages;
        this.productPrices = productPrices;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public ProductStatus getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(ProductStatus productStatus) {
        this.productStatus = productStatus;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public List<ProductImage> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<ProductImage> productImages) {
        this.productImages = productImages;
    }

    public List<ProductPrice> getProductPrices() {
        return productPrices;
    }

    public void setProductPrices(List<ProductPrice> productPrices) {
        this.productPrices = productPrices;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unit='" + unit + '\'' +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", productStatus=" + productStatus +
                ", orderDetails=" + orderDetails +
                ", productImages=" + productImages +
                ", productPrices=" + productPrices +
                '}';
    }
}

package vn.edu.iuh.fit.models;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "product_price")
@NamedQueries({
        @NamedQuery(name = "ProductPrice.getAll", query = "select pr from ProductPrice pr"),
        @NamedQuery(name = "ProductPrice.findById", query = "select pr from ProductPrice pr where pr.product.id=:productId and pr.priceDateTime=:priceDateTime")
})
public class ProductPrice {
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;
    @Id
    @JoinColumn(name = "price_date_time")
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDateTime priceDateTime;
    @Column(name = "note", length = 255)
    private String note;
    @Column(name = "price")
    private double price;

    public ProductPrice(){

    }
    public ProductPrice(Product product, LocalDateTime priceDateTime, String note, double price) {
        this.product = product;
        this.priceDateTime = priceDateTime;
        this.note = note;
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDateTime getPriceDateTime() {
        return priceDateTime;
    }

    public void setPriceDateTime(LocalDateTime priceDateTime) {
        this.priceDateTime = priceDateTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "product=" + product +
                ", priceDateTime=" + priceDateTime +
                ", note='" + note + '\'' +
                ", price=" + price +
                '}';
    }
}

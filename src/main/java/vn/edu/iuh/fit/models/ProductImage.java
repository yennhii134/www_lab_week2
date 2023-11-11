package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

@Entity
@Table(name = "product_image")
public class ProductImage {
    @Id
    @Column(name = "image_id", length = 20, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "alternative", length = 250)
    private String alternative;
    @Column(name = "path", length = 250, nullable = false)
    private String path;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public ProductImage(){

    }
    public ProductImage(long id, String alternative, String path, Product product) {
        this.id = id;
        this.alternative = alternative;
        this.path = path;
        this.product = product;
    }

    public ProductImage(String alternative, String path, Product product) {
        this.alternative = alternative;
        this.path = path;
        this.product = product;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                "id=" + id +
                ", alternative='" + alternative + '\'' +
                ", path='" + path + '\'' +
                ", product=" + product +
                '}';
    }
}

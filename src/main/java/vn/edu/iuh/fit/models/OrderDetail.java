package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

@Entity
@Table(name = "order_detail")
@NamedQueries({
        @NamedQuery(name = "OrderDetail.getAll", query = "select od from OrderDetail od"),
        @NamedQuery(name = "OrderDetail.findById", query = "select od from OrderDetail od where od.product.id = :productId and od.order.id= :orderId")
})
public class OrderDetail {
    @Id
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private Order order;
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

    @Column(name = "note", length = 255)
    private String note;
    @Column(name = "price")
    private double price;
    @Column(name = "quantity")
    private double quantity;

    public OrderDetail(){

    }
    public OrderDetail(Order order, Product product, String note, double price, double quantity) {
        this.order = order;
        this.product = product;
        this.note = note;
        this.price = price;
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "order=" + order +
                ", product=" + product +
                ", note='" + note + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}

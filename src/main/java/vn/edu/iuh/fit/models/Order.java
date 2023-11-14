package vn.edu.iuh.fit.models;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @Column(name = "order_id", length = 20, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "order_date")
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDateTime orderDate;
    @ManyToOne
    @JoinColumn(name = "cust_id", nullable = false)
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "emp_id", nullable = false)
    private Employee employee;
    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

    public Order(){

    }
    public Order(long id, LocalDateTime orderDate, Customer customer, Employee employee, List<OrderDetail> orderDetails) {
        this.id = id;
        this.orderDate = orderDate;
        this.customer = customer;
        this.employee = employee;
        this.orderDetails = orderDetails;
    }

    public Order(LocalDateTime orderDate, Customer customer, Employee employee, List<OrderDetail> orderDetails) {
        this.orderDate = orderDate;
        this.customer = customer;
        this.employee = employee;
        this.orderDetails = orderDetails;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", customer=" + customer +
                ", employee=" + employee +
                ", orderDetails=" + orderDetails +
                '}';
    }
}

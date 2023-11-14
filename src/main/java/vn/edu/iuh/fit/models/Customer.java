package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name  ="customer")
@NamedQueries(
        @NamedQuery(name = "Customer.findAll", query = "select c from Customer c"))
public class Customer {
    @Id
    @Column(name = "cust_id", nullable = false, length = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "cust_name", length = 150, nullable = false)
    private String name;
    @Column(name = "address", length = 250, nullable = false)
    private String address;
    @Column(name = "email",length = 150, nullable = false)
    private String email;
    @Column(name = "phone",length = 15, nullable = false)
    private String phone;
    @OneToMany(mappedBy = "customer")
    private List<Order> order;

    public Customer(){

    }

    public Customer(long id, String name, String address, String email, String phone, List<Order> order) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.order = order;
    }

    public Customer(String name, String address, String email, String phone, List<Order> order) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.order = order;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", order=" + order +
                '}';
    }
}

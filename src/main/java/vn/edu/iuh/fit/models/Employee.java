package vn.edu.iuh.fit.models;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;
import vn.edu.iuh.fit.enums.EmployeeStatus;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "employee")
@NamedQueries(
        @NamedQuery(name = "Employee.findAll", query = "select e from Employee e"))
public class Employee {
    @Id
    @Column(name = "emp_id", nullable = false, length = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "full_name",length = 150,nullable = false)
    private String fullName;
    @Column(name = "dob",nullable = false)
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDateTime dob;
    @Column(name = "email",length = 150,nullable = false)
    private String email;
    @Column(name = "phone",length = 15 ,nullable = false)
    private String phone;
    @Column(name = "address",length = 250,nullable = false)
    private String address;
    @Column(name = "status", nullable = false)
    private EmployeeStatus employeeStatus;
    @OneToMany(mappedBy = "employee")
    private List<Order> order;

    public Employee(){

    }

    public Employee(long id, String fullName, LocalDateTime dob, String email, String phone, String address, EmployeeStatus employeeStatus, List<Order> order) {
        this.id = id;
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.employeeStatus = employeeStatus;
        this.order = order;
    }

    public Employee(String fullName, LocalDateTime dob, String email, String phone, String address, EmployeeStatus employeeStatus, List<Order> order) {
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.employeeStatus = employeeStatus;
        this.order = order;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EmployeeStatus getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(EmployeeStatus employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", employeeStatus=" + employeeStatus +
                '}';
    }
}

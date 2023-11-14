package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.models.Order;
import vn.edu.iuh.fit.repositories.OrderRepository;

import java.util.List;
import java.util.Optional;

public class OrderService {
    private OrderRepository orderRepository;
    public OrderService(){
        orderRepository = new OrderRepository();
    }
    public Optional<Order> findById(long id){
        return orderRepository.findById(id);
    }
    public List<Order> getAll(){
        return orderRepository.getAll();
    }
    public boolean add(Order order){
        return orderRepository.add(order);
    }
    public Optional<Boolean> update(Order order){
        Optional<Order> optional = findById(order.getId());

        if (optional.isEmpty())
            return Optional.empty();

        return Optional.of(orderRepository.update(order));
    }
    public boolean insert(Order order){
        return orderRepository.add(order);
    }
}

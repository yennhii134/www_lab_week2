package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.models.OrderDetail;
import vn.edu.iuh.fit.repositories.OrderDetailRepository;

import java.util.List;
import java.util.Optional;

public class OrderDetailService {
    private OrderDetailRepository orderDetailRepository;
    public OrderDetailService(){
        orderDetailRepository = new OrderDetailRepository();
    }
    public Optional<OrderDetail> findById(long orderId, long productId){
        return orderDetailRepository.findById(orderId,productId);
    }
    public List<OrderDetail> getAll(){
        return orderDetailRepository.getAll();
    }
    public boolean add(OrderDetail orderDetail){
        return orderDetailRepository.add(orderDetail);
    }
    public Optional<Boolean> update(OrderDetail orderDetail){
        Optional<OrderDetail> optional = findById(orderDetail.getOrder().getId(), orderDetail.getProduct().getId());

        if (optional.isEmpty())
            return Optional.empty();

        return Optional.of(orderDetailRepository.update(orderDetail));
    }
    public boolean insert(OrderDetail orderDetail){
        return orderDetailRepository.add(orderDetail);
    }
}

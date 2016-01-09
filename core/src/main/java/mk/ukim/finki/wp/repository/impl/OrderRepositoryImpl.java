package mk.ukim.finki.wp.repository.impl;

import mk.ukim.finki.wp.model.Order;
import mk.ukim.finki.wp.repository.BaseRepository;
import mk.ukim.finki.wp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by User on 12/3/2015.
 */
@Repository
public class OrderRepositoryImpl implements OrderRepository {
    @Autowired
    private BaseRepository baseRepository;

    public int delete(Order order) {
        if (order.getId() == null)
            return 0;
        return baseRepository.delete(Order.class, order.getId());
    }

    public List<Order> findAll() {
        return baseRepository.find(Order.class, null);
    }

    public Order findById(Long id) {
        return baseRepository.getById(Order.class, id);
    }

    public Order save(Order order) {
        return baseRepository.saveOrUpdate(order);
    }
}

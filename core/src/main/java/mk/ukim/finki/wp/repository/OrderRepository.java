package mk.ukim.finki.wp.repository;

import mk.ukim.finki.wp.model.Order;

import java.util.List;

/**
 * Created by User on 12/3/2015.
 */
public interface OrderRepository {
    Order findById(Long id);

    List<Order> findAll();

    Order save(Order order);

    int delete(Order order);
}

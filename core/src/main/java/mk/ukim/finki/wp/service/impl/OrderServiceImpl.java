package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.Order;
import mk.ukim.finki.wp.model.Pizza;
import mk.ukim.finki.wp.repository.OrderRepository;
import mk.ukim.finki.wp.repository.PizzaRepository;
import mk.ukim.finki.wp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * Created by User on 11/25/2015.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> listOrders() {
        return orderRepository.findAll();
    }

    public Order placeOrder(Pizza pizza, String clientName, String address) {
        Order order = new Order(pizza, clientName, address);
        return orderRepository.save(order);
    }
}

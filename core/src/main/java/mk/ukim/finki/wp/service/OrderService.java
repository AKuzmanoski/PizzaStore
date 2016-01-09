package mk.ukim.finki.wp.service;

import mk.ukim.finki.wp.model.Order;
import mk.ukim.finki.wp.model.Pizza;

import java.util.List;

/**
 * Created by User on 11/25/2015.
 */
public interface OrderService {
    Order placeOrder(Pizza pizza, String clientName, String address);

    List<Order> listOrders();
}

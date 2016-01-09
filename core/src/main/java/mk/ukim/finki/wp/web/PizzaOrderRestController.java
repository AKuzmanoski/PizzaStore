package mk.ukim.finki.wp.web;

import mk.ukim.finki.wp.model.Order;
import mk.ukim.finki.wp.model.Pizza;
import mk.ukim.finki.wp.service.OrderService;
import mk.ukim.finki.wp.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by User on 1/9/2016.
 */
@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class PizzaOrderRestController {
    @Autowired
    PizzaService pizzaService;
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public List<Pizza> newOrder() {
        return pizzaService.getPizzaTypes();
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public Order newOrder(@RequestBody Order order) {
        order = orderService.placeOrder(order.getPizza(), order.getClientName(), order.getClientAddress());
        return order;
    }
}

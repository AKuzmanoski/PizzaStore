package mk.ukim.finki.wp.web;

import mk.ukim.finki.wp.model.Order;
import mk.ukim.finki.wp.model.Pizza;
import mk.ukim.finki.wp.service.OrderService;
import mk.ukim.finki.wp.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Map;

/**
 * Created by User on 11/25/2015.
 */
@Controller
public class PizzaOrderController {
    @Autowired
    PizzaService pizzaService;
    @Autowired
    OrderService orderService;

    public PizzaOrderController() {

    }

    public PizzaOrderController(PizzaService pizzaService, OrderService orderService) {
        this.pizzaService = pizzaService;
        this.orderService = orderService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(Map<String, Object> model) {
        model.put("pizzas", pizzaService.getPizzaTypes());
        return "index";
    }

    @RequestMapping(value = "/PizzaOrder.do", method = RequestMethod.POST)
    public String showClientInfo(@RequestParam
                                 Long pizzaId, HttpSession session) {
        Pizza pizza = pizzaService.getPizzaById(pizzaId);
        session.setAttribute("pizza", pizza);
        return "deliveryInfo";
    }

    @RequestMapping(value = "AddressInfo.do", method = RequestMethod.POST)
    public String placeOrder(@RequestParam String clientName, @RequestParam String clientAddress, HttpSession session) {
        Pizza pizza = (Pizza) session.getAttribute("pizza");
        Order order = orderService.placeOrder(pizza, clientName, clientAddress);
        session.setAttribute("order", order);
        return "Confirmation";
    }

    @RequestMapping(value = "/pizzas", method = RequestMethod.GET)
    public String getPizzas(Model model) {
        model.addAttribute("pizzas", pizzaService.getPizzaTypes());
        model.addAttribute("newPizza", new Pizza());
        return "pizzas";
    }

    @RequestMapping(value = "/pizzas", method = RequestMethod.POST)
    public String addPizzas(@Valid Pizza newPizza, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/pizzas";
        }
        pizzaService.create(newPizza);
        return "redirect:/pizzas";
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String getOrders(Model model) {
        model.addAttribute("listOrders", orderService.listOrders());
        return "orders";
    }
}

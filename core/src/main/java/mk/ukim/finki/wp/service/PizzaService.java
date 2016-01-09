package mk.ukim.finki.wp.service;

import mk.ukim.finki.wp.model.Pizza;

import java.util.List;

/**
 * Created by User on 11/25/2015.
 */
public interface PizzaService {
    List<Pizza> getPizzaTypes();

    void create(Pizza pizza);

    Pizza getPizzaById(Long id);
}

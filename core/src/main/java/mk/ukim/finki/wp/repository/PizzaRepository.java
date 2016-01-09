package mk.ukim.finki.wp.repository;

import mk.ukim.finki.wp.model.Pizza;

import java.util.List;

/**
 * Created by User on 12/3/2015.
 */
public interface PizzaRepository {
    Pizza findById(Long id);

    List<Pizza> findAll();

    Pizza save(Pizza pizza);

    int delete(Pizza pizza);
}

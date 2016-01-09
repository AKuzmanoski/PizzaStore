package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.Pizza;
import mk.ukim.finki.wp.repository.PizzaRepository;
import mk.ukim.finki.wp.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 11/25/2015.
 */
@Service
public class PizzaServiceImpl implements PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;

    public void create(Pizza pizza) {
        pizzaRepository.save(pizza);
    }

    public List<Pizza> getPizzaTypes() {
        return pizzaRepository.findAll();
    }

    public Pizza getPizzaById(Long id) {
        return pizzaRepository.findById(id);
    }
}

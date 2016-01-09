package mk.ukim.finki.wp.repository.impl;

import mk.ukim.finki.wp.model.Pizza;
import mk.ukim.finki.wp.repository.BaseRepository;
import mk.ukim.finki.wp.repository.PizzaRepository;
import mk.ukim.finki.wp.repository.helper.PizzaByTypePredicateBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 12/3/2015.
 */
@Repository
public class PizzaRepositoryImpl implements PizzaRepository {
    @Autowired
    private BaseRepository baseRepository;

    public int delete(Pizza pizza) {
        if (pizza.getId() == null)
            return 0;
        return baseRepository.delete(Pizza.class, pizza.getId());
    }

    public List<Pizza> findAll() {
        return baseRepository.find(Pizza.class, null);
    }

    public Pizza findById(Long id) {
        return baseRepository.getById(Pizza.class, id);
    }

    @Transactional
    public Pizza save(Pizza pizza) {
        Pizza oldPizza;
        if(pizza.getId() == null) {
            oldPizza = findByType(pizza.getType());
            if (oldPizza != null)
                return oldPizza;
        }
        return baseRepository.saveOrUpdate(pizza);
    }

    private Pizza findByType(String type) {
        List<Pizza> pizzas =  baseRepository.find(Pizza.class, new PizzaByTypePredicateBuilder<Pizza>(type));
        if (pizzas.size() > 0)
            return pizzas.get(0);
        else return null;
    }
}

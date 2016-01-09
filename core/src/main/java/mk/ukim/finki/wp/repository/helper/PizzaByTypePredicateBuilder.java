package mk.ukim.finki.wp.repository.helper;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by User on 12/3/2015.
 */
public class PizzaByTypePredicateBuilder<T> implements PredicateBuilder<T> {
    private String type;

    public PizzaByTypePredicateBuilder(String type) {
        this.type = type;
    }

    public Predicate toPredicate(CriteriaBuilder cb, CriteriaQuery<T> cq, Root<T> root) {
        return cb.equal(root.get("type"), type);
    }
}

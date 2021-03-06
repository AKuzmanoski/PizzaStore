package mk.ukim.finki.wp.repository;

/**
 * Created by User on 12/3/2015.
 */

import mk.ukim.finki.wp.model.BaseEntity;
import mk.ukim.finki.wp.repository.helper.PredicateBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by ristes on 11/16/15.
 */
@Repository
public class BaseRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public <T extends BaseEntity> T getById(Class<T> type, Long id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(type);
        final Root<T> root = criteriaQuery.from(type);

        Predicate byId = criteriaBuilder.equal(root.get("id"), id);
        criteriaQuery.where(byId);

        TypedQuery<T> query = entityManager.createQuery(criteriaQuery);

        return query.getSingleResult();
    }

    public <T> List<T> find(Class<T> type, PredicateBuilder<T> predicateBuilder) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(type);
        final Root<T> root = criteriaQuery.from(type);

        // add here security predicate (add it to the WHERE clause).

        if (predicateBuilder != null)
            criteriaQuery.where(predicateBuilder.toPredicate(criteriaBuilder, criteriaQuery, root));

        TypedQuery<T> query = entityManager.createQuery(criteriaQuery);

        return query.getResultList();
    }

    private <T> Predicate getSecurityPredicate(Class<T> type) {
        return null;
    }

    @Transactional
    public <T extends BaseEntity> T saveOrUpdate(T entity) {
        if (entity.getId() != null && !entityManager.contains(entity)) {
            entity = entityManager.merge(entity);
        } else {
            entityManager.persist(entity);
        }

        entityManager.flush();
        return entity;
    }

    @Transactional
    public <T> int delete(Class<T> type, Long id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaDelete<T> criteriaDelete = criteriaBuilder.createCriteriaDelete(type);
        final Root<T> root = criteriaDelete.from(type);

        Predicate byId = criteriaBuilder.equal(root.get("id"), id);
        criteriaDelete.where(byId);

        Query query = entityManager.createQuery(criteriaDelete);
        int changes = query.executeUpdate();
        entityManager.flush();

        return changes;
    }
}
package com.test.web.dao;

import com.test.web.model.Product;
import com.test.web.model.Provider;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by anasrekik on 12/06/15.
 */
@Repository
public class ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Product find(Long id) {
        return entityManager.find(Product.class, id);
    }

    public void delete(Long id) {
        Object persistentInstance = entityManager.find(Product.class, id);
        if (persistentInstance != null) {
            entityManager.remove(persistentInstance);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Product> getProducts() {
        return entityManager.createQuery("select p from Product p").getResultList();
    }

    public List<Long> getProductsByProviderId(Long providerId) {
        return entityManager.createQuery("select p.id from Product p where p.provider.id = :provider_id").setParameter("provider_id", providerId).getResultList();
    }

    public Product save(Product product) {
        if (product.getId() == null) {
            entityManager.persist(product);
            return product;
        } else {
            return entityManager.merge(product);
        }
    }

}

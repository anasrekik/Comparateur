package com.test.web.dao;

import com.test.web.model.Provider;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by anasrekik on 20/06/15.
 */
@Repository
public class ProviderDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Provider find(Long id) {
        return entityManager.find(Provider.class, id);
    }

    public void delete(Long id) {
        Object persistentInstance = entityManager.find(Provider.class, id);
        if (persistentInstance != null) {
            entityManager.remove(persistentInstance);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Provider> getProviders() {
        return entityManager.createQuery("select p from Provider p").getResultList();
    }

    public Provider save(Provider provider) {
        if (provider.getId() == null) {
            entityManager.persist(provider);
            return provider;
        } else {
            return entityManager.merge(provider);
        }
    }

}

package com.test.web.service;

import com.test.web.dao.ProductDao;
import com.test.web.dao.ProviderDao;
import com.test.web.model.Product;
import com.test.web.model.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by anasrekik on 28/06/15.
 */
@Service
public class ProviderService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProviderDao providerDao;

    public Provider find(Long id) {
        return providerDao.find(id);
    }

    public List<Provider> getProviders() {
        return providerDao.getProviders();
    }

    @Transactional
    public Provider save(Provider provider) {
        return providerDao.save(provider);
    }

    @Transactional
    public void delete(Long id){
        List<Long> products = productDao.getProductsByProviderId(id);
        System.out.println(products);
        for (Long productId:products){
            productDao.delete(productId);
        }
        providerDao.delete(id);
    }
}

package com.test.web.service;

import com.test.web.dao.ProductDao;
import com.test.web.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by anasrekik on 28/06/15.
 */
@Service
public class ProductService {

    @Autowired
    ProductDao productDao;

    public Product find(Long id) {
        return productDao.find(id);
    }

    public List<Product> getProducts() {
        return productDao.getProducts();
    }

    @Transactional
    public Product save(Product product) {
        return productDao.save(product);
    }

    @Transactional
    public void delete(Long id){
        productDao.delete(id);
    }

}

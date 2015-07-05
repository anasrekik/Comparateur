package com.test.web.controller;

import com.test.web.dao.ProductDao;
import com.test.web.model.Product;
import com.test.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by anasrekik on 12/06/15.
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value="/{productId}", method= RequestMethod.GET)
    public @ResponseBody Product getProductInJson(@PathVariable Long productId) {
        return productService.find(productId);
    }

    @RequestMapping(value="/", method= RequestMethod.GET)
    public @ResponseBody List<Product> getAllProductsInJson() {
        return productService.getProducts();
    }

    @RequestMapping(value="/", method=RequestMethod.POST)
    public @ResponseBody Product saveProduct(@RequestBody final Product product) {
        return productService.save(product);
    }

    @RequestMapping(value="/{productId}", method= RequestMethod.DELETE)
    public @ResponseBody
    Boolean deleteProduct(@PathVariable Long productId) {
        productService.delete(productId);
        return true;
    }

}

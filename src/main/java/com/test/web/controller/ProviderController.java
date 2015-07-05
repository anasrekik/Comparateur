package com.test.web.controller;

import com.test.web.dao.ProviderDao;
import com.test.web.model.Product;
import com.test.web.model.Provider;
import com.test.web.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by anasrekik on 20/06/15.
 */
@Controller
@RequestMapping("/provider")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @RequestMapping(value="/{providerId}", method= RequestMethod.GET)
    public @ResponseBody
    Provider getProvider(@PathVariable Long providerId) {
        return providerService.find(providerId);
    }

    @RequestMapping(value="/", method= RequestMethod.GET)
    public @ResponseBody
    List<Provider> getAllProviders() {
        return providerService.getProviders();
    }

    @RequestMapping(value="/", method=RequestMethod.POST)
    public @ResponseBody Provider saveProduct(@RequestBody final Provider provider) {
        return providerService.save(provider);
    }

    @RequestMapping(value="/{providerId}", method= RequestMethod.DELETE)
    public @ResponseBody
    Boolean deleteProvider(@PathVariable Long providerId) {
        providerService.delete(providerId);
        return true;
    }

}

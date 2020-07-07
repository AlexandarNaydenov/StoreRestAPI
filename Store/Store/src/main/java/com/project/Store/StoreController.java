package com.project.Store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class StoreController {

    @Autowired
    private Store store;


    @RequestMapping(method = RequestMethod.POST, value = "/store")
    public String findBill(@RequestBody ArrayList<String> array)
    {
        int bill = store.findTheBill(array);
        int aws = bill/100;
        int clouds = bill - aws*100;
        return aws + " aws " +  clouds + " clouds";
    }


    @RequestMapping(method = RequestMethod.POST, value = "/addProduct")
    public void insertProducts(@RequestBody Product p)
    {
        store.addNewProduct(p);
    }


    @RequestMapping("/addBasicProducts")
    public void addBasicProducts()
    {
        store.addNewProduct(new Product(50,"apple"));
        store.addNewProduct(new Product(40,"banana"));
        store.addNewProduct(new Product(30,"tomato"));
        store.addNewProduct(new Product(26,"potato"));
    }

    @RequestMapping("/addTwoForThree")
    public void addTwoForThree()
    {
        store.addNewPromotion(new TwoForThree());
    }

    @RequestMapping("/addGetOneSecondHalfPrice")
    public void addGetOneSecondHalfPrice()
    {
        store.addNewPromotion(new GetOneSecondHalfPrice());
    }

    @RequestMapping("/printAllProducts")
    public ArrayList<Product> printProducts()
    {
        return store.returnAllProducts();
    }

}
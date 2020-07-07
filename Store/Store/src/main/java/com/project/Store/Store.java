package com.project.Store;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class Store {
    private HashMap<String, Product> products = new HashMap<String, Product>();
    private ArrayList<Deal> deals = new ArrayList<Deal>();

    public void addNewProduct(Product newProduct) {
        products.put(newProduct.getName(), newProduct);
    }

    public void addNewPromotion(Deal newDeal) {
        deals.add(newDeal);
    }

    public ArrayList<Product> returnAllProducts()
    {
        ArrayList<Product> p = new ArrayList<Product>();
        for (String i : products.keySet()) {
            p.add(products.get(i));
        }
        return p;
    }

    private ArrayList<Product> returnAllProductsFromShoppingList(ArrayList<String> shoppingList)
    {
        ArrayList<Product> p = new ArrayList<Product>();
        for(int i = 0;i<shoppingList.size();i++)
        {
            p.add(products.get(shoppingList.get(i)));
        }
        return p;
    }


    public int findTheBill(ArrayList<String> array) {
        int wholeBill = 0;
        for(int i=0;i<array.size();i++)
        {
            wholeBill += products.get(array.get(i)).getPrice();
        }
        for(int i=0;i<deals.size();i++)
        {
            wholeBill = deals.get(i).apply(wholeBill,returnAllProductsFromShoppingList(array));
        }
        return wholeBill;
    }

}


package com.project.Store;

import java.util.ArrayList;

public class TwoForThree extends Deal{

    private int findCheapest (Product p1, Product p2, Product p3)
    {
        return Math.min(Math.min(p1.getPrice(), p2.getPrice()), p3.getPrice());
    }

    @Override
    public int apply(int currentPrice,ArrayList<Product> products)
    {
        if(products.size() >= 3)
       return currentPrice - findCheapest(products.get(0),products.get(1),products.get(2));
        else return currentPrice;
    }

}

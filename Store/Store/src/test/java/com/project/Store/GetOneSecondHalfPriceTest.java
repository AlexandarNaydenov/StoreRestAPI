package com.project.Store;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GetOneSecondHalfPriceTest {

    @Test
    void apply() {
        Store s = new Store();
        s.addNewProduct(new Product(20,"a"));
        s.addNewProduct(new Product(10,"b"));
        ArrayList<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("b");
        s.findTheBill(list);
        s.addNewPromotion(new GetOneSecondHalfPrice());
        assertEquals(75, s.findTheBill(list));
    }
}
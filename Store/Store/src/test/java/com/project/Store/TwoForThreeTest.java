package com.project.Store;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TwoForThreeTest {

    @Test
    void apply() {
        Store s = new Store();
        s.addNewProduct(new Product(20,"a"));
        s.addNewProduct(new Product(10,"b"));
        s.addNewProduct(new Product(30,"c"));
        s.addNewPromotion(new TwoForThree());
        ArrayList<String> list = new ArrayList<String>();
        list.add("a");
        list.add("a");
        list.add("c");
        list.add("b");
        assertEquals(60, s.findTheBill(list));
    }
}
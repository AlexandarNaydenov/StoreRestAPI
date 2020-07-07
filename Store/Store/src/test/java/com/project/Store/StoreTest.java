package com.project.Store;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StoreTest {

    @Test
    void findTheBill() {
        Store s = new Store();
        s.addNewProduct(new Product(20, "banana"));
        s.addNewProduct(new Product(50, "strawberry"));
        s.addNewProduct(new Product(70, "orange"));
        s.addNewProduct(new Product(10, "carrot"));
        ArrayList<String> list = new ArrayList<String>();
        s.addNewPromotion(new TwoForThree());
        s.addNewPromotion(new GetOneSecondHalfPrice());
        list.add("banana");
        list.add("strawberry");
        list.add("orange");
        list.add("banana");
        list.add("banana");
        list.add("orange");
        list.add("banana");
        list.add("orange");
        assertEquals(275, s.findTheBill(list));
    }

    @Test
    void addNewProduct() {
        Store s = new Store();
        s.addNewProduct(new Product(20, "test"));
        ArrayList<Product> list = s.returnAllProducts();
        assertEquals("test", list.get(0).getName());
    }



}
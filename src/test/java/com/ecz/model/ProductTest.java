package com.ecz.model;

import com.ecz.exception.InvalidQuantityException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    private Product product;
    @BeforeEach
    void setUp(){
        product=new Product(1,"laptop",643754.8798,5,true);
    }
    @Test
    void testProductCreation(){
        assertNotNull(product);
    }
    @Test
    void testProductId(){
        assertEquals(1,product.getProductId());
    }
    @Test
    void testProductName(){
        assertEquals("laptop",product.getProductName());
    }
    @Test
    void testProductPrice(){
        assertEquals(643754.8798,product.getPrice());
    }
    @Test
    void testProductQuantity(){
        assertEquals(5,product.getQuantity());
    }
    @Test
    void testProductIsAvailable(){
        assertTrue(product.getIsAvailable());
    }
    @Test
     void testQuantityLessThanZero(){
        assertThrows(InvalidQuantityException.class,()->new Product(2,"laptop",643754.8798,-1,true));
    }
}

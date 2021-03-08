package se.lexicon.jpa_workshop.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ProductOrderTest {

    ProductOrder testObject;

    @BeforeEach
    public void setup(){
        AppUser customer1 = new AppUser("Test","Test","Test");
        testObject = new ProductOrder(1,LocalDate.parse("2000-01-01"), LocalTime.parse("09:30"),customer1);
    }

    @Test
    @DisplayName("Test1 Created Object")
    public void test_successfully_created() {
        Assertions.assertEquals(1, testObject.getId());
        Assertions.assertEquals("Test", testObject.getCustomer().getFirstName());
        //...
    }

    // equal
    // hashCode

    @Test
    @DisplayName("Test2 Add OrderItem")
    public void test_Add_OrderItem(){
        Product product= new Product(1,"Test",100);
        OrderItem orderItem1= new OrderItem(30,30,product,testObject);
        List<OrderItem> orderItems= new ArrayList<>();
        orderItems.add(orderItem1);

        testObject.setOrderItems(orderItems);

        Assertions.assertTrue(testObject.getOrderItems().contains(orderItem1));

    }

    @Test
    @DisplayName("Test2 Remove OrderItem")
    public void test_Remove_OrderItem(){
        Product product= new Product(1,"Test",100);
        OrderItem orderItem1= new OrderItem(30,30,product,testObject);
        List<OrderItem> orderItems= new ArrayList<>();
        orderItems.add(orderItem1);

        testObject.setOrderItems(orderItems);

        testObject.removeOrderItem(orderItem1);
        Assertions.assertFalse(testObject.getOrderItems().contains(orderItem1));

    }
}

package com.amazon.ata.deliveringonourpromise.types;

import com.amazon.ata.deliveringonourpromise.data.OrderShipmentData;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class OrderTest {
 //Write a unit test that fails if the Order class has any externally modifiable variables.

 @Test
 public void getCustomerOrderItemList_internalStateIsProtectedByDefensiveCopying() {
  List<OrderItem> itemList = new ArrayList<>();
  Order order = Order.builder()
          .withCustomerOrderItemList(itemList)
          .build();
  List<OrderItem> secondList = new ArrayList<>();
  String orderItemId = order.getOrderId();
  OrderItem onlyitem = OrderItem.builder()
          .withCustomerOrderItemId(orderItemId)
          .build();
  secondList.add(onlyitem);
  boolean lists = secondList.equals(order.getCustomerOrderItemList());
  Assert.assertFalse(lists);
 }
 @Test
 public void withCustomerOrderItemList_internalStateIsProtectedByDefensiveCopying(){

 }


}




// public void allIds() {
//  String customerId = "2345";
//  Order order = Order.builder()
//          .withCustomerId(customerId)
//          .build();
//  order.customerId = "9876";
//  Assert.assertEquals(customerId, order.getCustomerId(), "Wrong, failed.");
//




  //Test
//    public void getCustomerId_changeCustomerId_returnNewCustomerId() {
//     String orderId = "1234";
//      Order order = Order.builder()
//              .withOrderId(orderId)
//              .build();
//      order.orderId = "1235";
//      Assert.assertEquals(orderId, order.getOrderId(), "Expected new Id to equal Original Id");










package com.itea.homeworks.hw3;

import com.itea.homeworks.hw3.models.Order;
import com.itea.homeworks.hw3.requests.OrderRequests;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class OrderRequestsTest {
    private Logger log;
    private OrderRequests orderRequests;

    @Before
    public void SetUp() {
        log = Logger.getLogger(OrderRequests.class);
        orderRequests = new OrderRequests();
    }

    @Test
    public void shouldPostCorrectly() {
        Order order = new Order(500, 1, 50, "new");
        try {
            assertEquals(404, orderRequests.getOrder(500));
            assertEquals(200, orderRequests.postOrder(order));
            assertEquals(200, orderRequests.getOrder(500));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void shouldPutCorrectly() {
        Order order1 = new Order(501, 2, 51, "new");
        Order order2 = new Order(502, 3, 52, "new");

        try {
            orderRequests.postOrder(order1);
            assertEquals(200, orderRequests.putOrder(order2));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void shouldDeleteCorrectly() {
        Order order = new Order(600, 4, 60, "new");
        try {
            orderRequests.postOrder(order);
            assertEquals(200, orderRequests.deleteOrder(1000));
            assertEquals(404, orderRequests.getOrder(1000));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}

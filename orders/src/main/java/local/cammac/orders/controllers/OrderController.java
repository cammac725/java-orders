package local.cammac.orders.controllers;

import local.cammac.orders.models.Order;
import local.cammac.orders.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderServices orderServices;

    // http://localhost:2021/orders/order/{id}
    @GetMapping(value = "/order/{orderId}", produces = "application/json")
    public ResponseEntity<?> findOrderById(@PathVariable long orderId) {
        Order order = orderServices.findOrderById(orderId);
        return new ResponseEntity<Object>(order, HttpStatus.OK);
    }

    // http://localhost:2021/orders/advanceamount

}

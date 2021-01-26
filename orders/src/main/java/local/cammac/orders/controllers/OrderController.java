package local.cammac.orders.controllers;

import local.cammac.orders.models.Order;
import local.cammac.orders.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // DELETE operations (DELETE)
    @DeleteMapping(value = "/orders/order/{ordname}")
    public ResponseEntity<?> deleteOrderByName(@PathVariable String ordname) {
        orderServices.delete(ordname);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

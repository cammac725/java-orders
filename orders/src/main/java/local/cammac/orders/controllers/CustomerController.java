package local.cammac.orders.controllers;

import local.cammac.orders.models.Customer;
import local.cammac.orders.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerServices customerServices;

    // http://localhost:2021/customers/orders
    @GetMapping(value = "/orders", produces = "application/json")
    public ResponseEntity<?> listAllCustomers() {
        List<Customer> list = customerServices.findAllCustomers();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // http://localhost:2021/customers/customer/{id}
    @GetMapping(value = "/customer/{customerId}", produces = "application/json")
    public ResponseEntity<?> findCustomerById(@PathVariable long customerId) {
        Customer c = customerServices.findCustomerById(customerId);
        return new ResponseEntity<Object>(c, HttpStatus.OK);
    }

    // http://localhost:2021/customers/namelike/{str}
    @GetMapping(value = "/namelike/{str}")
    public ResponseEntity<?> findCustomerByNameLike(@PathVariable String str) {
        List<Customer> list = customerServices.findByNameLike(str);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // http://localhost:2021/customers/orders/count




}

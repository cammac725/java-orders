package local.cammac.orders.controllers;

import local.cammac.orders.models.Customer;
import local.cammac.orders.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerServices customerServices;

    // READ operations (GET)

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

    // DELETE operation (DELETE)
    // http://localhost:2021/customers/customer/{id}
    @DeleteMapping(value = "/customer/{custcode}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable long custcode) {
        customerServices.delete(custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // CREATE operations (POST)
    // http://localhost:2021/customers/customer
    // Data => request body
    // Jackson -> creates the object using the default constructor
    //         -> fills in the data using our setters
    @PostMapping(value = "/customer", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addNewCustomer(@Valid @RequestBody Customer newCustomer) {
        newCustomer.setCustcode(0);
        newCustomer = customerServices.save(newCustomer);

        // Response Headers => Location Header = url to the new customer
        // GET http://localhost:2021/customers/customer/{newId}
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCustomerURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{custcode}")
                .buildAndExpand(newCustomer.getCustcode())
                .toUri();
        responseHeaders.setLocation(newCustomerURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    // UPDATE operations

    // PUT
    // http://localhost:2021/customers/customer/{custcode}
    // Data => request body
    @PutMapping(value = "/customer/{custcode}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateFullCustomer(@PathVariable long custcode,
                                                @Valid @RequestBody Customer updateCustomer) {
        updateCustomer.setCustcode(custcode);
        updateCustomer = customerServices.save(updateCustomer);
        return new ResponseEntity<>(updateCustomer, HttpStatus.OK);
    }

    // PATCH
    // http://localhost:2021/customers/customer/{custcode}
    @PatchMapping(value = "customer/{custcode}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updatePartCustomer(@PathVariable long custcode, @RequestBody Customer updateCustomer) {
        updateCustomer = customerServices.update(updateCustomer, custcode);
        return new ResponseEntity<>(updateCustomer, HttpStatus.OK);
    }
}

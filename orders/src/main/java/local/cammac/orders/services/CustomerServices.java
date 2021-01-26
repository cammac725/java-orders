package local.cammac.orders.services;

import local.cammac.orders.models.Customer;

import java.util.List;

public interface CustomerServices {
    Customer save(Customer customer);

    Customer findCustomerById(long id);

    List<Customer> findByNameLike(String str);

    List<Customer> findAllCustomers();

    void deleteAllCustomers();

    void delete(long custcode);

    Customer update(Customer updateCustomer, long custcode);
}

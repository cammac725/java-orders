package local.cammac.orders.services;

import local.cammac.orders.models.Customer;
import local.cammac.orders.repositories.CustomersRepository;
import local.cammac.orders.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customerServices")
public class CustomerServicesImpl implements CustomerServices {

    @Autowired
    CustomersRepository custrepos;

    @Autowired
    OrdersRepository ordersrepos;

    @Override
    public List<Customer> findAllCustomers() {
        List<Customer> list = new ArrayList<>();
        custrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Customer findCustomerById(long id) {
        return custrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer " + id + " not found."));
    }

    @Override
    public List<Customer> findByNameLike(String str) {
        List<Customer> list = custrepos.findByCustnameContainingIgnoringCase(str);
        return list;
    }

    @Transactional
    @Override
    public Customer save(Customer customer) {
        return custrepos.save(customer);
    }
}

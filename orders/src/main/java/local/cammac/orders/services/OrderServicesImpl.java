package local.cammac.orders.services;

import local.cammac.orders.models.Order;
import local.cammac.orders.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Transactional
@Service(value = "orderServices")
public class OrderServicesImpl implements OrderServices {

    @Autowired
    OrdersRepository ordersrepos;

    @Override
    public Order findOrderById(long id) {
        return ordersrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order " + id + " not found."));
    }

    @Transactional
    @Override
    public Order save(Order order) {
        return ordersrepos.save(order);
    }

    @Transactional
    @Override
    public void deleteAllOrders() {
        ordersrepos.deleteAll();
    }

    @Transactional
    @Override
    public void delete(String ordname) {

    }
}

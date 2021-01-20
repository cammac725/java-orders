package local.cammac.orders.services;

import local.cammac.orders.models.Order;
import local.cammac.orders.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "orderServices")
public class OrderServicesImpl implements OrderServices {

    @Autowired
    OrdersRepository ordersrepos;

    @Override
    public Order save(Order order) {
        return ordersrepos.save(order);
    }
}
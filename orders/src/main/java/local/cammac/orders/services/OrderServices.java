package local.cammac.orders.services;

import local.cammac.orders.models.Order;

public interface OrderServices {

    Order save(Order order);

    Order findOrderById(long id);

    void deleteAllOrders();

    void delete(String ordname);
}

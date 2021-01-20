package local.cammac.orders.services;

import local.cammac.orders.models.Payment;
import local.cammac.orders.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "paymentServices")
public class PaymentServicesImpl implements PaymentServices {

    @Autowired
    PaymentRepository paymentrepos;

    @Override
    public Payment save(Payment payment) {
        return paymentrepos.save(payment);
    }
}

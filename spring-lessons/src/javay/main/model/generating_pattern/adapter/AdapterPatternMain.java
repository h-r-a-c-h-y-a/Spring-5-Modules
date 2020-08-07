package javay.main.model.generating_pattern.adapter;

import javay.main.model.generating_pattern.adapter.impl.PaymentGatewayImpl;
import javay.main.model.generating_pattern.adapter.impl.AdvancedPaymentGatewayAdapter;

public class AdapterPatternMain {
    public static void main(String[] args) {
        PaymentGateway paymentGateway = new PaymentGatewayImpl();
        AdvancedPayGateway advancedPayGateway = new AdvancedPaymentGatewayAdapter(paymentGateway);
        String mob1 = null;
        String mob2 = null;
        advancedPayGateway.makePayment(mob1, mob2);
    }
}

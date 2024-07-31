package AdapterPattern;

//AdapterPatternExample.java
public class AdapterPatternExample {
 public static void main(String[] args) {
     PaymentProcessor payPalProcessor = new PayPalAdapter();
     PaymentProcessor stripeProcessor = new StripeAdapter();

     payPalProcessor.processPayment(100.0);
     stripeProcessor.processPayment(200.0);
 }
}

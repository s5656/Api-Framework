package shoppingCart;

public class EPayment {
    public double payment(double amount) {
        if (amount >= 100) {
            return (amount * 0.05) + amount;
        } else {
            return amount;
        }
    }

}

package shoppingCart;

import java.util.ArrayList;
import java.util.HashMap;

public class Buy {
    public static void main(String[] args) {//main method
        ArrayList<Product> cart = new ArrayList();

        Product apple=new Product("Apple",200);
        Product milk=new Product("Milk",34);
        Product newsPaper=new Product("NewsPaper",10);



        EPayment ePayment=new EPayment();
        Bill bill=new Bill();
        System.out.println("You have to pay "+ePayment.payment(bill.billGenration(cart)));

        System.out.println("Your products are "+cart);

    }
}

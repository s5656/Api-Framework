package shoppingCart;

import java.util.ArrayList;

public class Bill {
    public double billGenration(ArrayList<Product> bill){
        Offer offer =new Offer();
        offer.getOffer(bill);

        double rupees =0;
        for (Product amount:bill){
            rupees+=amount.getPrice();
        }
        return rupees;
    }
}

package shoppingCart;

import java.util.ArrayList;

public class Offer {


    public void getOffer(ArrayList<Product> offer){
        int count=0;
        for (Product milk:offer){
            if (milk.getName().equalsIgnoreCase("milk")) {
                count++;//count
            }
        }
        if (count>=2) {
            System.out.println("You got one Liter milk free");
            offer.add(new Product("Milk", 34));
        }
    }
}

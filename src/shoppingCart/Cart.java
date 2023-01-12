package shoppingCart;

import java.util.HashMap;

public class Cart {
    HashMap<Product,Double> cartData =new HashMap<>();

    public void addToCart(Product product, double noOfItem){
        cartData.put(product,noOfItem);
    }

}

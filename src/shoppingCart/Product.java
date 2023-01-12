package shoppingCart;

public class Product {

    private String name;
    private int price;

    @Override
    public String toString() {
        return
                "name" + name;
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }

}

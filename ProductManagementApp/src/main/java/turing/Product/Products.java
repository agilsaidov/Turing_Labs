package turing.Product;

public class Products {
    public String name;
    public double price;
    public String category;
    public int stock;
    public Products(String name, double price, String category, int stock) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Products{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", stock=" + stock +
                '}';
    }
    public double discount(double percentage) {
        price = price-(price * percentage/100);
        return price;
    }

    public boolean isInStock(String name) {
        if (stock > 0) {
            return true;
        }
        return false;
    }
}

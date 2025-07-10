package turing.Store;

import turing.Product.Products;

public class Store {
    public String StoreName;
    public String StoreAddress;


   public Products[] products;

    public Store(String storeName, String storeAddress, Products[] products) {
        this.StoreName = storeName;
        this.StoreAddress = storeAddress;
        this.products = products;

    }
    public void printAllProducts() {
        for (Products p : products) {
            System.out.println(p.toString());
        }
    }

    public void printExpensiveProducts(double limit){
        for (Products p : products) {
            if(p.price > limit){
                System.out.println(p.toString());
            }
        }
    }
    public void applyDiscountToAll(double percentage) {
        for(int i =0; i<products.length; i++){
            System.out.printf("Price of %s: %2.2f",products[i].name,products[i].discount(percentage));
            System.out.println();
        }
    }
}

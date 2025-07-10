package turing;

import turing.Product.Products;
import turing.Store.Store;

public class Main {
    public static void main(String[] args) {
        Products qulaqliq = new Products("Redmi",200.50,"Electronics",250);
        Products komputer = new Products("Asus",1500,"Electronics",500);
        Products kitab = new Products("Suc ve Ceza",50,"Literature",2000);
        Products masa = new Products("Masa",250,"Furniture",500);
        Products insan = new Products("Insan",3500,"Humanity",800);

        Products[] products = {qulaqliq, komputer, kitab, masa,insan};


        Store store = new Store("Bazar","Baki",products);

        store.printAllProducts();
        System.out.println("----------------------------------------------------\n");
        store.printExpensiveProducts(200);
        System.out.println("----------------------------------------------------\n");
        store.applyDiscountToAll(10);
        System.out.println("----------------------------------------------------\n");
        store.printAllProducts();
    }
}
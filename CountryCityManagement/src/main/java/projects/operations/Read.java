package projects.operations;

import projects.arrays.GlobalArrays;

public class Read {
    GlobalArrays globalArrays = new GlobalArrays();

    public void show(){
        System.out.println("=============Countries=============");
        globalArrays.showCountries();
        System.out.println("====================================");
        System.out.println("\n=============Cities=============");
        globalArrays.showCities();
        System.out.println("====================================\n");

    }
}

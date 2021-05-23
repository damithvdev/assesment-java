package com.damithdev.service;

import com.damithdev.Prod;
import com.damithdev.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    public List<Product> productsList () {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "asd", 23, "carton"));
        return products;
    }

    public double calTotal(List<Prod> list) {

        System.out.println(list);

        List<Prod> penguineList = list.stream()
                .filter(prod -> prod.getName().equalsIgnoreCase("Penguine-ears"))
                .collect(Collectors.toList());

        List<Prod> horseShoe = list.stream()
                .filter(prod -> prod.getName().equalsIgnoreCase("Horseshoe"))
                .collect(Collectors.toList());

        return calculateForEachType(penguineList) + calculateForEachType(horseShoe);


    }

    private double calculateForEachType(List<Prod> penguineList) {

        double total = 0.0;

        for (Prod item: penguineList) {
            if (item.getType().equals("carton")){
                total = total + cartonCost(item.getQuantity(), item.getName());
            } else if (item.getType().equals("units")) {
                total = total + unitCost(item.getQuantity(), item.getName());
            }
        }


        return total;
    }

    private double cartonCost(int quantity, String type) {

        if ("Penguine-ears".equalsIgnoreCase(type)) {
            double total = 175 * quantity;
            return discount(quantity , total);
        } else {
            double total = 825 * quantity;
            return discount(quantity , total);
        }

    }

    private double unitCost(int quantity, String type) {

        if ("Penguine-ears".equalsIgnoreCase(type)) {
            return  8.75 * 1.3 * quantity;
        } else {
            return 165 * 1.3 * quantity;
        }

    }

    private double discount(int quantity, double total) {
        if (quantity >=  3) {
            return total - total* 0.1;
        }
        return total;
    }

}

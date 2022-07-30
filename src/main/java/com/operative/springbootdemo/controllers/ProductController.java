package com.operative.springbootdemo.controllers;

import com.operative.springbootdemo.entity.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class ProductController {

   static ArrayList<Product> productList = new ArrayList<>();

    @PostMapping("/products/add")
    public Product addProduct(@RequestBody Product prod){
        System.out.println("ProductController:addProduct");
        this.productList.add(prod);
        return prod;
    }

    @GetMapping("/products/list")
    public ArrayList getProduct(){
        System.out.println("ProductController:getProduct");
        return this.productList;
    }

    @DeleteMapping("/products/delete/{id}")
    public ArrayList<Product> deleteProduct(@PathVariable("id") int id){
        System.out.println("ProductController:deleteProduct");
       productList.removeIf(product -> (product.getId()==id));
       return productList;
    }

    @PutMapping("/products/update/{id}")
    public ArrayList<Product> updateProduct(@RequestBody Product prod , @PathVariable("id") int id){
        System.out.println("ProductController:updateProduct");
        for(Product product:productList){
            if(product.getId()==prod.getId()){
                product.setName(prod.getName());
                product.setManufacturer(prod.getManufacturer());
                product.setDesc(prod.getDesc());
                product.setPrice(prod.getPrice());
            }

        }
        return productList;
    }

    @GetMapping("/products/find/{manufacturer}")
    public ArrayList<Product> findByManufacturer(@PathVariable("manufacturer") String manufacturer){
        System.out.println("ProductController:findByManufacturer");
        ArrayList<Product> res = new ArrayList<>();
        for(Product prod:productList){
            if(prod.getManufacturer().equalsIgnoreCase(manufacturer)){
                res.add(prod);
            }
        }
        return res;
    }
}

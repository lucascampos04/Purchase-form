package com.treino.treino.controller;

import com.treino.treino.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @GetMapping("/product-form")
    public String showProductForm(Model model){
        model.addAttribute("product", new Product());
        return "index";
    }

    @GetMapping("/buy-success")
    public String success(){
        return "success";
    }

    @PostMapping("/save-product")
    public String saveProject(Product product){
        return "redirect:/buy-success";
    }

}

package com.treino.treino.controller;

import com.treino.treino.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @GetMapping("/")
    public String showProductForm(Model model){
        model.addAttribute("product", new Product());
        return "index";
    }

    @GetMapping("/buy-success")
    public String success(){
        return "success";
    }

    @PostMapping("/save-product")
    public ModelAndView saveProject(Product product){
        ModelAndView mv = new ModelAndView("success");
        mv.addObject("message", "Produto salvo com sucesso");
        return mv;
    }

}

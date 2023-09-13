package com.treino.treino.controller;

import com.treino.treino.model.Product;
import com.treino.treino.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.Map;

@Controller
@RequestMapping("/")
public class ProductController {

    @GetMapping
    public String showProductForm(Model model){
        model.addAttribute("product", new Product());
        return "index";
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Map<String, String>> saveProject(@RequestBody Product product){
        ModelAndView mv = new ModelAndView("success");

        try{
            if(product.getName() == null || product.getName().isEmpty()){
                throw new IllegalArgumentException("O nome é obrigatório");
            }

            if(product.getTelefone() == null || product.getTelefone().isEmpty()){
                throw new IllegalArgumentException("O Telefone é obrigatório");
            }

            if(product.getWhatsapp() == null || product.getWhatsapp().isEmpty()){
                throw new IllegalArgumentException("O Whatsapp é obrigatório");
            }

            if(product.getEmail() == null || product.getEmail().isEmpty()){
                throw new IllegalArgumentException("O email é obrigatório");
            }

            if (product.getPassword().equals(product.getConfirm_password())){
                mv.addObject("message_password", "As senhas não se coincidem");
            }
            ProductRepository pr = new ProductRepository();
            pr.save(product);

            return ResponseEntity.ok().body(Collections.singletonMap("message_success", "Produto salvo com sucesso"));

        }catch (IllegalArgumentException e){
           return ResponseEntity.badRequest().body(Collections.singletonMap("message_success", e.getMessage()));
        }
    }

}
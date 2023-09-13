package com.treino.treino.model;

import lombok.Data;

import java.util.Random;

@Data
public class Product {
    private Long id;
    private String name;
    private String email;
    private String telefone;
    private String whatsapp;
    private String password;
    private String confirm_password;

    public Product(){
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        this.id = random.nextLong();
    }
}

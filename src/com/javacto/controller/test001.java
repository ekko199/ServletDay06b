package com.javacto.controller;

import com.javacto.po.Dog;
import com.javacto.service.DogService;
import com.javacto.service.DogServiceImpl;

public class test001 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        DogService dogService = new DogServiceImpl();
        System.out.println(dogService.getTotalCount(null));

    }

}

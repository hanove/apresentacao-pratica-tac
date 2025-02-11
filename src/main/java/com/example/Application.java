package com.example;

import io.micronaut.runtime.Micronaut;

public class Application {

    public static void main(String[] args) {
        Micronaut.build(args)
                .eagerInitSingletons(true)
                .mainClass(Application.class)
                .start();
        //Micronaut.run(Application.class, args);
    }
}
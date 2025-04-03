package com.cts.qualifier2;

import org.springframework.stereotype.Component;

//@Component
public class DieselEngine implements Engine {
    //@Override
    public void start() {
        System.out.println("Diesel Engine started");
    }
}
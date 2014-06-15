package com.huang.serviceloader;

import java.util.ServiceLoader;

/**
 * Created by fenfanxiadewunai on 14-6-3.
 */
public class testSayHi {

    public static void main(String[] args) {

        System.out.println("hello world");


        ServiceLoader<SayHi> serviceLoader =
                ServiceLoader.load(SayHi.class);

        for (SayHi service : serviceLoader) {
            System.out.println(service.say());
        }
    }
}

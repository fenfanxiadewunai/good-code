package com.huang.genetator;

/**
 * Created by fenfanxiadewunai on 14-6-8.
 */
public class Coffee {
    private static long counter = 0;
    private final long id = counter++;

    public String toString(){
        return getClass().getSimpleName()+" "+id;
    }
}

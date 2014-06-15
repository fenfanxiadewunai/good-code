package com.huang.genetator;

/**
 * Created by fenfanxiadewunai on 14-6-8.
 */
public class CountedObject {
    private static long counter = 0;
    private final long id = counter++;

    public long id(){
        return id;
    }

    public String toString(){
        return "CountedObject "+id;
    }
}

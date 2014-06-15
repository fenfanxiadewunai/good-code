package com.huang.enumutl;

import java.util.Random;

/**
 * Created by fenfanxiadewunai on 14-6-9.
 */
public enum Input {
    NICKEL(5),DIME(10),QUARTER(25),DOLLAR(100),
    TOOTHPASTE(200),CHIPS(75),SODA(100),SOAP(50),
    ABORT_TRANSACTION{
        public int amount(){
            throw new RuntimeException("ABORT.amount()");
        }
    },
    STOP{
        public int amount(){
            throw  new RuntimeException("SHUT_DOWN.amount()");
        }
    };
    int value;
    private Input(int value){
        this.value = value;
    }

    private Input(){}

    public int amount(){
        return value;
    }

    private static Random rand = new Random(47);

    public static Input randomSelection(){
        return values()[rand.nextInt(values().length-1)];
    }
}

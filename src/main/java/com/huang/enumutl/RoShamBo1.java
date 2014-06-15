package com.huang.enumutl;

import java.util.Random;

/**
 * Created by fenfanxiadewunai on 14-6-9.
 */
public class RoShamBo1 {
    static final int SIZE = 20;
    private static Random rand = new Random(47);

    public static Item newItem(){
        switch(rand.nextInt(3)){
            default:
            case 0: return new Scissors();
            case 1: return new Paper();
            case 2: return new Rock();
        }
    }

    public static void match(Item a,Item b){
        System.out.println(a + " VS. " + b+":"+a.complete(b));
    }

    public static void main(String[] args) {
        for(int i = 0;i<SIZE;i++){
            match(newItem(),newItem());
        }
    }


}

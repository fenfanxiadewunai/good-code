package com.huang.genetator;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by fenfanxiadewunai on 14-6-8.
 */
public class Generators {

    public static <T> Collection<T> fill(Collection<T> coll,Generator<T> gen,int n){
        for(int i = 0 ;i<n;i++){
            coll.add(gen.next());
        }
        return coll;
    }

    public static void main(String[] args) {
        Collection<Coffee> coffee = fill(new ArrayList<Coffee>(),new CoffeeGenerator(),5);
        for(Coffee c: coffee){
            System.out.println(c);
        }
    }
}

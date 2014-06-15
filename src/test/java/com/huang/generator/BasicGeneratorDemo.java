package com.huang.generator;

import com.huang.genetator.BasicGenerator;
import com.huang.genetator.CountedObject;
import com.huang.genetator.Generator;

/**
 * Created by fenfanxiadewunai on 14-6-8.
 */
public class BasicGeneratorDemo {
    public static void main(String[] args) {
        Generator<CountedObject> gen = BasicGenerator.create(CountedObject.class);
        for(int i = 0;i<5;i++){
            System.out.println(gen.next());
        }
    }
}

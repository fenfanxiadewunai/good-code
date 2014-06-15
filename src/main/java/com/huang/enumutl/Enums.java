package com.huang.enumutl;

import java.util.Random;

/**
 * Created by fenfanxiadewunai on 14-6-8.
 */
public class Enums {

    private static Random random = new Random(47);

    public static <T extends  Enum<T>> T random(Class<T> enumClass){
        return random(enumClass.getEnumConstants());
    }

    public static <T> T random(T[] values){
        return values[random.nextInt(values.length)];
    }
}

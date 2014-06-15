package com.huang.nullobject;

/**
 * Created by fenfanxiadewunai on 14-6-8.
 */
public class Person {
    private final String first;
    private final String last;
    private final String address;

    public Person(String first,String last,String address){
        this.first = first;
        this.last = last;
        this.address = address;
    }

    public String toString(){
        return "Person:"+first+" "+last+" "+address;
    }

    public static class NULLPerson extends Person implements NULL{
        private NULLPerson(){
            super("none","none","none");
        }
        public String toString(){
            return "NULLPerson";
        }
    }

    public static final Person NULL = new NULLPerson();
}

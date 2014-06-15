package com.huang.enumutl;
import  static com.huang.enumutl.Outcome.*;
/**
 * Created by fenfanxiadewunai on 14-6-9.
 */
public interface Item {

    Outcome complete(Item item);

    Outcome eval(Paper paper);

    Outcome eval(Scissors scissors);

    Outcome eval(Rock rock);
}

//布
class Paper implements Item{

    @Override
    public Outcome complete(Item item) {
        return item.eval(this);
    }

    @Override
    public Outcome eval(Paper paper) {
        return DRAW;
    }

    @Override
    public Outcome eval(Scissors scissors) {
        return WIN;
    }

    @Override
    public Outcome eval(Rock rock) {
        return LOSE;
    }

    public String toString(){
        return "Paper";
    }
}

class Scissors implements Item{
    @Override
    public Outcome complete(Item item) {
        return item.eval(this);
    }

    @Override
    public Outcome eval(Paper paper) {
        return LOSE;
    }

    @Override
    public Outcome eval(Scissors scissors) {
        return DRAW;
    }

    @Override
    public Outcome eval(Rock rock) {
        return WIN;
    }

    public String toString(){
        return "Scissors";
    }
}

class Rock implements Item{
    @Override
    public Outcome complete(Item item) {
        return item.eval(this);
    }

    @Override
    public Outcome eval(Paper paper) {
        return WIN;
    }

    @Override
    public Outcome eval(Scissors scissors) {
        return LOSE;
    }

    @Override
    public Outcome eval(Rock rock) {
        return DRAW;
    }

    public String toString(){
        return "Rock";
    }



}




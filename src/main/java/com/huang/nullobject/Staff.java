package com.huang.nullobject;


import java.util.ArrayList;

/**
 * Created by fenfanxiadewunai on 14-6-8.
 */
public class Staff extends ArrayList<Position>{
    public void add(String title,Person person){
        add(new Position(title,person));
    }

    public void add(String ...titles){
        for(String title:titles){
            add(new Position(title));
        }
    }

    public Staff(String ...titles){
        add(titles);
    }

    public boolean positionAvailable(String title){
        for(Position position:this){
            if(position.getTitle().equals(title)&&position.getPerson() == Person.NULL){
                return true;
            }
        }
        return false;
    }

    public void fillPosition(String title,Person hire){
        for(Position position:this){
            if(position.getTitle().equals(title)&&position.getPerson() == Person.NULL){
                position.setPerson(hire);
                return;
            }
        }
        throw new RuntimeException("Position "+title + " not available");
    }

    public static void main(String[] args) {
        Staff staff = new Staff("President","CTO","Marketing Manager");
        staff.fillPosition("President",new Person("Me","Last","hz"));
        if(staff.positionAvailable("CTO")){
            staff.fillPosition("CTO",new Person("You","Last","hz"));
        }
        System.out.println(staff);
    }

}

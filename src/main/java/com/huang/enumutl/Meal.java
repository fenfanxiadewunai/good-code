package com.huang.enumutl;

/**
 * Created by fenfanxiadewunai on 14-6-8.
 */
public enum Meal {

    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);

    private Food[] values;

    private Meal(Class<? extends Food> kind){
        values = kind.getEnumConstants();
    }

    private Food randomSelection(){
        return Enums.random(values);
    }

    public interface Food{
        enum Appetizer implements Food{
            SALAD,SOUP,SPRING_ROLLS;
        }

        enum MainCourse implements Food{
            LASAGNE,BURRITO,PAD_THAI;
        }

        enum Dessert implements Food{
            FRUIT,TIRAMISU,GELATO;
        }

        enum Coffee implements Food{
            LATTE,TEA,HERB_TEA;
        }

    }

    public static void main(String[] args) {
        for(int i = 0;i<5;i++){
            for(Meal m:Meal.values()){
                Food food = m.randomSelection();
                System.out.println(food);
            }
            System.out.println("-----------------------");
        }
    }

}

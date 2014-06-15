package com.huang.enumutl;

import com.huang.genetator.Generator;

/**
 * Created by fenfanxiadewunai on 14-6-9.
 */
public class VendingMachine {

    private static State state = State.RESTING;
    private static int amount = 0;
    private static Input selection = null;

    enum StateDuration{TRANSIENT}

    enum State{
        RESTING{
            public void next(Input input){
                switch (Category.categorize(input)){
                    case MONEY:
                        amount+=input.amount();
                        state = ADDING_MONEY;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                    default:
                }
            }
        },
        ADDING_MONEY{
            public void next(Input input){
                switch (Category.categorize(input)){
                    case MONEY:
                        amount += input.amount();
                        break;
                    case ITEM_SELECTION:
                        selection = input;
                        if(amount < selection.amount())
                            System.out.println("Insufficient money for "+selection);
                        else state = DISPENSING;
                        break;
                    case QUIT_TRANSACTION:
                        state = GIVING_CHANGE;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                    default:

                }
            }
        },
        DISPENSING(StateDuration.TRANSIENT){
            public void next(){
                System.out.println("here is your "+selection);
                amount -= selection.amount();
                state = GIVING_CHANGE;
            }
        },
        GIVING_CHANGE(StateDuration.TRANSIENT){
            public void next(){
                if(amount>0){
                    System.out.println("Your change: "+amount);
                    amount = 0;
                }
                state = RESTING;

            }
        },
        TERMINAL{
            public void output(){
                System.out.println("Halted");
            }
        };

        private boolean isTransient = false;

        private State(){}

        private State(StateDuration trans){
            isTransient = true;
        }

        public void next(Input input){
            throw new RuntimeException(("Only call "+ "next(Input input) for non-transient states"));
        }

        public void next(){
            throw new RuntimeException("Only call next() for StateDuration.TRANSIENT states");
        }

        public void output(){
            System.out.println(amount);
        }

    }

    static void run(Generator<Input> gen){
        while(state != State.TERMINAL){
            state.next(gen.next());
            while(state.isTransient){
                state.next();
            }
            state.output();
        }
    }

    public static void main(String[] args) {
        Generator<Input> gen = new RandomInputGenerator();
        run(gen);
    }

}

class RandomInputGenerator implements Generator<Input>{
    public Input next(){
        return Input.randomSelection();
    }
}

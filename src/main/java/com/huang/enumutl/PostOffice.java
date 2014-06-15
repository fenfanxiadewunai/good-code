package com.huang.enumutl;

/**
 * Created by fenfanxiadewunai on 14-6-8.
 */
public class PostOffice {

    enum MailHandler{

        GENERAL_DELIVERY{
            boolean handle(Mail m){
                switch (m.generalDelivery){
                    case YES:
                        System.out.println("Using general delivery for " + m);
                        return true;
                    default: return false;
                }
            }
        },

        MACHINE_SCAN{
            boolean handle(Mail m){
                switch (m.address){
                    case INCORRECT: return false;
                    default:
                        System.out.println("Delivering " + m + " automatically");
                        return true;
                }
            }
        },

        VISUAL_INSPECTION{
            boolean handle(Mail m){
                switch (m.readability){
                    case ILLEGIBLE: return false;
                    default:
                        System.out.println("Delivering " + m + " normally");
                        return true;
                }
            }
        },

        RETURN_TO_SENDER{
            boolean handle(Mail m){
                switch (m.returnAddress){
                    case MISSING: return false;
                    default:
                        System.out.println("Returning  " + m + " to sender");
                        return true;
                }
            }
        };

        abstract boolean handle(Mail m);

    }

    public static void handle(Mail m){
        for(MailHandler handler: MailHandler.values()){
            if(handler.handle(m)){
                return ;
            }
        }

        System.out.println(m + "is a dead letter");
    }

    public static void main(String[] args) {
        for(Mail m:Mail.generator(10)){
            System.out.println(m.details());
            handle(m);
            System.out.println("---------------");
        }
    }

}

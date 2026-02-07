package Class;

import java.util.Scanner;

public class UserInterface {



        public static void unknownCommand() {
            System.out.println("Neznamy prikaz!");
        }

        public static void missingArgument(String command) {
            System.out.println("Prikaz '" + command + "' vyzaduje parametr.");
        }

        public static void cannotMove() {
            System.out.println("Tím směrem to nejde.");
        }
        public static void introduction(){
            System.out.println( "Vítej ve hře Helios od tvůrce Jonáše.\n Tvým cílem je uniknout z rozpadající lodi pomocí modulu před kompletní destrukcí.\n Loď se pomalu rozpadá a nemáš moc času každý pohyb ti vyplýtvá trochu času, proto se musíš rozhodovat správně.\n Hodně štěstí.\n\n");
        }
        public void dialogueLyra(androidLyra lyra, Scanner src,Player player, Item item){
            lyra.getDialogue();
            try {
            System.out.println("Možnosti:\n 1. Zjistit podrobnosti o místnosti \n 2. Odejít");
            switch(src.nextInt()) {
                case 1:
                        lyra.getDialogue1();
                        System.out.println("Možnosti: \n 1. Potřebuji oblek \n 2. odejít");
                        switch (src.nextInt()) {
                            case 1:
                                lyra.getDialogue1more();
                                player.addInventory(item);
                                System.out.println("Dostal jsi ochranný oblek");
                                break;
                            case 2:
                                break;
                            default:
                                System.out.println("Neznámý příkaz.");
                        }
                        break;
                    case 2:
                        System.out.println("Co teď?");
                        break;
                    default:
                        System.out.println("Neznámý příkaz.");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

}

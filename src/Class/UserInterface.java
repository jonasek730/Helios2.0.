package Class;

import java.util.Scanner;

public class UserInterface {
        public static void introduction(){
            System.out.println( "Vítej ve hře Helios od tvůrce Jonáše.\n Tvým cílem je uniknout z rozpadající lodi pomocí modulu před kompletní destrukcí.\n Loď se pomalu rozpadá a nemáš moc času každý pohyb ti vyplýtvá trochu času, proto se musíš rozhodovat správně.\n Hodně štěstí.\n\n");
        }
        Scanner src = new Scanner(System.in);
        public String dialogueAX(robotAX ax,Player player,Item item){
            ax.getDialogue();
            return "";
        }
        public String dialogueLyra(androidLyra lyra, Player player, Item item){
            lyra.getDialogue();
            try {
            System.out.println("Možnosti:\n 1. Zjistit podrobnosti o místnosti \n 2. Odejít");
                String choice = src.nextLine();

                switch (choice) {
                case "1":
                        lyra.getDialogue1();
                        System.out.println("Možnosti: \n 1. Potřebuji oblek \n 2. odejít");
                    String subChoice = src.nextLine();

                    switch (subChoice) {
                            case "1":
                                lyra.getDialogue1more();
                                player.addInventory(item);
                                System.out.println("Dostal jsi ochranný oblek");
                                break;
                            case "2":
                                return choice;
                            default:
                                System.out.println("Neznámý příkaz.");
                                return choice;
                        }
                        break;
                    case "2":
                        return choice;
                    default:
                        System.out.println("Neznámý příkaz.");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            return null;
        }
        public static void helpInfo(){
            System.out.println("Pro krátký soupis dostupných příkazů napiš: napoveda");
        }

}

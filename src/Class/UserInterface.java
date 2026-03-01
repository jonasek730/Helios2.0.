package Class;

import java.util.Scanner;

/**
 * Původně jsem se snažil držet všechy výpisy v této třídě
 * Třída pro jednoduché metody s výpisem
 */
public class UserInterface {
    /**
     * Metoda pro představení hry
     */
        public static void introduction(){
            System.out.println( "Vítej ve hře Helios od tvůrce Jonáše.\n Tvým cílem je uniknout z rozpadající lodi pomocí modulu před kompletní destrukcí.\n Loď se pomalu rozpadá a nemáš moc času každý pohyb ti vyplýtvá trochu času, proto se musíš rozhodovat správně.\n Hodně štěstí.\n\n");
        }




    /**
     * Metoda pro rozhovor s robotemAX
     * @param ax robot se kterým si hráč povídá
     */
    public String dialogueAX(robotAX ax, Scanner src) {

        System.out.println(ax.getDialogue());

        System.out.println("Možnosti:\n1. Zjistit přístupový kód\n2. Co se děje s lodí?\n3. Odejít");
        String choice = src.nextLine();

        switch (choice) {

            case "1":
                System.out.println(ax.getDialogue1());
                System.out.println("Možnosti:\n1. Ano\n2. Ne\nZadej číslo volby.");
                String choice2 = src.nextLine();

                switch (choice2) {

                    case "1":
                        System.out.println(ax.getDialogue1question());
                        String choice3 = src.nextLine();

                        if (ax.getCount().equals(choice3)) {
                            System.out.println(ax.getAnswer());
                        } else {
                            System.out.println("Odpověď je špatná.");
                        }
                        break;

                    case "2":
                        return "exit";

                    default:
                        System.out.println("Neznámý příkaz.");
                }
                break;

            case "2":
                System.out.println(ax.getDialogue2());
                break;

            case "3":
                return "exit";

            default:
                System.out.println("Neznámý příkaz.");
        }

        return "continue";
    }
    /**
     * Metoda pro rozhovor s androidLyra
     * @param lyra objekt se kterym si hrac povida
     * @param player hráč který si povídá
     * @param item objekt který hráč dostane
     * @return
     */
    public String dialogueLyra(androidLyra lyra, Player player, Item item, Scanner src) {

        System.out.println(lyra.getDialogue());
        System.out.println("Možnosti:\n1. Zjistit podrobnosti o místnosti\n2. Odejít");

        String choice = src.nextLine();

        switch (choice) {

            case "1":
                System.out.println(lyra.getDialogue1());
                System.out.println("Možnosti:\n1. Potřebuji oblek\n2. Odejít");

                String subChoice = src.nextLine();

                switch (subChoice) {

                    case "1":
                        System.out.println(lyra.getDialogue1more());
                        player.addInventory(item);
                        player.setTask(3);
                        System.out.println("Dostal jsi ochranný oblek");
                        break;

                    case "2":
                        return "back";

                    default:
                        System.out.println("Neznámý příkaz.");
                        return "continue";
                }
                break;

            case "2":
                return "exit";

            default:
                System.out.println("Neznámý příkaz.");
                return "continue";
        }

        return "continue";
    }

    /**
     * Lehká pomocná metoda původně jsem myslel že výpisy budu mít v 1 třídě.
     */
    public static void helpInfo(){
            System.out.println("Pro krátký soupis dostupných příkazů napiš: napoveda");
        }

    }


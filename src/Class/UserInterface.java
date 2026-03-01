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
    public String dialogueAX(robotAX ax,Scanner src){
            ax.getDialogue();
            try{
                System.out.println("Možnosti:\n 1.Zjistit přístupový kód.\n 2.Co se děje s lodí?\n3.Odejít");
                String choice= src.nextLine();
                switch (choice){
                    case "1":
                        ax.getDialogue1();
                        System.out.println("Možnosti:\n 1.Ano \n 2.Ne \nZadej číslo volby.");
                        String choice2= src.nextLine();
                        switch (choice2){
                            case "1":
                                ax.getDialogue1question();
                                String choice3 = src.nextLine();
                                if(ax.getCount().equals(choice3)) {
                                ax.getAnswer();

                                }
                                else{
                                    System.out.println("Odpověd je špatná.");
                                }
                                break;
                            case "2":return choice;
                            default:  System.out.println("Neznámý příkaz.");
                            return choice;
                        }
                    case"2":
                        ax.getDialogue2();
                        return choice;
                    case "3":
                        return choice;
                    default:
                        System.out.println("Neznámý příkaz.");
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }
            return null;
        }

    /**
     * Metoda pro rozhovor s androidLyra
     * @param lyra objekt se kterym si hrac povida
     * @param player hráč který si povídá
     * @param item objekt který hráč dostane
     * @return
     */
        public String dialogueLyra(androidLyra lyra, Player player, Item item, Scanner src){
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
                                player.setTask(3);
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

    /**
     * Lehká pomocná metoda původně jsem myslel že výpisy budu mít v 1 třídě.
     */
    public static void helpInfo(){
            System.out.println("Pro krátký soupis dostupných příkazů napiš: napoveda");
        }

    }


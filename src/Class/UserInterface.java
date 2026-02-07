package Class;

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


}

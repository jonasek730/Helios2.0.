    package Class;
import Commands.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static Class.UserInterface.helpInfo;

    /**
     * Třída starající se o správný průběh hry
     */
    public class GameEngine {
    private boolean playing;
        private Player player;

        /**
         * Metoda tvořící posloupnost a logiku hry
         */

   public void start(){
       UserInterface.introduction();
       DataLoader loader = new DataLoader();
       List<Room> rooms = loader.loadRoomsData();
       DataLoader dl =new DataLoader();
       dl.linkRooms(rooms);
       player = new Player("hrac",rooms.get(0),100);
       initCommands(player,new UserInterface(), loader);
       Scanner scr = new Scanner(System.in);
       boolean running = true;


       while (running) {
           helpInfo();
           System.out.print("> ");

           String input = scr.nextLine();

           if (input.equalsIgnoreCase("exit")) {
               running = false;
               System.out.println("Konec hry.");
           } else {

               instructions(input);
           }





           if (player.getTime() <= 0) {
               System.out.println("Čas vypršel, loď se rozpadla. Prohrál jsi.");
               running = false;
           }
           if ("Hangár".equals(player.getActualRoom().getName())||player.hasItem("energetický článek")&&player.hasItem("klíčky od modulu")&&player.hasItem("Datové nosiče")){
               System.out.println("Gratuluji vyhrál jsi.");
           }
       }
   }
    public String isWin(){return "Vyhrál jsi";}

        /**
         * Pomocná metoda pro výpis aktuální místnosti
         */
   private void printCurrentRoomInfo() {
            System.out.println("\nAktuální místnost: " + player.getActualRoom().getName());
            System.out.println("Popis: " + player.getActualRoom().getDescription());
            if (!player.getActualRoom().getPersons().isEmpty()){
                System.out.println("V místnosti se nachází" +player.getActualRoom().getPersons());
            }
        }

        /**
         * Metoda přidává pro každý command heslo pro spuštění
         */
        private Map<String, Command> commands = new HashMap<>();
    public GameEngine(){}
        private void initCommands(Player p,UserInterface ui,DataLoader dl) {
            commands.put("jdi", new MoveCommand(p));
            commands.put("hledej", new DiscoverCommand(p));
            commands.put("mluv", new TalkCommand(ui, dl, p));
            commands.put("cas", new TimeCommand(p));
            commands.put("napoveda", new HintCommand());
            commands.put("inventar", new InventoryCommand(p));
            commands.put("mapa", new MapCommand(p));
    }

        /**
         * metoda rozděluje příkaz načtený od hráče a stará se o správné zpracování příkazu
         * @param input zadaný příkaz
         */
        public void instructions(String input){
            String[] parts = input.trim().split(" ", 2);

            String commandName = parts[0];
            String argument = (parts.length > 1) ? parts[1] : "";

            Command command = commands.get(commandName);

            if (command == null) {
                System.out.println("Neznámý příkaz!");
                return;
            }
            Room previousRoom = player.getActualRoom();

            String result = command.execute(argument);
            if (result != null && !result.isBlank()) {
                System.out.println(result);
            }
            if ("jdi".equalsIgnoreCase(commandName) && player.getActualRoom() != previousRoom) {
                printCurrentRoomInfo();
            }


        }


}

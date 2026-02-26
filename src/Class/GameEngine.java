    package Class;
import Commands.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static Class.UserInterface.helpInfo;
import static Class.UserInterface.printCurrentTask;

    /**
     * Třída starající se o správný průběh hry
     */
    public class GameEngine {
        private Player player;


        /**
         * Metoda tvořící posloupnost a logiku hry
         */

   public void start(){
       UserInterface.introduction();
       DataLoader loader = new DataLoader();
       List<Room> rooms = loader.loadRoomsData();
       loader.linkRooms(rooms);
       player = new Player("hrac",rooms.get(0),100);
       Scanner scr = new Scanner(System.in);
       initCommands(player,new UserInterface(), loader, scr);
       boolean running = true;
       loader.loadAI().getTaskStart();


       while (running) {
           helpInfo();
           System.out.print("> ");

           int currentTask = player.getTask();
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
           boolean hasWinningItems = player.hasItem("energetický článek")
                   && player.hasItem("klíčky od modulu")
                   && player.hasItem("Datové nosiče");
           if ("Hangár".equals(player.getActualRoom().getName()) && hasWinningItems){
               System.out.println("Gratuluji, vyhrál jsi.");
               running = false;

           }
           if(currentTask!= player.getTask()){
               printCurrentTask(loader.loadAI(), player);
           }
       }
   }
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
        private void initCommands(Player p,UserInterface ui,DataLoader dl,Scanner scanner) {
            commands.put("jdi", new MoveCommand(p));
            commands.put("hledej", new DiscoverCommand(p,scanner));
            commands.put("mluv", new TalkCommand(ui, dl, p,scanner));
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

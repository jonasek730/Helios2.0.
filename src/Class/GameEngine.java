    package Class;
import Commands.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

    public class GameEngine {
    private boolean playing;



   public void start(){
       UserInterface.introduction();
       DataLoader loader = new DataLoader();
       List<Room> rooms = loader.loadRoomsData();
       List<Item> items = loader.loadItemData();
       androidLyra lyra = loader.loadAndroidLyra();
       robotAX ax = loader.loadRobotAX();
       DataLoader dl =new DataLoader();
       dl.linkRooms(rooms);
       Player player = new Player("hrac",rooms.get(0),100);
       initCommands(player, rooms.get(0), new UserInterface(), loader);
       Scanner scr = new Scanner(System.in);
       boolean running = true;

       while (running) {

           System.out.println("\nAktuální místnost: " + player.getActualRoom().getName());
           System.out.println("Popis: " + player.getActualRoom().getDescription());
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
       }
   }
    public String isWin(){return "Vyhrál jsi";}



    private Map<String, Command> commands = new HashMap<>();
    public GameEngine(){

    }
    private void initCommands(Player p, Room r,UserInterface ui,DataLoader dl) {
        commands.put("jdi", new MoveCommand(p));
        commands.put("hledej", new DiscoverCommand(p));
        commands.put("mluv", new TalkCommand(ui,dl,p));
        commands.put("cas", new TimeCommand(p));
        commands.put("napoveda", new HintCommand());
        commands.put("inventar", new InventoryCommand(p));
        commands.put("mapa", new MapCommand(r));
        commands.put("uloz", new SaveCommand());
    }

        public void instructions(String input){
            String[] parts = input.trim().split(" ", 2);

            String commandName = parts[0];
            String argument = (parts.length > 1) ? parts[1] : "";

            Command command = commands.get(commandName);

            if (command == null) {
                System.out.println("Neznámý příkaz!");
                return;
            }

            command.execute(argument);
        }
}

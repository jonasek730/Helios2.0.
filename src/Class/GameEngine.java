    package Class;
import Commands.*;
import java.util.HashMap;
import java.util.Map;

public class GameEngine {
    private boolean playing;



   public void start(){
       UserInterface.introduction();

   }
    public String isWin(){return "Vyhrál jsi";}



    private Map<String, Command> commands = new HashMap<>();
    public GameEngine(Player p,Room r){
    commands.put("jdi",new MoveCommand(p));
    commands.put("hledej",new DiscoverCommand(p));
    commands.put("mluv",new TalkCommand(p));
    commands.put("cas",new TimeCommand(p));
    commands.put("napoveda",new HintCommand());
    commands.put("inventar",new InventoryCommand(p));
    commands.put("mapa",new MapCommand(r));
    commands.put("uloz",new SaveCommand());
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

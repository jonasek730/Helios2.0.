package Class;

import Commands.Command;
import Commands.DiscoverCommand;
import Commands.MoveCommand;
import Commands.TalkCommand;

import java.util.HashMap;
import java.util.Map;

public class GameEngine {
    private boolean playing;

    private String mainTask;

    public void doCommand(){}
    public String isWin(){return "Vyhrál jsi";}


    public String introduction(){
       return "Vítej ve hře Helios od tvůrce Jonáše.\n Tvým cílem je uniknout z rozpadající lodi pomocí modulu před kompletní destrukcí.\n Loď se pomalu rozpadá a nemáš moc času každý pohyb ti vyplýtvá trochu času, proto se musíš rozhodovat správně.\n Hodně štěstí.\n\n";
    }
    private Map<String, Command> commands = new HashMap<>();
    public CommandManager(Player p,Room r){
    commands.put("jdi",new MoveCommand(p));
    commands.put("hledej",new DiscoverCommand(r));
    commands.put("mluv",new TalkCommand(p));
    commands.put("")

    }
}

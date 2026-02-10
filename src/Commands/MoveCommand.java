package Commands;
import Class.*;
public class MoveCommand implements Command {
private Player player;

    public MoveCommand(Player player) {
        this.player = player;
    }


    public String execute(String argument) {
        if (argument == null || argument.isBlank()) {
            return "Kam mám jít?";
        }
        if (!player.RoomisAround(argument)) {
            return "Tím směrem to nejde.";
        }

        player.moveToRoom(argument);
        player.consumeTime(1);
        return "Přesunul ses do místnosti: " + player.getActualRoom().getName();
    }

}

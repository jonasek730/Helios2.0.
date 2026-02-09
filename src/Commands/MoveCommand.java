package Commands;
import Class.*;
public class MoveCommand implements Command {
private Player player;

    public MoveCommand(Player player) {
        this.player = player;
    }


    public String execute(String argument) {
        if (argument.isEmpty()) {

            return "Kam mam jit?";
        }else {
        if (player.RoomisAround(player.getActualRoom().getName())&& player.getActualRoom().isAvailable() ){
        player.moveToRoom(argument);
        return "Hráč se posunul do požadované místnosti.";
        }
        return "Místnost neexistuje.";
        }
    }
}

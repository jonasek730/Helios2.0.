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
        if ("Obytná sekce".equalsIgnoreCase(player.getActualRoom().getName())
                && !player.hasItem("Klíč od obytné místnosti")) {
            return "Nejdřív musíš v obytné sekci najít klíč a odemknout dveře.";
        }
            player.checkInventory();
        if (!player.RoomisAround(argument)) {
            return "Tím směrem to nejde.";
        }
        Room destinationRoom = player.getAroundRoomByName(argument);
        Room currentRoom= player.getActualRoom();
        if (!currentRoom.isAvailable() || !destinationRoom.isAvailable()) {
            return "Do této místnosti se teď nemůžeš přesunout.";
        }
        player.moveToRoom(argument);
        player.consumeTime(5);
        return "Přesunul ses do místnosti: " + player.getActualRoom().getName();
    }

}

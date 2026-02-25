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

        Room destinationRoom = player.getAroundRoomByName(argument);
        Room currentRoom = player.getActualRoom();

        if (destinationRoom == null) {
            return "Tím směrem to nejde.";
        }

        if ("Energetické jádro".equalsIgnoreCase(destinationRoom.getName())
                && !player.hasItem("ochranný oblek")) {
            return "Do energetického jádra potřebuješ ochranný oblek.";
        }
            if ("Obytná sekce".equalsIgnoreCase(player.getActualRoom().getName())
                    && !player.hasItem("Klíč od obytné místnosti")) {
                return "Nejdřív musíš v obytné sekci najít klíč a odemknout dveře.";
            }
            player.checkInventory();
            if (!currentRoom.isAvailable() || !destinationRoom.isAvailable()) {
                return "Do této místnosti se teď nemůžeš přesunout.";
            }
            player.moveToRoom(argument);
            player.consumeTime(5);
            return "Přesunul ses do místnosti: " + player.getActualRoom().getName();
    }
}

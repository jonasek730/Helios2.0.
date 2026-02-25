package Commands;
import Class.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiscoverCommand implements Command {
    private Player player;
     Scanner scanner;

    public DiscoverCommand(Player player, Scanner scanner) {
        this.player=player;
        this.scanner= scanner;
    }

    public String execute(String argument) {
        List<Item> roomItems = player.getActualRoom().getItems();

        if ("Sklad a údržba".equals(player.getActualRoom().getName())) {
            Room hangarRoom = player.getAroundRoomByName("Hangár");
            if (hangarRoom instanceof Hangar hangar && !hangar.isAvailable()) {
                Room laboratory = getLaboratoryFromStorage();
                System.out.print("Zadej přístupový kód: ");
                return player.hangarDoor(scanner, hangar, laboratory);
            }
        }
        if (roomItems.isEmpty()) {
            return "V místnosti nic není.";
        }


        List<String> picked = new ArrayList<>();
        List<Item> snapshot = new ArrayList<>(roomItems);

        for (Item item : snapshot) {
            String result = player.addInventory(item);
            if ("Prvek byl sebrán.".equals(result)) {
                picked.add(item.getName());
                roomItems.remove(item);
            } else {
                return result;
            }
        }
        player.checkInventory();
        return "Našel jsi: " + String.join(", ", picked);
    }
    private Room getLaboratoryFromStorage() {
        Room controlBridge = player.getAroundRoomByName("Řídicí můstek");
        if (controlBridge == null) {
            return null;
        }

        for (Room aroundRoom : controlBridge.getAround()) {
            if ("Laboratoře".equalsIgnoreCase(aroundRoom.getName())) {
                return aroundRoom;
            }
        }
        return null;
    }

}


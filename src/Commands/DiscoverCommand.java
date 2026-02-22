package Commands;
import Class.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiscoverCommand implements Command {
    private Player player;

    public DiscoverCommand(Player player) {
        this.player=player;
    }

    public String execute(String argument) {
        List<Item> roomItems = player.getActualRoom().getItems();
        if (roomItems.isEmpty()) {
            return "V místnosti nic není.";
        }
        if (player.getActualRoom().getName()=="Sklad a údržba"){
            Scanner src =new Scanner(System.in);
            player.hangarDoor(src,)
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
}


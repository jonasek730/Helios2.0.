package Commands;
import Class.*;

import java.util.stream.Collectors;

public class InventoryCommand implements Command {
private Player player;
public InventoryCommand(Player player){
    this.player=player;
}
    public String execute(String argument) {
            if (player.getInventory().isEmpty()) {
                return "Inventář je prázdný.";
            }

            return "Hráč má u sebe: " + player.getInventory().stream()
                    .map(Item::getName)
                    .collect(Collectors.joining(", "));
        }

    }


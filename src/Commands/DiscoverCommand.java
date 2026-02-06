package Commands;
import Class.*;
public class DiscoverCommand implements Command {
    private Player player;

    public DiscoverCommand(Player player) {
        this.player=player;
    }

    public String execute(String argument) {
        for (int i = 0; i <player.getActualRoom().getItems().size() ; i++) {
            player.addInventory(player.getActualRoom().getItems().get(i));
        }
        return player.getActualRoom().getItems().toString();
    }


}

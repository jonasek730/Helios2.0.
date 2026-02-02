import Commands.Command;

public class InventoryCommand implements Command {
private Player player;
public InventoryCommand(Player player){
    this.player=player;
}
    public String execute(String command) {

        return "Hráč má u sebe"+player.inventory;
    }

    public boolean exit() {
        return false;
    }
}

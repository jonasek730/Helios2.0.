package Commands;
import Class.*;
public class InventoryCommand implements Command {
private Player player;
public InventoryCommand(Player player){
    this.player=player;
}
    public String execute(String argument) {

        return "Hráč má u sebe"+ player.getInventory();
    }


}

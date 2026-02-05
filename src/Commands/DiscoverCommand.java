package Commands;
import Class.*;
public class DiscoverCommand implements Command {
    private Player player;

    public DiscoverCommand(Player player) {
        this.player=player;
    }

    public String execute(String argument) {

        return player.getActualRoom().getItems().toString() ;
    }


}

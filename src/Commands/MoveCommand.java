package Commands;
import Class.*;
public class MoveCommand implements Command {
private Player player;

    public MoveCommand(Player player) {
        this.player = player;
    }

    public String execute(String command) {
        return "";
    }

    public boolean exit() {
        return false;
    }
}

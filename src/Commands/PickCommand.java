package Commands;
import Class.*;
public class PickCommand implements Command {
private Player player ;

    public PickCommand(Player player){
        this.player=player;}

    public String execute(String command) {
        return "";
    }

    public boolean exit() {
        return false;
    }
}

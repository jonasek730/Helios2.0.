package Commands;
import Class.*;
public class TalkCommand implements Command {
private Player player;
    public TalkCommand(Player player){
        this.player=player;}

    public String execute(String command) {
        player.mluv();
        return "";
    }

    public boolean exit() {
        return false;
    }
}

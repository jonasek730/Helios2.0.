package Commands;
import Class.*;
public class TalkCommand implements Command {
private Player player;
    public TalkCommand(Player player){
        this.player=player;}

    public String execute(String argument) {
        player.mluv();
        return "";
    }


}

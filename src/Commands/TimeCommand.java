package Commands;
import Class.*;
public class TimeCommand implements Command {
private Player player;
    public TimeCommand(Player player){
        this.player=player;}
    public String execute(String command) {
        System.out.println("času zbývá:"+player.getTime());
        return "";
    }

    public boolean exit() {
        return false;
    }
}

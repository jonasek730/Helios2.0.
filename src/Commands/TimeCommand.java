package Commands;
import Class.*;
public class TimeCommand implements Command {
private Player player;
    public TimeCommand(Player player){
        this.player=player;}
    public String execute(String argument) {
        System.out.println("času zbývá:"+player.getTime());
        return "";
    }


}

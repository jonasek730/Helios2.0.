package Commands;
import Class.*;
public class TimeCommand implements Command {
private Player player;
    public TimeCommand(Player player){
        this.player=player;}
    public String execute(String argument) {
            return "Času zbývá: " + player.getTime();
    }


}

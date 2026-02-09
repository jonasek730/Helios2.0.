package Commands;
import Class.*;
public class TalkCommand implements Command {
private UserInterface rozhrani;
private DataLoader dataloader;
private Player player;

    public TalkCommand(UserInterface rozhrani,DataLoader dataloader,Player player) {
        this.rozhrani = rozhrani;
        this.dataloader=dataloader;
        this.player=player;
    }

    public String execute(String argument) {
        if("lyra".equalsIgnoreCase(argument)) {
            androidLyra lyra = dataloader.loadAndroidLyra();
            return rozhrani.dialogueLyra(lyra, player, lyra.getInventory().get(1));
    }
        return "S kým chceš mluvit.";


}
}

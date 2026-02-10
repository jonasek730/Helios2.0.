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
            if (lyra.getInventory().isEmpty()) {
                return "Lyra teď nemá žádný předmět.";
            }
            return rozhrani.dialogueLyra(lyra, player, lyra.getInventory().get(0));
        }

        return "S kým chceš mluvit.";


}
}

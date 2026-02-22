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
        androidLyra lyra = dataloader.loadAndroidLyra();
        robotAX ax = dataloader.loadRobotAX();
        if (player.getActualRoom().getPersons().isEmpty()) {
            return "V místnosti si není s kým povídat";
        } else {
            if (player.getActualRoom().getPersons().contains("android Lyra")) {

                if (lyra.getInventory().isEmpty()) {
                    return "Lyra teď nemá žádný předmět.";
                } else {
                    Item reward = lyra.getInventory().get(0);
                    rozhrani.dialogueLyra(lyra, player, reward);

                }
                return "Konverzace ukončena.";
            }
            if (player.getActualRoom().getPersons().contains("robotAX")) {
               rozhrani.dialogueAX(ax);
                if (player.getActualRoom().getAround().get(2).isAvailable()) {
                    ax.getEnding();
                    player.getActualRoom().getPersons().clear();
                    player.getActualRoom().getAround().get(2).getPersons().add("robotAX");
                }
            }
        }
        return null;
    }
}

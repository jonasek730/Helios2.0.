package Commands;
import Class.*;

import java.util.Scanner;

public class TalkCommand implements Command {
private UserInterface rozhrani;
private DataLoader dataloader;
private Player player;
Scanner scanner;

    public TalkCommand(UserInterface rozhrani,DataLoader dataloader,Player player,Scanner scanner) {
        this.rozhrani = rozhrani;
        this.dataloader=dataloader;
        this.player=player;
        this.scanner = scanner;
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
                    rozhrani.dialogueLyra(lyra, player, reward,scanner);

                }
                return "Konverzace ukončena.";
            }
            if (player.getActualRoom().getPersons().contains("robotAX")) {
               rozhrani.dialogueAX(ax,scanner);
                Room destination = player.getAroundRoomByName("Hangár");
                if (destination != null && destination.isAvailable()) {
                    ax.getEnding();
                    player.getActualRoom().getPersons().clear();
                    destination.getPersons().add("robotAX");
                }
            return "Konverzace ukončena";
            }
        }

        return null;
    }
}

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


                    Item reward = lyra.getInventory().get(0);
                    lyra.getInventory().clear();
                    rozhrani.dialogueLyra(lyra, player, reward,scanner);
                    player.getActualRoom().getPersons().clear();

                return "Konverzace ukončena.";
            }
            if (player.getActualRoom().getPersons().contains("robotAX")) {
               rozhrani.dialogueAX(ax,scanner);
                Room destination = player.getAroundRoomByName("Hangár");
                if (destination != null && destination.isAvailable()) {
                    System.out.println(ax.getEnding());
                    player.getActualRoom().getPersons().clear();
                    destination.getPersons().add("robotAX");
                }
            return "Konverzace ukončena";
            }
        }

        return null;
    }
}

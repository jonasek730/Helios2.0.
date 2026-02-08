package Commands;
import Class.*;
public class TalkCommand implements Command {
private UserInterface rozhrani;
private DataLoader dataloader;
private Player player;

    public TalkCommand(UserInterface rozhrani,DataLoader dataloader) {
        this.rozhrani = rozhrani;
        this.dataloader=dataloader;
    }

    public String execute(String argument) {
        if(argument =="lyra") {
           return rozhrani.dialogueLyra(dataloader.loadAndroidLyra(),player,);
    }


}
}

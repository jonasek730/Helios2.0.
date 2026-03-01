package Commands;
import Class.*;
public class HelpCommand implements Command{
   private Player player;
   private AI ai;

    public HelpCommand(Player player, AI ai) {
        this.player = player;
        this.ai=ai;
    }

    public String execute(String argument) {
        switch (player.getTask()){
            case 0:
                return ai.getName()+" : "+ai.getTaskStart();
            case 1:
                return ai.getName()+" : "+ai.getTaskHangar();
            case 2:
                return ai.getName()+" : "+ai.getTaskLaboratory();
            case 3:
                return ai.getName()+" : "+ai.getTaskEnd();
            default:
                return "Nastala chyba";
        }

    }
}


package Commands;
import Class.*;

import java.util.stream.Collectors;

public class MapCommand implements Command {
private Player player;
    public MapCommand(Player player) {
        this.player=player;
    }
    public String execute(String argument) {
        String around = player.getActualRoom().getAround().stream()
                .map(Room::getName)
                .collect(Collectors.joining(", "));

        if (around.isBlank()) {
            return "Kolem tebe nejsou žádné průchozí místnosti.";
        }

        return "Místnosti kolem tebe jsou: " + around;

    }


}

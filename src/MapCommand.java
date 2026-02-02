import Commands.Command;

public class MapCommand implements Command {
private Room room;
    public MapCommand(Room room) {
        this.room = room;
    }
    public String execute(String command) {

        return "Místnosti kolem tebe jsou:"+room.around;
    }

    public boolean exit() {
        return false;
    }
}

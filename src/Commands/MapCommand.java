package Commands;
import Class.*;
public class MapCommand implements Command {
private Room room;
    public MapCommand(Room room) {
        this.room = room;
    }
    public String execute(String argument) {

        return "Místnosti kolem tebe jsou:"+room.getAround();
    }


}

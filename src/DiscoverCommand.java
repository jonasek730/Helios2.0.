import Commands.Command;

public class DiscoverCommand implements Command {
    private Room room;

    public DiscoverCommand(Room room) {
        this.room = room;
    }

    public String execute(String command) {
        System.out.println("V této místnosti se nachází");
        System.out.println(room.items);
        return "";
    }

    public boolean exit() {
        return false;
    }
}

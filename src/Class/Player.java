package Class;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Item> inventory = new ArrayList<>();
    private String name;
    private Room actualRoom;
    private int Time;
    private String mainTask;

    public int getTime() {
        return Time;
    }

    public Player(String name, Room actualRoom, int time) {
        this.name = name;
        this.actualRoom = actualRoom;
        Time = time;
    }
    public Player(){}

    public List<Item> getInventory() {
        return inventory;
    }

    public String addInventory(Item item) {
        if(inventory.size()>3){
            return "Tvůj inventář je plný.";
        }else{
            inventory.add(item);
            return "Prvek byl sebrán.";

        }
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getActualRoom() {
        return actualRoom;
    }

    public void moveToRoom(String roomName) {
        for (Room room : actualRoom.getAround()) {
            if (room.getName().equalsIgnoreCase(roomName)) {
                actualRoom = room;
            }
        }
    }
    public void setActualRoom(Room actualRoom) {
        this.actualRoom = actualRoom;
    }


    public void setTime(int time) {
        Time = time;
    }



    public boolean RoomisAround(String room){
        for (int i = 0; i < getActualRoom().getAround().size(); i++) {
           if(getActualRoom().getAround().get(i).equals(room)){
               return true;
           }

        }
        return false;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public String getMainTask() {
        return mainTask;
    }

    public void setMainTask(String mainTask) {
        this.mainTask = mainTask;
    }
    public boolean hasItem(String name) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
    public void checkInventory() {
        if (hasItem("1/2 karty do hangaru") && hasItem("2/2 karty do hangaru")) {
            inventory.clear();
            inventory.add(new Item("karta od hangaru", "Klíč od dveří hangáru"));
        }
    }

}

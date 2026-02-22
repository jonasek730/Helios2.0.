package Class;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    List<Item> inventory = new ArrayList<>();
    private String name;
    private Room actualRoom;
    private int Time;
    private String mainTask;

    public Player() {
    }

    public int getTime() {
        return Time;
    }

    public Player(String name, Room actualRoom, int time) {
        this.name = name;
        this.actualRoom = actualRoom;
        Time = time;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public String addInventory(Item item) {
        if (inventory.size() > 4) {
            return "Tvůj inventář je plný.";
        } else {
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


    public boolean RoomisAround(String room) {
        for (int i = 0; i < getActualRoom().getAround().size(); i++) {
            if (getActualRoom().getAround().get(i).getName().equalsIgnoreCase(room)) {
                return true;
            }

        }
        return false;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
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
        if (hasItem("Klíč od obytné místnosti")) {
            actualRoom.setAvailable(true);

        }
    }

    public void consumeTime(int amount) {
        Time -= amount;
    }

    public Room getAroundRoomByName(String roomName) {
        for (Room room : actualRoom.getAround()) {
            if (room.getName().equalsIgnoreCase(roomName)) {
                return room;
            }
        }
        return null;
    }

    public String hangarDoor(Scanner src, Hangar hangar, Room laboratory) {
        if(src.hasNextInt()) {
            int code = src.nextInt();
            if (code == hangar.getHangarcode()) {
                hangar.setAvailable(true);
                if (laboratory != null) {
                    laboratory.setAvailable(true);
                }
                return "Kód byl správný, odemkly se dveře do Hangáru i Laboratoří.";

            }
        }


            return "Zadal jsi špatný kód. Zkus se poptat o správný kód robota AX.";

    }
}

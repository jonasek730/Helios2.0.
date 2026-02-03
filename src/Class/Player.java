package Class;

import java.util.ArrayList;

public class Player {
    ArrayList<Item>inventory = new ArrayList<>();
    private String name;
    private String actualRoom;
    private int Time;

    public int getTime() {
        return Time;
    }
    public void mluv(){}

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActualRoom() {
        return actualRoom;
    }

    public void setActualRoom(String actualRoom) {
        this.actualRoom = actualRoom;
    }

    public void setTime(int time) {
        Time = time;
    }
}

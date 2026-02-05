package Class;

import java.util.ArrayList;

public class Player {
    ArrayList<Item>inventory = new ArrayList<>();
    private String name;
    private Room actualRoom;
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

    public Room getActualRoom() {
        return actualRoom;
    }

    public void setActualRoom(String room) {
        for (int i = 0; i <getActualRoom().getAround().size() ; i++) {
            if (getActualRoom().around.get(i).equals(room)){
                actualRoom=getActualRoom().around.get(i);
            }
        }
    }

    public void setTime(int time) {
        Time = time;
    }



    public boolean RoomisAround(String room){
        for (int i = 0; i < getActualRoom().getAround().size(); i++) {
           if(getActualRoom().around.get(i).equals(room)){
               return true;
           }

        }
        return false;
    }
}

package Class;

import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    ArrayList<Room>around= new ArrayList<Room>();
    private robotAX Persons;
    ArrayList<Item>items;
    public void describe(){}
    private boolean isAvailable;

    public Room() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public robotAX getPersons() {
        return Persons;
    }

    public void setPersons(robotAX persons) {
        Persons = persons;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public ArrayList<Room> getAround() {
        return around;
    }

    public void setAround(ArrayList<Room> around) {
        this.around = around;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}

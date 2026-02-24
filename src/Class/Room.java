package Class;

import java.util.ArrayList;
import java.util.List;

/**
 * Třída objektu room parametry
 */
public class Room {
    private String name;
    private String description;
    private boolean isAvailable;
    private List<String> persons = new ArrayList<>();
    private List<String> itemsNames = new ArrayList<>();
    private List<String> aroundNames = new ArrayList<>();



    private List<Item> items = new ArrayList<>();
    private List<Room> around = new ArrayList<>();

    public List<String> getAroundNames() {
        return aroundNames;
    }

    public void setAroundNames(List<String> aroundNames) {
        this.aroundNames = aroundNames;
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

    public List<Room> getAround() {
        return around;
    }
    public List<String> getPersons() {
        return persons;
    }

    public void setPersons(List<String> persons) {
        this.persons = persons;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }
}

package Class;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String name;
    private String description;
    private List<String> persons;
    private List<String> items;
    private boolean isAvailable;

    private List<String> aroundNames;
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

    public void setAround(List<Room> around) {
        this.around = around;
    }

    public List<String> getPersons() {
        return persons;
    }

    public void setPersons(List<String> persons) {
        this.persons = persons;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

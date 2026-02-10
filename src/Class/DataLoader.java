package Class;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;


public class DataLoader {
    private final ObjectMapper parser = new ObjectMapper();

    private JsonNode loadProjectNode() {
        try (InputStream input = openDataFile()) {
            JsonNode root = parser.readTree(input);
            JsonNode project = root.get("Project");

            if (input == null) {
                throw new RuntimeException("Data.json nebyl nalezen");
            }
            if (project == null || project.isMissingNode()) {
                throw new RuntimeException("V Data.json chybí uzel 'Project'.");
            }
            return project;
        } catch (IOException e) {
            throw new RuntimeException("Nepodařilo se načíst Data.json.", e);
        }
    }


    public InputStream openDataFile() throws IOException {
        try {
            return new FileInputStream("src/Data.json");
        } catch (IOException ignored) {
            return new FileInputStream("Data.json");
        }
    }

    public Map<String, Item> loadItemMap(JsonNode project) {
        Map<String, Item> items = new HashMap<>();
        JsonNode itemsNode = project.get("items");

        if (itemsNode == null || !itemsNode.isArray()) {
            return items;
        }
        for (JsonNode itemNode : itemsNode) {
            String name = itemNode.path("name").asText("");
            String description = itemNode.path("description").asText("");

            if (!name.isBlank()) {
                items.put(name, new Item(name, description));
            }
        }
        return items;
    }

    public List<Room> loadRoomsData() {
        JsonNode project = loadProjectNode();
        Map<String, Item> itemMap = loadItemMap(project);
        JsonNode roomsNode = project.get("rooms");

        if (roomsNode == null || !roomsNode.isArray()) {
            return new ArrayList<>();
        }

        List<Room> rooms = new ArrayList<>();

        for (JsonNode roomNode : roomsNode) {
            Room room = new Room();
            room.setName(roomNode.path("name").asText(""));
            room.setDescription(roomNode.path("description").asText(""));
            room.setAvailable(roomNode.path("available").asBoolean(false));

            List<String> aroundNames = new ArrayList<>();
            for (JsonNode around : roomNode.path("aroundNames")) {
                aroundNames.add(around.asText());
            }
            room.setAroundNames(aroundNames);

            List<String> persons = new ArrayList<>();
            for (JsonNode person : roomNode.path("persons")) {
                persons.add(person.asText());
            }
            room.setPersons(persons);

            List<Item> roomItems = new ArrayList<>();
            for (JsonNode itemNameNode : roomNode.path("items")) {
                String itemName = itemNameNode.asText();
                Item item = itemMap.get(itemName);
                if (item != null) {
                    roomItems.add(item);
                }
            }
            room.setItems(roomItems);

            rooms.add(room);
        }

        return rooms;
    }

    public List<Item> loadItemData() {
        JsonNode project = loadProjectNode();
        return new ArrayList<>(loadItemMap(project).values());
    }

    public androidLyra loadAndroidLyra() {
        JsonNode project = loadProjectNode();
        JsonNode lyraNode = project.path("androidLyra");

        androidLyra lyra = new androidLyra();
        lyra.setName(lyraNode.path("name").asText("android Lyra"));
        lyra.setDialogue(lyraNode.path("dialogue").asText(""));
        lyra.setDialogue1(lyraNode.path("dialogue1").asText(""));
        lyra.setDialogue1more(lyraNode.path("dialogue1More").asText(""));

        Map<String, Item> itemMap = loadItemMap(project);
        List<Item> inventory = new ArrayList<>();
        for (JsonNode itemNameNode : lyraNode.path("inventory")) {
            String itemName = itemNameNode.asText();
            Item item = itemMap.get(itemName);
            if (item != null) {
                inventory.add(item);
            }
        }
        lyra.setInventory(inventory);

        return lyra;
    }

    public robotAX loadRobotAX() {
        JsonNode project = loadProjectNode();
        JsonNode axNode = project.path("robotAX");

        robotAX ax = new robotAX();
        ax.setName(axNode.path("name").asText("AX-3"));
        return ax;
    }


    public void linkRooms(List<Room> rooms) {

        Map<String, Room> roomMap = new HashMap<>();

        for (Room r : rooms) {
            roomMap.put(r.getName(), r);
        }

        for (Room r : rooms) {
            if (r.getAroundNames() == null) continue;

            for (String name : r.getAroundNames()) {
                Room target = roomMap.get(name);

                if (target != null) {
                    r.getAround().add(target);
                } else {
                    System.out.println("VAROVÁNÍ: Místnost '" + name + "' neexistuje");
                }
            }
        }
    }
}



package Class;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;


public class DataLoader {
    private final ObjectMapper parser = new ObjectMapper();

    private JsonNode loadRootNode() {
        try (InputStream input = openDataFile()) {

            if (input == null) {
                throw new RuntimeException("Data.json nebyl nalezen");
            }
            JsonNode root = parser.readTree(input);
            if (root == null || root.isMissingNode()) {
                throw new RuntimeException("Data.json je prázdný nebo neplatný.");
            }

            return root;
        } catch (IOException e) {
            throw new RuntimeException("Nepodařilo se načíst Data.json.", e);
        }
    }


    public InputStream openDataFile() throws IOException {
        try {
            return new FileInputStream("src/resources/Data.json");
        } catch (IOException ignoredResourcesPath) {
            try {
                return new FileInputStream("src/Data.json");
            } catch (IOException ignoredLegacyPath) {
                return new FileInputStream("Data.json");
            }
        }

    }

    public Map<String, Item> loadItemMap(JsonNode root) {
        Map<String, Item> items = new HashMap<>();
        JsonNode itemsNode = root.get("items");

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
        JsonNode root = loadRootNode();
        Map<String, Item> itemMap = loadItemMap(root);
        JsonNode roomsNode = root.get("rooms");


        if (roomsNode == null || !roomsNode.isArray()) {
            return new ArrayList<>();
        }

        List<Room> rooms = new ArrayList<>();

        for (JsonNode roomNode : roomsNode) {
            Room room = new Room();
            setCommonRoomData(room, roomNode, itemMap);
            rooms.add(room);
        }


        JsonNode hangarNode = root.path("hangar");
        if (hangarNode.isArray()) {
            for (JsonNode hangarData : hangarNode) {
                Hangar hangar = new Hangar();
                setCommonRoomData(hangar, hangarData, itemMap);
                hangar.setModulAvailable(hangarData.path("ModulAvailable").asBoolean(false));
                hangar.setHangarcode(hangarData.path("Hangarcode").asInt(2048));
                rooms.add(hangar);
            }

        }


        return rooms;
    }
    private void setCommonRoomData(Room room, JsonNode roomNode, Map<String, Item> itemMap) {
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
        for (JsonNode itemNameNode : roomNode.path("itemsNames")) {
            String itemName = itemNameNode.asText();
            Item item = itemMap.get(itemName);
            if (item != null) {
                roomItems.add(item);
            }
        }
        room.setItems(roomItems);

    }

    public List<Item> loadItemData() {
        JsonNode root = loadRootNode();
        return new ArrayList<>(loadItemMap(root).values());

    }

    public androidLyra loadAndroidLyra() {
        JsonNode root = loadRootNode();
        JsonNode lyraNode = root.path("androidLyra");

        androidLyra lyra = new androidLyra();
        lyra.setName(lyraNode.path("name").asText("android Lyra"));
        lyra.setDialogue(lyraNode.path("dialogue").asText(""));
        lyra.setDialogue1(lyraNode.path("dialogue1").asText(""));
        lyra.setDialogue1more(lyraNode.path("dialogue1More").asText(""));

        Map<String, Item> itemMap = loadItemMap(root);
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
        JsonNode root = loadRootNode();
        JsonNode axNode = root.path("robotAX");


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



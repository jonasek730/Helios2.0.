package Class;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DataLoader {
    ObjectMapper parser;

    public List<Room> loadRoomsData() {
        ObjectMapper mapper = new ObjectMapper();

        try (InputStream input = new FileInputStream("Data.json")) {

            JsonNode root = mapper.readTree(input);
            JsonNode roomsNode = root.get("rooms");

            return mapper.readValue(
                    roomsNode.traverse(),
                    new TypeReference<List<Room>>() {}
            );

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<Item> loadItemData(){
        parser = new ObjectMapper();
        try {
            InputStream input = new FileInputStream("/Data.json");
            List<Item> items = parser.readValue(input, new TypeReference<List<Item>>() {});
            return items;
        }catch (FileNotFoundException e){
            throw new RuntimeException("file was not found");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public androidLyra loadAndroidLyra(){
        parser = new ObjectMapper();
        try{
            InputStream input = new FileInputStream("/Data.json");
            androidLyra lyra = parser.readValue(input, new TypeReference<androidLyra>() {});
            return lyra;
        } catch (FileNotFoundException e){
        throw new RuntimeException("file was not found");
        } catch (Exception e) {
        throw new RuntimeException(e);
    }
    }
    public robotAX loadRobotAX(){
        parser = new ObjectMapper();
        try{
            InputStream input = new FileInputStream("/Data.json");
            robotAX ax = parser.readValue(input, new TypeReference<robotAX>() {});
            return ax;
        } catch (FileNotFoundException e){
            throw new RuntimeException("file was not found");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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

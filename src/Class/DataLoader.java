package Class;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;


public class DataLoader {
    ObjectMapper parser;

    public List<Room> loadRoomsData(){
        parser = new ObjectMapper();

        try {
            InputStream input = new FileInputStream("/Data.json");
            List<Room> rooms = parser.readValue(input, new TypeReference<List<Room>>() {});
            return rooms;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("file was not found");
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

}

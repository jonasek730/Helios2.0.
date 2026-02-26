package Class;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Třída pro vytvoření hráče s parametry
 */
public class Player {
    List<Item> inventory = new ArrayList<>();
   private String name;
    private Room actualRoom;
    private int Time;
    private int task;

    public Player() {
    }

    public int getTask() {
        return task;
    }

    public int getTime() {
        return Time;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Player(String name, Room actualRoom, int time) {
        this.name=name;
        this.actualRoom = actualRoom;
        Time = time;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setTask(int task) {
        this.task = task;
    }

    /**
     * metoda pro přidání itemu do inventáře
     * @param item objekt který chceme přidat
     * @return info o sebrání
     */
    public String addInventory(Item item) {
        if (inventory.size() > 4) {
            return "Tvůj inventář je plný.";
        } else {
            inventory.add(item);
            return "Prvek byl sebrán.";

        }
    }
    public Room getActualRoom() {
        return actualRoom;
    }

    /**
     * Metoda pro posun hráče
     * @param roomName název požadované místnosti
     */
    public void moveToRoom(String roomName) {
        for (Room room : actualRoom.getAround()) {
            if (room.getName().equalsIgnoreCase(roomName)) {
                actualRoom = room;
            }
        }
    }

    /**
     * Metoda pro kontrolu okolních místností
     * @param room hledaná místnost
     * @return zda je místnost kolem aktuální místnosti
     */
    public boolean RoomisAround(String room) {
        for (int i = 0; i < getActualRoom().getAround().size(); i++) {
            if (getActualRoom().getAround().get(i).getName().equalsIgnoreCase(room)) {
                return true;
            }

        }
        return false;
    }

    /**
     * Metoda která kontroluje zda má hráč objekt v inventáři
     * @param name hledaný objekt
     */
    public boolean hasItem(String name) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metoda která se stará o otevření první místnosti
     */
    public void checkInventory() {
        if (hasItem("Klíč od obytné místnosti")) {
            actualRoom.setAvailable(true);
            setTask(1);
        }
    }

    /**
     * Metoda která ubírá hráči čas
     * @param amount množstvý času
     */
    public void consumeTime(int amount) {
        Time -= amount;
    }

    /**
     * Metoda která hledá místnosti kolem podle jména
     * @param roomName jméno místnosti
     * @return vrací místnost s daným jménem
     */
    public Room getAroundRoomByName(String roomName) {
        for (Room room : actualRoom.getAround()) {
            if (room.getName().equalsIgnoreCase(roomName)) {
                return room;
            }
        }
        return null;
    }

    /**
     * Metoda která otevírá dveře do hangáru a laboratoří podle kódu
     * @param src kód zadaný hráčem
     * @param hangar hangár s kódem
     * @param laboratory laboratoř
     * @return info o správnosti
     */
    public String hangarDoor(Scanner src, Hangar hangar, Room laboratory) {
        if(src.hasNextInt()) {
            int code = src.nextInt();
            if (code == hangar.getHangarcode()) {
                hangar.setAvailable(true);
                if (laboratory != null) {
                    laboratory.setAvailable(true);
                }
                task=2;
                return "Kód byl správný, odemkly se dveře do Hangáru i Laboratoří.";

            }
        }


            return "Zadal jsi špatný kód. Zkus se poptat o správný kód robota AX.";

    }
    /**
     * Metoda pro počítání pořadí tasků
     */


}

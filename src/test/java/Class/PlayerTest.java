package Class;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void hasItem() {
        Player p = new Player();
        Item item = new Item("Datové nosiče","Nosiče s daty o lodi před rozpadem.");
        p.addInventory(item);
        assertTrue(p.hasItem("Datové nosiče"));
    }
}
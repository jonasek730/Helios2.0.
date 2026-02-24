package Class;

import java.util.ArrayList;
import java.util.List;

/**
 * Třída slouží k vytvoření objektu androidLyra
 */
public class androidLyra extends Player {
    private String dialogue;
    private String dialogue1;
    private String dialogue1more;
    private List<Item>inventory;

    public String getDialogue() {
        return dialogue;
    }

    @Override
    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public void setDialogue(String dialogue) {
        this.dialogue = dialogue;
    }

    public String getDialogue1() {
        return dialogue1;
    }

    public void setDialogue1(String dialogue1) {
        this.dialogue1 = dialogue1;
    }

    public String getDialogue1more() {
        return dialogue1more;
    }

    public void setDialogue1more(String dialogue1more) {
        this.dialogue1more = dialogue1more;
    }

}

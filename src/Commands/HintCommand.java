package Commands;

public class HintCommand implements Command{


    public String execute(String argument) {
        return "Dostupné příkazy:\n"
                + "- jdi <mistnost>\n"
                + "- hledej\n"
                + "- mapa\n"
                + "- inventar\n"
                + "- mluv <postava>\n"
                + "- cas\n"
                + "-pomoc\n"
                + "- exit";
    }


    }

package Commands;

public class HintCommand implements Command{


    public String execute(String argument) {
        return "dostupné commandy:/n 1.Move=pohyb po místnostech,/n 2.Pick=sebrání předmětu, /n 3.Map=vypíše okolní místnosti,/n 4.Inventory=vypíše inventář,/n 5.Talk=začne konverzaci,/n 6.Time= kolik zbývá času, /n 7.Save=uloží hru.";
    }


}

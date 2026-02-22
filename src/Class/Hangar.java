package Class;

public class Hangar extends Room {
    private boolean ModulAvailable;
    private int Hangarcode;

    public boolean isModulAvailable() {
        return ModulAvailable;
    }

    public void setModulAvailable(boolean modulAvailable) {
        ModulAvailable = modulAvailable;
    }

    public int getHangarcode() {
        return Hangarcode;
    }

    public void setHangarcode(int hangarcode) {
        Hangarcode = hangarcode;
    }

    public void FixModul(){

    }
}

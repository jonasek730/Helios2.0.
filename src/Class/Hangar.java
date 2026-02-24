package Class;

/**
 * Třída objektu hangár dědí od room a přidává pár parametrů
 */
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
//Todo metoda pro opravení modulu
    }
}

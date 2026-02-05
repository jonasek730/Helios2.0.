import Class.*;
public class Main {
    public static void main(String[] args) {
        Player p =new Player();
        Room r = new Room();
        GameEngine g = new GameEngine(p,r);
        g.start();


    }
}
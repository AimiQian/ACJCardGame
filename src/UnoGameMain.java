import unogamewithplayer.UnoGame;

/**
 * @author Aimi Qian
 * Main entry to Uno Game
 */
public class UnoGameMain {
    public static void main(String[] args) {
        try {
            //UnoGame and play() has already defined in UnoGame class
            //Delegate the responsibilities ans loose-coupling, seperating the class implementation
            //from the use of the class
            UnoGame g1 = new UnoGame("Uno Game");
            g1.play();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}

import Game.Loop;

/**
 *
 * @author Vovaxs
 */
public class App {

    public static void main(String[] args) {
        Thread gameLoop = new Thread(new Loop());
        gameLoop.start();
    }
}

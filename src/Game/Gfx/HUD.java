package Game.Gfx;

import Game.Gfx.Element.Button;
import static Game.Helper.Artist.*;
import java.util.ArrayList;
import org.lwjgl.input.Mouse;
import Game.Frame;

/**
 *
 * @author Vovaxs
 */
public class HUD {

    private final ArrayList<Button> buttonList;
    public static Frame frame;

    public HUD(Frame frame) {
        HUD.frame = frame;
        this.buttonList = new ArrayList<>();
    }

    public void addButton(String name, String textureName, int x, int y) {
        buttonList.add(new Button(name, quickLoadTexture(textureName), x, y));
    }

    public boolean isButtonClicked(String buttonName) {
        Button b = getButton(buttonName);
        float mouseY = Frame.HEIGHT - Mouse.getY() - 1;
        return Mouse.getX() > b.getX() && Mouse.getX() < b.getX() + b.getWidth() / 2
                && mouseY > b.getY() && mouseY < b.getY() + b.getHeight() / 2;
    }

    public Button getButton(String buttonName) {
        for (Button b : buttonList) {
            if (b.getName().equals(buttonName)) {
                return b;
            }
        }
        return null;
    }

    public void draw() {
        for (Button b : buttonList) {
            drawRectTexture(b.getTexture(), b.getX(), b.getY(), b.getWidth(), b.getHeight());
        }
    }
}

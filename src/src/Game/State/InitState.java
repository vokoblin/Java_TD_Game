package src.Game.State;

import src.Game.Manager.StateManager;
import org.lwjgl.input.Mouse;
import static src.Game.Helper.Artist.*;
import org.newdawn.slick.opengl.Texture;
import src.Game.Frame;
import src.Game.Gfx.HUD;

/**
 *
 * @author Vovaxs
 */
public class InitState implements State {

    private Texture background;
    private HUD menuHUD;
    private final StateManager manager;
    
    private boolean LMBisDown;
    private boolean initialized = false;
    
    public InitState(StateManager manager) {
        this.manager = manager;
    }
    
    @Override
    public void init(Frame frame) {
        this.background = quickLoadTexture("bk");
        this.menuHUD = new HUD(frame);
        this.menuHUD.addButton("play", "play", Frame.WIDTH / 2 - 130, (int) (Frame.HEIGHT * 0.45f));
        this.menuHUD.addButton("level editor", "level editor", Frame.WIDTH / 2 - 130, (int) (Frame.HEIGHT * 0.45f) + 100);
        this.menuHUD.addButton("exit", "exit", Frame.WIDTH / 2 - 130, (int) (Frame.HEIGHT * 0.45f) + 200);
        this.initialized = true;
    }
    
    private void updateButtons() {
        if (Mouse.isButtonDown(0) && !LMBisDown) {
            if (this.menuHUD.isButtonClicked("play")) {
                this.manager.changeState(new InGameState());
            }
            if (this.menuHUD.isButtonClicked("level editor")) {
                this.manager.changeState(new LevelEditorState());
            }
            if (this.menuHUD.isButtonClicked("exit")) {
                System.exit(0);
            }
        }
        LMBisDown = Mouse.isButtonDown(0);
    }
    
    @Override
    public void update() {
        drawRectTexture(background, 0, 0, 1280, 640);
        menuHUD.draw();
        updateButtons();
    }
    
    @Override
    public boolean isInitialized() {
        return this.initialized;
    }
    
}

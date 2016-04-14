package Game;

import Game.Manager.StateManager;

/**
 *
 * @author Vovaxs
 */
class Game {
    
    private final Frame frame;
    private final StateManager gameState;
    
    public Game() {
        this.frame = new Frame();
        this.gameState = new StateManager(this.frame);
    }

    void update(float delta) {
        gameState.update();
    }

    void render() {
        
    }
    
}

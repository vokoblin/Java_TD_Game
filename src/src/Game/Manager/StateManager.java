package src.Game.Manager;

import src.Game.Frame;
import src.Game.State.InitState;
import src.Game.State.State;

/**
 *
 * @author Vovaxs
 */
public class StateManager {
    private final Frame frame;
    private State currentState;

    public StateManager(Frame frame){
        this.frame = frame;
        this.currentState = new InitState(this);
    }
    
    public void update() {
        if(!this.currentState.isInitialized()){
            this.currentState.init(this.frame);
        }else{
            this.currentState.update();
        }
    }
    
    public void changeState(State state){
        this.currentState = state;
    }
}

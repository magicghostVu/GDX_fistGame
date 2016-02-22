package stateMan;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class StateMan {
	State currentState;
	public StateMan(State s) {
		// TODO Auto-generated constructor stub
		currentState=s;
	}
	public void setState(State s){
		currentState=s;
	}
	void update(float dt){
		currentState.update(dt);
	}
	void render(SpriteBatch sb){
		currentState.render(sb);
	}
	public State getCurrentState(){
		return currentState;
	}
}

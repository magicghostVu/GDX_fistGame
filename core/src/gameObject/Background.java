package gameObject;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import stateMan.State;
import textureStatic.StaticTextute;

public class Background {
	Sprite bg;
	//Vector2 position;
	
	public Background() {
		bg=new Sprite(StaticTextute.bg);
		bg.setSize(State.W+5, State.H);
		//position=new Vector2();
		
	}
	
	public void setPosition(float x, float y){
		bg.setPosition(x, y);
	}
	
	public Sprite getSprite(){
		return bg;
	}
	
}

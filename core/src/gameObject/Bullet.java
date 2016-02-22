package gameObject;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import stateMan.State;
import textureStatic.StaticTextute;

public class Bullet {
	Sprite bSprite;
	float v=600;
	Vector2 position;
	public Rectangle bounds;
	
	public Bullet() {
		bSprite=new Sprite(StaticTextute.bullet);
		bSprite.setSize(StaticTextute.bullet.getWidth()/7f, StaticTextute.bullet.getHeight()/10f);
		position=new Vector2();
		bounds=new Rectangle(0,0, bSprite.getWidth(), bSprite.getHeight());
	}
	
	public Bullet(int x, int y){
		bSprite=new Sprite(StaticTextute.bullet);
		position=new Vector2(x,y);
		bounds=new Rectangle(x, y, bSprite.getWidth(), bSprite.getHeight());
	}
	public Sprite getBulletSprite(){
		return bSprite;
	}
	
	public float getVelocity(){
		return v;
	}
	public Vector2 getPosition(){
		return position;
	}
	public void update(float dt){
		float x=position.x;
		float y=position.y;
		
		y+=v*dt;
		
		
		position.set(x, y);
		
		bounds.setPosition(position);
	}
	public boolean isSeeAble(){
		return position.y < State.H;
	}
	public boolean colloides(Rectangle other){
		if(other==null){
			return false;
		}
		return bounds.overlaps(other);
	}
	
}

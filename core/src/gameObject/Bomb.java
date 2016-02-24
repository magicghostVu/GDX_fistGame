package gameObject;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import textureStatic.StaticTextute;

public class Bomb {
	Sprite bombSprite;
	Vector2 position;
	Rectangle bounds;
	float velocity=100;
	boolean isFalling=false;
	public Bomb(float x, float y) {
		// TODO Auto-generated constructor stub
		bombSprite = new Sprite(StaticTextute.bomb);
		bombSprite.setSize(20, StaticTextute.bomb.getHeight() / (StaticTextute.bomb.getWidth() / 20));
		position = new Vector2(x, y);
		bounds=new Rectangle(x, y, bombSprite.getWidth(), bombSprite.getHeight());
		
		bombSprite.setPosition(x, y);
	}
	
	
	
	public void update(float dt){
		
		if(isFalling==false) return;
		
		
		float y=position.y;
		y-=dt*velocity;
		position.set(position.x, y);
		
		
		bounds.setPosition(position.x, y);
	}
	public Rectangle getBounds() {
		return bounds;
	}



	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}



	public boolean isSeeable(){
		if(bombSprite.getY()<-bombSprite.getHeight()){
			return false;
		} 
		return true;
	}
	public Sprite getBombSprite() {
		return bombSprite;
	}
	public void setBombSprite(Sprite bombSprite) {
		this.bombSprite = bombSprite;
	}
	public boolean isFalling() {
		return isFalling;
	}
	public void setFalling(boolean isFalling) {
		this.isFalling = isFalling;
	}
	public Vector2 getPosition() {
		return position;
	}
	public void setPosition(Vector2 position) {
		this.position = position;
	}
	

}

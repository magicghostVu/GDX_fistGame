package gameObject;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import textureStatic.StaticTextute;

public class Enemy {
	//public static Sprite em[]=new Sprite[4];
	public Random r;//=new Random(System.nanoTime());
	
	Vector2 position;
	Sprite s;
	public Rectangle bounds;
	//Bomb bomb;
	
	boolean isDroping;
	//float velocity;
	
	float timeToSpawn=0;
	
	public Enemy(int i) {
		int d=i%4;
		
		
		s=new Sprite(StaticTextute.enemy[d]);
		s.setSize(100, 100);
		bounds=new Rectangle(0,0,100,100);
		position=new Vector2();
		
		
		//bomb=new Bomb(s.getX()+s.getWidth()/2, s.getY());
		//bomb.isFalling=false;
		
		
	}
	
	public void setPosition(float x, float y){
		position.set(x, y);
		bounds.setPosition(x, y);
		s.setPosition(x, y);
	}
	public Sprite getS() {
		return s;
	}
	public void setS(Sprite s) {
		this.s = s;
	}
	public Vector2 getPosition(){
		return position;
	}
	public Rectangle getBounds(){
		return bounds;
	}
	
	
	
}

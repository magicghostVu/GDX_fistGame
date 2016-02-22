package gameObject;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import textureStatic.StaticTextute;

public class Enemy {
	static Sprite em[]=new Sprite[4];
	public Random r;//=new Random(System.nanoTime());
	
	Vector2 position;
	Sprite s;
	public Rectangle bounds;
	
	//float velocity;
	static{
		em[0]=new Sprite(StaticTextute.em1);
		em[1]=new Sprite(StaticTextute.em2);
		em[2]=new Sprite(StaticTextute.em3);
		em[3]=new Sprite(StaticTextute.em4);
		for (int i = 0; i < em.length; i++) {
			em[i].setSize(100, 100);
		}
	}
	
	
	public Enemy(int i) {
		int d=i%4;
		s=em[d];
		bounds=new Rectangle(0,0,100,100);
		position=new Vector2();
		
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

package textureStatic;

import com.badlogic.gdx.graphics.Texture;

public class StaticTextute {
	
	public static Texture enemy[];
	static{
		enemy=new Texture[4];
		enemy[0]=new Texture("enemy.png");
		enemy[1]=new Texture("enemy2.png");
		enemy[2]=new Texture("enemy3.png");
		enemy[3]=new Texture("enemy4.png");
	}
	
	public static Texture plane=new Texture("plane.png");
	public static Texture bg=new Texture("night-sky-stars.jpg");
	public static Texture playBtn=new Texture("playBtn.png");
	public static Texture bullet=new Texture("bullet.png");
	
	
	
}

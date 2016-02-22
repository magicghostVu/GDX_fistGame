package gameObject;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

import textureStatic.StaticTextute;

public class Plane {
	
	static int MAX_BULLET=4;
	Bullet[] listBullet;
	boolean[] bulletReaddy=new boolean[4];
	boolean[] isRunning=new boolean[4];
	Sprite planeSprite;
	public float velocity=200;
	
	Rectangle bounds;
	
	public Sprite getSprite(){
		return planeSprite;
	}
	
	
	public Plane() {
		bounds=new Rectangle();
		
		planeSprite=new Sprite(StaticTextute.plane);
		planeSprite.setSize(StaticTextute.plane.getWidth()/2, StaticTextute.plane.getHeight()/2);
		
		bounds.setSize(planeSprite.getWidth(), planeSprite.getHeight());
		
		listBullet=new Bullet[4];
		for (int i = 0; i < listBullet.length; i++) {
			listBullet[i]=new Bullet();
			bulletReaddy[i]=true;
		}
		
		
		
	}
	public void shoot(){
		int i=0;
		for (; i < bulletReaddy.length; i++) {
			if(bulletReaddy[i]==true) break;
		}
		if(i==4){
			return;
		}else {
			//// shoot ......
			// có thể cho nó có vận tốc để chạy. 
			
			
			
			bulletReaddy[i]=false;
			System.out.println(i+" "+bulletReaddy[i]);
			System.out.println("Đã bắn");
			isRunning[i]=true;
			
			System.out.println(isRunning[i]);
			listBullet[i].getPosition().set(planeSprite.getX()+planeSprite.getWidth()/2,
					planeSprite.getY()+planeSprite.getHeight()/2);
			System.out.println(listBullet[i].isSeeAble()+" ");
		}
		
	}
	
	
	public boolean[] getBulletReaddy() {
		return bulletReaddy;
	}


	public void setBulletReaddy(boolean[] bulletReaddy) {
		this.bulletReaddy = bulletReaddy;
	}


	public void updateStateBullets(){
		
		for (int i = 0; i < listBullet.length; i++) {
			if(listBullet[i].isSeeAble()==false){
				bulletReaddy[i]=true;
				isRunning[i]=false;
			}
		}
	}


	public Bullet[] getListBullet() {
		return listBullet;
	}


	public void setListBullet(Bullet[] listBullet) {
		this.listBullet = listBullet;
	}


	public boolean[] getIsRunning() {
		return isRunning;
	}


	public void setIsRunning(boolean[] isRunning) {
		this.isRunning = isRunning;
	}
	public void keepBoundPosition(){
		bounds.setPosition(planeSprite.getX(), planeSprite.getY());
	}
	public boolean colloides(Rectangle other){
		if(other==null) return false;
		else {
			return bounds.overlaps(other);
		}
	}
	

}

package stateMan;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import gameObject.Background;
import gameObject.Bomb;
import gameObject.Enemy;
import gameObject.Plane;

public class PlayState extends State {
	// OrthographicCamera cam;
	Random r = new Random(System.nanoTime());
	float timeToDrop = 0f;
	Background bg;
	Background bg1;
	float v = 20f;
	float y1 = 0, y2 = 480;
	Plane plane;
	BitmapFont score, blood;

	Vector2 planePosition;
	int diem = 0;

	int hp = 5000;

	Enemy[] em = new Enemy[5];
	boolean emIsDead[] = new boolean[5];
	Bomb[] bombs = new Bomb[em.length];
	// Bullet c;

	public PlayState() {
		// TODO Auto-generated constructor stub
		score = new BitmapFont();
		blood = new BitmapFont();
		plane = new Plane();
		planePosition = new Vector2();
		bg = new Background();
		bg1 = new Background();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, State.W, State.H);
		camera.update();
		bg1.setPosition(0, y2);

		for (int i = 0; i < em.length; i++) {
			em[i] = new Enemy(i);
			em[i].setPosition(120 * (i) + 30, 300);
			bombs[i] = new Bomb(em[i].getS().getX() + em[i].getS().getWidth() / 2, em[i].getS().getY());
			bombs[i].setFalling(true);
		}

	}

	@Override
	public void handleInput() {
		float x = planePosition.x;
		float y = planePosition.y;

		float deltaTime = Gdx.graphics.getDeltaTime();
		if (Gdx.input.isKeyPressed(Input.Keys.W)) {
			y += plane.velocity * deltaTime;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.S)) {
			y -= plane.velocity * deltaTime;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			x -= plane.velocity * deltaTime;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.D)) {
			x += plane.velocity * deltaTime;
		}
		planePosition.set(x, y);

		if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
			plane.shoot();
			// System.out.println("Đã bắn");
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.G)) {
			//System.out.println(timeToDrop);
			
			
			System.out.println(bombs[0].getBounds().getY());
		}

	}

	@Override
	public void update(float deltaTime) {
		// TODO Auto-generated method stub

		int dead = 0;
		for (int i = 0; i < emIsDead.length; i++) {
			if (emIsDead[i] == true)
				dead++;
		}

		if (dead == 5) {
			State win = new WinState();
			win.setStateMan(gsm);
			gsm.setState(win);

		}

		if (hp <= 0) {
			State lost = new LostState();
			lost.setStateMan(gsm);
			gsm.setState(lost);
		}

		checkColloides(deltaTime);
		if (y1 < 0f - bg.getSprite().getHeight()) {
			y1 = 479;
		}
		if (y2 < -bg.getSprite().getHeight()) {
			y2 = 479;
		}
		// System.out.println(camera.position.y);
		y1 -= v * deltaTime;
		bg.setPosition(0, y1);

		y2 -= v * deltaTime;
		bg1.setPosition(0, y2);
		handleInput();
		plane.getSprite().setPosition(planePosition.x, planePosition.y);
		// for
		plane.updateStateBullets();
		plane.keepBoundPosition();
		for (int i = 0; i < plane.getListBullet().length; i++) {
			if (plane.getIsRunning()[i] == true) {
				plane.getListBullet()[i].update(deltaTime);
				plane.getListBullet()[i].getBulletSprite().setPosition(plane.getListBullet()[i].getPosition().x,
						plane.getListBullet()[i].getPosition().y);
			}
		}

		for (int i = 0; i < em.length; i++) {
			em[i].getS().setPosition(em[i].getPosition().x, em[i].getPosition().y);
			// bombs[i].setFalling(true);
			bombs[i].update(deltaTime);
			bombs[i].getBombSprite().setPosition(bombs[i].getPosition().x, bombs[i].getPosition().y);
			

		}

		for (int i = 0; i < em.length; i++) {
			if (emIsDead[i] == false) {
				if (plane.colloides(em[i].bounds)) {
					hp -= 1000 * deltaTime;
				}
			}
		}
		spawnBomb(deltaTime);

	}

	@Override
	public void render(SpriteBatch sb) {
		// TODO Auto-generated method stub
		sb.setProjectionMatrix(camera.combined);
		sb.begin();

		bg.getSprite().draw(sb);
		bg1.getSprite().draw(sb);

		plane.getSprite().draw(sb);

		// Bullet bs[]=
		for (int i = 0; i < plane.getListBullet().length; i++) {
			if (plane.getIsRunning()[i] == true) {
				plane.getListBullet()[i].getBulletSprite().draw(sb);
			}
		}
		for (int i = 0; i < em.length; i++) {

			if (emIsDead[i] == false) {
				em[i].getS().draw(sb);

				if (bombs[i].isFalling() == true) {
					bombs[i].getBombSprite().draw(sb);
				}

			}

		}

		// em[0].getS().getTexture();

		score.draw(sb, "Score: " + Integer.toString(diem), 20, 450);
		blood.draw(sb, "HP: " + Integer.toString(hp), 20, 420);

		/*
		 * Sprite tmp=new Sprite(StaticTextute.bomb);
		 * 
		 * tmp.setSize(20 ,StaticTextute.bomb.getHeight()/
		 * (StaticTextute.bomb.getWidth()/20));
		 * 
		 * tmp.translate(100, 100);
		 */
		// tmp.draw(sb);
		sb.end();
	}

	void checkColloides(float dt) {
		for (int i = 0; i < plane.getListBullet().length; i++) {
			for (int j = 0; j < em.length; j++) {

				if (plane.getListBullet()[i].colloides(em[j].getBounds())) {
					emIsDead[j] = true;
					diem += 100;
					em[j].bounds = null;
					System.out.println("Da trung");
				}
			}
		}
		for (int i = 0; i < bombs.length; i++) {
			if(plane.colloides(bombs[i].getBounds())){
				hp-=500*dt;
			}
		}
		
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setStateMan(StateMan gsm) {
		// TODO Auto-generated method stub
		this.gsm = gsm;
	}

	void spawnBomb(float dt) {
		int d=0;
		for (int i = 0; i < emIsDead.length; i++) {
			if(emIsDead[i]==true) d++;
			
		}
		if(d==5) return;
		if (timeToDrop >= 1f) {
			for (int i = 0; i < bombs.length; i++) {
				if(emIsDead[i]==true) continue;
				if (bombs[i].isSeeable() == false) {
					bombs[i].getPosition().set(em[i].getPosition().x, em[i].getPosition().y);
					bombs[i].setFalling(true);
					break;
				}
			}
			timeToDrop = 0;
		} else {
			timeToDrop += dt;
		}
		
		

	}

}

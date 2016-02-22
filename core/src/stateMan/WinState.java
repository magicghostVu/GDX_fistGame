package stateMan;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import gameObject.Background;

public class WinState extends State {
	Background bg;
	Background bg1;
	float v=20f;
	float y1=0, y2=480;
	String text ="YOU WIN";
	
	BitmapFont notice=new BitmapFont();
	public WinState() {
		// TODO Auto-generated constructor stub
		bg=new Background();
		bg1=new Background();
		camera=new OrthographicCamera();
		camera.setToOrtho(false, State.W, State.H);
		bg1.setPosition(0, y2);
	}
	@Override
	public void setStateMan(StateMan gsm) {
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(float deltaTime) {
		// TODO Auto-generated method stub
		if(y1<0f-bg.getSprite().getHeight()){
			y1=479;
		}
		if(y2<-bg.getSprite().getHeight()){
			y2=479;
		}
		//System.out.println(camera.position.y);
		y1-=v*deltaTime;
		bg.setPosition(0, y1);
		
		y2-=v*deltaTime;
		bg1.setPosition(0, y2);
	}

	@Override
	public void render(SpriteBatch sb) {
		// TODO Auto-generated method stub
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		bg.getSprite().draw(sb);
		bg1.getSprite().draw(sb);
		//btnPlay.draw(sb);
		//em.draw(sb);
		
		
		notice.draw(sb, text, State.W/2, State.W/2);
		
		sb.end();
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}

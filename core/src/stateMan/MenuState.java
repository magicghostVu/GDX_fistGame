package stateMan;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import gameObject.Background;
import textureStatic.StaticTextute;

public class MenuState extends State {
	Background bg;
	Background bg1;
	float v=20f;
	float y1=0, y2=480;
	Sprite btnPlay;
	//Sprite em;
	
	public MenuState() {
		gsm=new StateMan(this);
		bg=new Background();
		bg1=new Background();
		camera=new OrthographicCamera();
		camera.setToOrtho(false, State.W, State.H);
		bg1.setPosition(0, y2);
		btnPlay=new Sprite(StaticTextute.playBtn);
		btnPlay.setSize(StaticTextute.playBtn.getWidth()/2, StaticTextute.playBtn.getHeight()/2);
		btnPlay.setPosition(State.W/2-btnPlay.getWidth()/2, State.H/2-btnPlay.getHeight()/2);
		
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		
		
		if(Gdx.input.justTouched()){
			State playState=new PlayState();
			playState.setStateMan(gsm);
			gsm.setState(playState);
			//System.out.println("OKOK");
		}

	}

	@Override
	public void update(float deltaTime) {
		// TODO Auto-generated method stub
		///bg.setPosition(x, y);
		handleInput();
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
		
		//int x;
		
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		bg.getSprite().draw(sb);
		bg1.getSprite().draw(sb);
		btnPlay.draw(sb);
		//em.draw(sb);
		sb.end();
		
		
		
		
		

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setStateMan(StateMan gsm) {
		// TODO Auto-generated method stub
		this.gsm=gsm;
	}

}

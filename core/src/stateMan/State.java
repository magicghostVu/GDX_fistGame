package stateMan;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class State {
	
	public static int W=640;
	public static int H=480;
	
	OrthographicCamera camera;
	StateMan gsm;
	public abstract void setStateMan(StateMan gsm);
	public abstract void handleInput();
	public abstract void update(float deltaTime);// cập nhật các đối tượng mỗi deltaTime
	public abstract void render(SpriteBatch sb);// vẽ lại theo tọa độ đã cập nhật mỗi deltaTime
	public abstract void dispose();// giải phóng tài nguyên
}

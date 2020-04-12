import java.awt.Graphics2D;
import java.util.ArrayList;
/*
 *sets up logic for the different game states and when they'll be used 
 */

public class GameStateMang {
	private ArrayList<GS> states;
	public static Vector2f map;
	
	public static final int play = 0;
	public static final int menu = 1;
	public static final int pause = 2;
	public static final int GO = 3;
	
	public GameStateMang() {
		map = new Vector2f(GamePanel.width, GamePanel.height);
		Vector2f.setWorldVar(map.x, map.y);
		states = new ArrayList<GS>();
		
		states.add(new PlayState(this));
	}
	
	public void update() {
		Vector2f.setWorldVar(map.x, map.y);
		for(int i = 0; i < states.size(); i++) {
			states.get(i).update();
		}
	}
	
	public void pop(int state) {
		states.remove(state);
	}
	
	public void add(int state) {
		if(state == play) {
			states.add(new PlayState(this));
		}
		if(state == menu) {
			states.add(new MenuState(this));
		}
		if(state == pause) {
			states.add(new PauseState(this));
		}
		if(state == GO) {
			states.add(new GameOverState(this));
		}
	}
	
	public void addAndpop(int state) {
		states.remove(0);
		add(state);
	}
	
	public void input(KeyHandler key) {
		for(int i = 0; i < states.size(); i++) {
			states.get(i).input(key);
		}
	}
	
	public void render(Graphics2D g) {
		for(int i = 0; i < states.size(); i++) {
			states.get(i).render(g);
		}
	}
	
	
}

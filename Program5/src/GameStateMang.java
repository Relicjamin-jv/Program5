import java.awt.Graphics2D;
import java.util.ArrayList;
/*
 *sets up logic for the different game states and when they'll be used 
 */

public class GameStateMang {
	private GS states[];
	public static Vector2f map;

	public static final int play = 0;
	public static final int GW = 1;
	public static final int pause = 2;
	public static final int GO = 3;

	public static Font font;

	public int onTopState = 0;

	public GameStateMang() {
		map = new Vector2f(GamePanel.width, GamePanel.height);
		Vector2f.setWorldVar(map.x, map.y);

		font = new Font("ZeldaFont.png", 10 ,10);


		states = new GS[4];

		states[play] = new PlayState(this);

	}
	
	public boolean getState(int state) {
		return states[state] != null;
	}

	public void update() {
		for(int i = 0; i < states.length; i++) {
			if(states[i] != null) {
				states[i].update();
			}
		}
	}

	public void pop(int state) {
		states[state] = null;
	}

	public void add(int state) {
		if(states[state] != null) {
			return;
		}
		if(state == play) {
			states[play] = new PlayState(this);
		}
		if(state == GW) {
			states[GW] = new GameWonState(this);
		}
		if(state == pause) {
			states[pause] = new PauseState(this);
		}
		if(state == GO) {
			states[GO] = new GameOverState(this);
		}
	}

	public void addAndpop(int state) {
		addAndpop(state, 0);
	}

	public void addAndpop(int state, int remove) {
		pop(state);
		add(state);
	}

	public void input(KeyHandler key) {
		for(int i = 0; i < states.length; i++) {
			if(states[i] != null) {
				states[i].input(key);
			}
		}
	}

	public void render(Graphics2D g) {
		for(int i = 0; i < states.length; i++) {
			if(states[i] != null) {
				states[i].render(g);
			}
		}
	}


}

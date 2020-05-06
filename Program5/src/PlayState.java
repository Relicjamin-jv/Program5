import java.awt.Color;
import java.awt.Graphics2D;

public class PlayState extends GS{
	
	private player player;
	private Font font;
	private tileManager tm;
	protected static Vector2f map;
	private Enemy enemy;
	
	public PlayState(GameStateMang gsm) {
		super(gsm);
		map = new Vector2f();
		Vector2f.setWorldVar(map.x, map.y);
		font = new Font("ZeldaFont.png", 16, 16);

		
		tm = new tileManager("Game .xml");
		player = new player(new Objects("Dog.png"), new Vector2f(180, 173), 64);
		enemy = new Enemy(new Objects("blobSH.png" , 32, 32), new Vector2f(465, 368), 64);
	}
	
	public void update() {
		Vector2f.setWorldVar(map.x, map.y);
		player.update();
		enemy.update(player);
	}
	
	public void input(KeyHandler key) {
		key.escape.tick();
		player.input(key);
		
		if(key.escape.clicked) {
			if(gs.getState(GameStateMang.pause)) {
				gs.pop(GameStateMang.pause);
			}else {
				gs.add(GameStateMang.pause);
			}
		}
	}
	
	public void render(Graphics2D g) {
		tm.render(g);
		player.render(g);
		enemy.render(g);
	}

}

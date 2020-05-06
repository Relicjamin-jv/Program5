import java.awt.Color;
import java.awt.Graphics2D;

public class PlayState extends GS{
	
	private player player;

	private Font font;

	private tileManager tm;
	protected static Vector2f map;
	
	public PlayState(GameStateMang gsm) {
		super(gsm);
		map = new Vector2f();
		Vector2f.setWorldVar(map.x, map.y);

		player = new player(new Objects("dog.png"), new Vector2f((1280 / 2) - 64, (720 / 2) - 64), 32);
		font = new Font("ZeldaFont.png", 16, 16);

		tm = new tileManager("TileMap .xml");
		player = new player(new Objects("Dog.png"), new Vector2f((GamePanel.width / 2) - 32, (GamePanel.height / 2) - 32), 64);
	

	}
	
	public void update() {
		player.update();
	}
	
	public void input(KeyHandler key) {
		player.input(key);
		
	}
	
	public void render(Graphics2D g) {
		//g.setColor(Color.RED);
		//g.fillRect((1280 / 2) - 64, (720 / 2) - 64, 128, 128);
		tm.render(g);
		player.render(g);
	}

}

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
		font = new Font("ZeldaFont.png", 16, 16);

		
		tm = new tileManager("Game .xml");
		player = new player(new Objects("Dog.png"), new Vector2f((1280 / 2) - 64, (720 / 3) - 64), 64);
	}
	
	public void update() {
		Vector2f.setWorldVar(map.x, map.y);
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
		SpriteSheet.drawArray(g, font, "YOU WIN", new Vector2f((1280 / 2) - 64, (720 / 3) - 64), 64, 64, 32,0);
	}

}

import java.awt.Color;
import java.awt.Graphics2D;

public class PlayState extends GS{
	
	private player player;
	private tileManager tm;
	
	public PlayState(GameStateMang gsm) {
		super(gsm); 
		tm = new tileManager("TileMap .xml");
		player = new player(new Objects("Dog.png"), new Vector2f((1280 / 2) - 64, (720 / 2) - 64), 32);
	
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

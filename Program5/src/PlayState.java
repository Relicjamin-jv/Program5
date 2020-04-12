import java.awt.Color;
import java.awt.Graphics2D;

public class PlayState extends GS{
	
	public PlayState(GameStateMang gsm) {
		super(gsm); 
	}
	
	public void update() {
		
	}
	
	public void input(KeyHandler key) {
		if(key.up.down) {
			System.out.println("w");
		}
	}
	
	public void render(Graphics2D g) {
		g.setColor(Color.black);
		g.fillRect((1280 / 2) - 31, (720 / 2) - 31, 62, 62);
	}

}

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
		g.setColor(Color.RED);
		g.fillRect((1280 / 2) - 64, (720 / 2) - 64, 128, 128);
	}

}

 import java.awt.Graphics2D;
/*
 * reference GS
 */
public class GameWonState extends GS {
	
	private Font font;
	
	public GameWonState(GameStateMang gameStateMangager) {
		super(gameStateMangager);
		font = new Font("ZeldaFont.png", 16, 16);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void input(KeyHandler key) {
		key.escape.tick();
		if(key.escape.clicked) {
			System.exit(0);
		}

	}

	@Override
	public void render(Graphics2D g) {
		SpriteSheet.drawArray(g,font, "YOU WIN", new Vector2f((1280 / 2) - 64, (720 / 2) - 128), 64, 64, 32,0);
		SpriteSheet.drawArray(g,font, "Press Escape to Exit", new Vector2f((1000 / 2) - 128, (720 / 2) - 64), 64, 64, 32,0);


	}

}

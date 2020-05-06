import java.awt.Graphics2D;

public class GameOverState extends GS {
	
	private Font font;
	
	public GameOverState(GameStateMang gameStateMangager) {
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
		SpriteSheet.drawArray(g, font, "YOU LOST", new Vector2f((1280 / 2) - 64, (720 / 3) - 64), 64, 64, 32,0);

	}
	
	

}

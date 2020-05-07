import java.awt.Graphics2D;
/*
 * reference GS
 */
public class PauseState extends GS {
	
	public PauseState(GameStateMang gameStateMangager) {
		super(gameStateMangager);
	}

	@Override
	public void update() {
		System.out.println("PUASED");
	}

	@Override
	public void input(KeyHandler key) {
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub

	}

}

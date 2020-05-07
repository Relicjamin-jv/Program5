import java.awt.Graphics2D;

public abstract class GS {
	
	protected GameStateMang gs;
	
	public GS(GameStateMang gsm) {
		this.gs = gsm;
	}
	

	/*
	 * allows each state to update
	 */
	public abstract void update();
	/*
	 * allows each state to have inputs
	 */
	public abstract void input(KeyHandler key);
	/*
	 * allows each state to have the ability to render a image or text
	 */
	public abstract void render(Graphics2D g);
}

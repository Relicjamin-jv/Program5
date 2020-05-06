import java.awt.Graphics2D;

public abstract class GS {
	
	protected GameStateMang gs;
	
	public GS(GameStateMang gsm) {
		this.gs = gsm;
	}
	


	public abstract void update();
	public abstract void input(KeyHandler key);
	public abstract void render(Graphics2D g);
}

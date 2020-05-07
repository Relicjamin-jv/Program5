import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
/*
 * Reference Block
 */
public class HoleBlock extends Block {

	public HoleBlock(BufferedImage img, Vector2f pos, int w, int h) {
		super(img, pos, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean update(AABB p) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void render(Graphics2D g) {
		super.render(g);
		g.setColor(Color.green);
		g.drawRect((int) pos.getWorldVar().x, (int) pos.getWorldVar().y, w, h);
	}

}

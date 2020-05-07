import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
/*
 * reference block
 */
public class ObjBlock extends Block{

	public ObjBlock(BufferedImage img, Vector2f pos, int w, int h) {
		super(img, pos, w, h);
		// TODO Auto-generated constructor stub
	}

	
	public boolean update(AABB p) {
		// TODO Auto-generated method stub
		return true;
	}
	
	public void render(Graphics2D g) {
		super.render(g);
		//g.setColor(Color.WHITE);
		//g.drawRect((int) pos.getWorldVar().x, (int) pos.getWorldVar().y, w, h);
	}
	
}

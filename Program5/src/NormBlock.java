import java.awt.image.BufferedImage;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class NormBlock extends Block {

	public NormBlock(BufferedImage img, Vector2f pos, int w, int h) {
		super(img, pos, w, h);
	}
	
	

	@Override
	public boolean update(AABB p) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void render(Graphics2D g) {
		super.render(g);
	}
	
}

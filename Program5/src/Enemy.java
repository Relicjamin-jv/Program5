import java.awt.Color;
import java.awt.Graphics2D;

public class Enemy extends Entity{
	
	private AABB sense;
	private int radius;
	
	public Enemy(Objects sprite, Vector2f orgin, int size) {
		super(sprite, orgin, size);
		
		acc = 1f;
		maxSpeed = 3f;
		radius = 135;
		
		sense = new AABB(new Vector2f(orgin.x - size / 2, orgin.y - size / 2), radius, null);
	}
	
	public void update(AABB Player) {
		if(sense.colCircleBox(Player)) {
			System.out.println("Yep");
		}
	}



	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.green);
		g.drawRect((int) (pos.getWorldVar().x + bounds.getXOffset()), (int) (pos.getWorldVar().y + bounds.getYOffset()), (int) bounds.getWidth(), (int) bounds.getHeight());
		g.setColor(Color.blue);
		g.drawOval((int) (sense.getpos().getWorldVar().x), ((int) (sense.getpos().getWorldVar().y)), radius, radius);
		g.drawImage(ani.getImage(), (int) (pos.getWorldVar().x), (int) (pos.getWorldVar().y), size, size, null);
	}
}

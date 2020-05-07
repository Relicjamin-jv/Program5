import java.awt.Color;
import java.awt.Graphics2D;
/*
 * reference Entity for methods and their uses
 */
public class Enemy extends Entity{

	private AABB poison;
	private int radius;
	

	public Enemy(Objects sprite, Vector2f orgin, int size) {
		super(sprite, orgin, size);

		acc = 1f;
		maxSpeed = 2.5f;
		radius = 200;

		poison = new AABB(new Vector2f(orgin.x + size / 2 - radius / 2, orgin.y + size / 2 - radius / 2), radius, null);
	}
	private void move(player player) {
			if(pos.y > player.pos.y + 1) {
				dy -= acc;
				if(dy < -maxSpeed) {
					dy = -maxSpeed;
				}
			}else {
				if(dy < 0) {
					dy += deacc;
					if(dy > 0) {
						dy = 0;
					}
				}
			}
			if(pos.y < player.pos.y - 1) {
				dy += acc;
				if(dy > maxSpeed) {
					dy = maxSpeed;
				}
			}else {
				if(dy > 0) {
					dy -= deacc;
					if(dy < 0) {
						dy = 0;
					}
				}
			}
			if(pos.x > player.pos.x + 1) {
				dx -= acc;
				if(dx < -maxSpeed) {
					dx = -maxSpeed;
				}
			}else {
				if(dx < 0) {
					dx += deacc;
					if(dx > 0) {
						dx = 0;
					}
				}
			}
			if(pos.x < player.pos.x - 1) {
				dx += acc;
				if(dx > maxSpeed) {
					dx = maxSpeed;
				}
			}else {
				if(dx > 0) {
					dx -= deacc;
					if(dx < 0) {
						dx = 0;
					}
				}
			}
		}
	


	public void update(player player) {
		super.update();
		move(player);
		if(!poison.collisionTile(dx, 0)) {
			poison.getpos().x += dx;
			pos.x += dx;
		}
		if(!poison.collisionTile(0, dy)) {
			poison.getpos().y += dy;
			pos.y += dy;
		}
	}



	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.green);
		g.drawRect((int) (pos.getWorldVar().x + bounds.getXOffset()), (int) (pos.getWorldVar().y + bounds.getYOffset()), (int) bounds.getWidth(), (int) bounds.getHeight());
		g.setColor(Color.blue);
		g.drawOval((int) (poison.getpos().getWorldVar().x), ((int) (poison.getpos().getWorldVar().y)), radius, radius);
		g.drawImage(ani.getImage(), (int) (pos.getWorldVar().x), (int) (pos.getWorldVar().y), size, size, null);
	}
}

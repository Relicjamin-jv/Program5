import java.awt.Color;
import java.awt.Graphics2D;

public class Enemy extends Entity{

	private AABB sense;
	private int radius;
	

	public Enemy(Objects sprite, Vector2f orgin, int size) {
		super(sprite, orgin, size);

		acc = 1f;
		maxSpeed = 2.9f;
		radius = 200;

		sense = new AABB(new Vector2f(orgin.x + size / 2 - radius / 2, orgin.y + size / 2 - radius / 2), radius, null);
	}
	private void move(player player) {
		if(sense.colCircleBox(player.getBounds())) {
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
		}else {
			dx = 0;
			dy = 0;
		}
	}


	public void update(player player) {
		super.update();
		move(player);
		if(!sense.collisionTile(dx, 0)) {
			sense.getpos().x += dx;
			pos.x += dx;
		}
		if(!sense.collisionTile(0, dy)) {
			sense.getpos().y += dy;
			pos.y += dy;
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

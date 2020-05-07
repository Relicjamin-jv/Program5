import java.awt.Color;
import java.awt.Graphics2D;
/*
 * reference Entity
 */
public class player extends Entity{
	
	public boolean hits;

	public player(Objects sprite, Vector2f orgin, int size) {
		super(sprite, orgin, size);
		bounds.setHeight(20);
		bounds.setWidth(40);
		bounds.setXOffset(15);
		bounds.setYOffset(45);
	}

	
	public boolean getHits() {
		return this.hits;
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.blue);
		g.drawRect((int) (pos.getWorldVar().x + bounds.getXOffset()), (int) (pos.getWorldVar().y + bounds.getYOffset()), (int)bounds.getWidth(), (int) bounds.getHeight());
		g.drawImage(ani.getImage(), (int) (pos.getWorldVar().x), (int) (pos.getWorldVar().y), size, size, null);

	}

	public void update(Enemy e) {
		super.update();
		move();
		if(hit.collides(e.getBounds())) {
			hits = true;
		}
		if(!bounds.collisionTile(dx, 0)) {
		PlayState.map.x += dx;
		pos.x += dx;
		}
		if(!bounds.collisionTile(0, dy)) {
		PlayState.map.y += dy;
		pos.y += dy;
		}
	}
	
	

	public void input(KeyHandler key) {
		if(key.menu.down) {
			System.out.println("Player " + pos.x + " ..... " + pos.y );
		}

		if(key.up.down) {
			up = true;
		}else {
			up = false;
		}
		if(key.down.down) {
			down = true;
		}else {
			down = false;
		}
		if(key.right.down) {
			right = true;
		}else {
			right = false;
		}
		if(key.left.down) {
			left = true;
		}else {
			left = false;
		}
	}

	private void move() {
		if(up) {
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
		if(down) {
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
		if(left) {
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
		if(right) {
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

}

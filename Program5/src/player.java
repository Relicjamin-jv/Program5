import java.awt.Graphics2D;

public class player extends Entity{

	public player(Objects sprite, Vector2f orgin, int size) {
		super(sprite, orgin, size);
		
	}

	@Override
	public void render(Graphics2D g) {
		g.drawImage(ani.getImage(), (int) (pos.getWorldVar().x), (int) (pos.getWorldVar().y), size, size, null);

	}

	public void update() {
		super.update();
		move();
		PlayState.map.x += dx;
		PlayState.map.y += dy;
		pos.x += dx;
		pos.y += dy;
	}

	public void input(KeyHandler key) {
		if(key.enter.down) {
			System.out.println("Player " + pos.x + pos.y );
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

	public void move() {
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

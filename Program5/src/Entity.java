import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class Entity {
	
	private final int IDLE = 0;
	private final int UP = 1;
	private final int DOWN = 1;
	private final int RIGHT = 1;
	private final int LEFT = 2;
	protected int currentAnimation;

	protected Animation ani;
	protected Objects sprite;
	protected Vector2f pos;
	protected int size;
	protected AABB hit;
	protected AABB bounds;

	protected boolean up;
	protected boolean down;
	protected boolean right;
	protected boolean left;
	protected boolean idle = true;
	protected float dx;
	protected float dy;
	protected float maxSpeed = 3f;
	protected float acc = 1f;
	protected float deacc = .5f;

	public Entity(Objects sprite, Vector2f orgin, int size) {
		this.sprite = sprite;
		pos = orgin;
		this.size = size;

		bounds = new AABB(orgin, size, size);
		hit  = new AABB(new Vector2f(orgin.x + (size/2), orgin.y), size, size);

		ani = new Animation();
		setAnimation(RIGHT, sprite.getSpriteArray(RIGHT), 10);
	}

	public void setAnimation(int i, BufferedImage[] frames, int delay) {
		currentAnimation = i;
		ani.setFrames(frames);
		ani.setDelay(delay);
	}

	public void animate() {
		if(right) {
			if(currentAnimation != RIGHT || ani.getDelay() == -1) {
				setAnimation(RIGHT, sprite.getSpriteArray(RIGHT), 5);
			}
		}

		else if(left) {
			if(currentAnimation != LEFT || ani.getDelay() == -1) {
				setAnimation(LEFT, sprite.getSpriteArray(LEFT), 5);
			}
		}

		else if(up) {
			if(currentAnimation != UP || ani.getDelay() == -1) {
				setAnimation(UP, sprite.getSpriteArray(UP), 5);
			}
		}
		else if(idle) {
			if(currentAnimation != IDLE || ani.getDelay() == -1) {
				setAnimation(IDLE, sprite.getSpriteArray(IDLE), 5);
			}
		}
		else if(down) {
			if(currentAnimation != DOWN || ani.getDelay() == -1) {
				setAnimation(DOWN, sprite.getSpriteArray(DOWN), 5);
			}
		}
		else {
			setAnimation(currentAnimation, sprite.getSpriteArray(currentAnimation), -1);
		}

	}

	public void setHitBoxDirection(){
		if(up) {
			hit.setYOffset(-size/2);
			hit.setXOffset(-size/2);
		}
		else if(down) {
			hit.setYOffset(size/2);
			hit.setXOffset(-size / 2);
		}
		if(left) {
			hit.setXOffset(-size);
			hit.setYOffset(0);
		}
		if(right) {
			hit.setXOffset(0);
			hit.setYOffset(0);
		}
	}

	public void update() {
		animate();
		setHitBoxDirection();
		ani.update();
	}

	public abstract void render(Graphics2D g);

	public void input(KeyHandler key) {

	}

	public int getSize() {
		return size;
	}
	public Animation getAnimation() {
		return ani;
	}
	public void setSprite(Objects sprite) {
		this.sprite = sprite;
	}
	public void setSize(int i) {
		 size  =  i;
	}
	public void setMaxSpeed(float f) {
		maxSpeed = f;
	}
	public void setAcc(float f) {
		acc = f;
	}
	public void setDeacc(float f) {
		deacc = f;
	}
	public AABB getBounds() {
		return bounds;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

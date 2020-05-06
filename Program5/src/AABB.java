/*
 * hit detection
 */
public class AABB {
	
	private Vector2f pos;
	private float w;
	private float h;
	private float r;
	private int size;
	private float xOffset = 0;
	private float yOffset = 0;
	private Entity e;
	public AABB(Vector2f pos, int w, int h) {
		this.pos = pos;
		this.w = w;
		this.h = h;
		
		size = Math.max(w, h);
	}
	
	public AABB(Vector2f pos, int r, Entity e) {
		this.pos = pos;
		size = r;
		this.r = r;
	}
	
	public Vector2f getpos() {
		return pos;
	}
	public float getRadius() {
		return r;
	}
	public float getWidth() {
		return w;
	}
	public float getHeight() {
		return h;
	}
	
	public void setBox(Vector2f pos, int w, int h) {
		this.pos = pos;
		this.w = w;
		this.h = h;
		size = Math.max(w, h);
	}
	
	public void setCircle(Vector2f pos, int r) {
		this.pos = pos;
		this.r = r;
		
		size = r;
	}
	
	public void setWidth(float f) {
		w = f;
	}
	public void setHeight(float f) {
		h = f;
	}
	
	public void setXOffset(float f) {
		xOffset = f;
	}
	public void setYOffset(float f) {
		yOffset = f;
	}
	public boolean collides(AABB bBox) {
		float ax = ((pos.getWorldVar().x + (xOffset)) + (w / 2));
		float ay = ((pos.getWorldVar().y + (yOffset)) + (h / 2));
		float bx = ((bBox.pos.getWorldVar().x) + (bBox.xOffset / 2) + (w / 2));
		float by = ((bBox.pos.getWorldVar().y) + (bBox.yOffset / 2) + (h / 2));
		
		if(Math.abs(ax - bx) < (this.w / 2) + (bBox.w) / 2) {
			if(Math.abs(ay - by) < (this.h / 2) + (bBox.h / 2)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean colCircleBox(AABB aBox) {
		
		float dx = Math.max(aBox.getpos().getWorldVar().x + aBox.getXOffset(), Math.min(pos.getWorldVar().x + (r/2), aBox.getpos().getWorldVar().x + aBox.getXOffset() + aBox.getWidth()));
		float dy = Math.max(aBox.getpos().getWorldVar().y + aBox.getYOffset(), Math.min(pos.getWorldVar().y + (r/2), aBox.getpos().getWorldVar().y + aBox.getYOffset() + aBox.getHeight()));
		
		dx = pos.getWorldVar().x + (r/2) - dx;
		dy = pos.getWorldVar().y + (r/2) - dy;
		
		if(Math.sqrt(dx * dx + dy * dy) < r / 2) {
			return true;
		}
		return false;
	}

	
	public boolean collisionTile(float ax, float ay) {
		for(int i = 0; i < 4; i++) {
			int xt = (int) ((pos.x + ax) + (i%2) * w + xOffset) /50;
			int yt = (int) ((pos.y + ay) + ((int) ( i / 2)) * h + yOffset) /50;
			
			if(TileMapObj.tmo_blocks.containsKey(String.valueOf(xt) + "," + String.valueOf(yt))) {
				return TileMapObj.tmo_blocks.get(String.valueOf(xt) + "," + String.valueOf(yt)).update(this);
			}
		}
		return false;
	}
	public float getXOffset() {
		return xOffset;
	}
	public float getYOffset() {
		return yOffset;
	}
	
	
}

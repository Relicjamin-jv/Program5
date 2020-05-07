/*
 * sets up sprites and the abilty to use them, does include the font at the end just in case
 */


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.imageio.ImageIO;
/*
 * inits all the sprites that are going to be used.
 */
public class Objects {

	private BufferedImage SPRITESHEET = null;
	private BufferedImage[][] sprites;
	private final int TILE_SIZE = 32;
	public int w;
	public int h;
	private int wSprite;
	private int hSprite;
	
	public static Font CurrentFont;
	/*
	 * the constuctor of the objects class
	 */
	public Objects(String file) {
		w = TILE_SIZE;
		h = TILE_SIZE;

		System.out.println("Loading: " + file);
		SPRITESHEET = loadSprite(file);

		wSprite = SPRITESHEET.getWidth() / w;
		hSprite = SPRITESHEET.getHeight() / h; 
		loadSpriteArray();

	}

	public Objects(String file, int w, int h) {
		this.w = w;
		this.h = h;

		System.out.println("Loading" + file);
		SPRITESHEET = loadSprite(file);

		wSprite = SPRITESHEET.getWidth() / w;
		hSprite = SPRITESHEET.getHeight() / h; 
		loadSpriteArray();
	}

	public void setSize(int width, int height) {
		setWidth(width);
		setHeight(height);
	}

	public void setWidth(int i) {
		w = i;
		wSprite = SPRITESHEET.getWidth() / w;
	}

	public void setHeight(int i) {
		h = i;
		hSprite = SPRITESHEET.getHeight() / h;
	}

	public int getWidth() {
		return w;
	}

	public int getHeight() {
		return h;
	}
/*
 * loads the sprite in 
 */
	private BufferedImage loadSprite(String file) {
		BufferedImage sprite = null;
		try {
			sprite = ImageIO.read(getClass().getClassLoader().getResourceAsStream(file));

		}catch(Exception e) {
			System.out.println("ERROR: Couldn't load the file: " + file);
		}
		return sprite;
	}
/*
 * starts loading the sprite into an array
 */
	public void loadSpriteArray() {
		sprites = new BufferedImage[hSprite][wSprite];
		
		for(int y = 0; y < hSprite; y++) {
			for(int x = 0; x < wSprite; x++) {
				sprites[y][x] = getSprite(x, y);
			}
		}
	}

	public BufferedImage getSpriteSheet() {
		return SPRITESHEET;
	}
	public BufferedImage getSprite(int x, int y) {
		return SPRITESHEET.getSubimage(x * w, y * h , w, h);
	}

	public BufferedImage[] getSpriteArray(int i) {
		return sprites[i];
	}
	public BufferedImage[][] getSpriteArray2(int i){
		return sprites;
	}
/*
 * draws the array
 */
	public static void drawArray(Graphics2D g, ArrayList<BufferedImage> img, Vector2f pos, int width, int height, int xOffset, int yOffset ) {
		float x= pos.x;
		float y = pos.y;

		for(int i = 0; i < img.size(); i++) {
			if(img.get(i) != null) {
				g.drawImage(img.get(i), (int) x, (int) y, width, height, null);

			}
			x += xOffset;
			y += yOffset;
		}
	}

	/*public static void drawArray(Graphics2D g, Font f, String word, Vector2f pos, int width, int height, int xOffset, int yOffset) {
		float x = pos.x;
		float y = pos.y;

		for(int i = 0; i < word.length(); i++) {
			if(word.charAt(i) != 32) {
				g.drawImage(f.getFont(word.charAt(i)), (int) x, (int) y, width, height, null);
			}
		}
	x =+ xOffset;
	y += yOffset;
	 */
}

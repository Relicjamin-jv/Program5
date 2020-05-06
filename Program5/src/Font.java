import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Font {
	private BufferedImage FONTSHEET = null;
	private BufferedImage[][] fontArray;
	private final int TILE_SIZE = 32;
	public int w;
	public int h;
	private int wLetter;
	private int hLetter;
	//private String file;

	public static Font currentFont;

	public Font(String file) {
	        //this.file = file;
	        w = TILE_SIZE;
	        h = TILE_SIZE;

	        System.out.println("Loading: " + file + "...");
	        FONTSHEET = loadFont(file);

	        wLetter = FONTSHEET.getWidth() / w;
	        hLetter = FONTSHEET.getHeight() / h;
	        loadFontArray();
	    }

	public Font(String file, int w, int h) {
	        this.w = w;
	        this.h = h;

	        System.out.println("Loading: " + file + "...");
	        FONTSHEET = loadFont(file);

	        wLetter = FONTSHEET.getWidth() / w;
	        hLetter = FONTSHEET.getHeight() / h;
	        loadFontArray();
	        
	    }

//	public SpriteSheet(String file, int w, int h) {
//	        this.w = w;
//	        this.h = h;
//	        this.file = file;
//
//	        System.out.println("Loading: " + file + "...");
//	        SPRITESHEET = new Sprite(loadSprite(file));
//
//	        wSprite = SPRITESHEET.image.getWidth() / w;
//	        hSprite = SPRITESHEET.image.getHeight() / h;
//	        loadSpriteArray();
//	    }

	public void setSize(int width, int height) {
		setWidth(width);
		setHeight(height);
	}

	public void setWidth(int i) {
		w = i;
		wLetter = FONTSHEET.getWidth() / w;
	}

	public void setHeight(int i) {
		h = i;
		hLetter = FONTSHEET.getHeight() / h;
	}

	public int getWidth() {
		return w;
	}

	public int getHeight() {
		return h;
	}

	public int getRows() {
		return hLetter;
	}

	public int getCols() {
		return wLetter;
	}

	public int getTotalTiles() {
		return wLetter * hLetter;
	}

//	public String getFilename() {
//		return file;
//	}

	private BufferedImage loadFont(String file) {
		BufferedImage font = null;
		try {
			font = ImageIO.read(getClass().getClassLoader().getResourceAsStream(file));
		} catch (Exception e) {
			System.out.println("ERROR: could not load file: " + file);
		}
		return font;
	}

	public void loadFontArray() {
		fontArray = new BufferedImage[hLetter][wLetter];

		for (int y = 0; y < hLetter; y++) {
			for (int x = 0; x < wLetter; x++) {
				fontArray[y][x] = getLetter(x, y);
			}
		}
	}

//	public void setEffect(Font.effect e) {
//		FONTSHEET.setEffect(e);
//	}

	public BufferedImage getFontSheet() {
		return FONTSHEET;
	}

//	public BufferedImage getSprite(int x, int y) {
//		return FONTSHEET.getSubimage(x * w, y * h, w, h);
//	}

	public BufferedImage getLetter(int x, int y) {
		return FONTSHEET.getSubimage(x * w, y * h, w, h);
	}

	public BufferedImage getFont(char letter) {
		int value = letter - 65;
		
		int x = value % wLetter;
		int y = value / hLetter;
			
		return FONTSHEET.getSubimage(x, y, w, h);
	}
	
//	public BufferedImage getLetter(int x, int y, int w, int h) {
//		return FONTSHEET.getSubimage(x * w, y * h, w, h);
//	}

//	public BufferedImage getSubimage(int x, int y, int w, int h) {
//		return FONTSHEET.getSubimage(x, y, w, h);
//	}

}


import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Font {
	private BufferedImage FONTSHEET = null;
	private BufferedImage[][] fontArray;
	public int w;
	public int h;
	private int wLetter;
	private int hLetter;

	public static Font currentFont;

	public Font(String file, int w, int h) {
	        this.w = w;
	        this.h = h;

	        System.out.println("Loading: " + file + "...");
	        FONTSHEET = loadFont(file);

	        wLetter = FONTSHEET.getWidth() / w;
	        hLetter = FONTSHEET.getHeight() / h;
	        loadFontArray();        
	    }

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

	public BufferedImage getLetter(int x, int y) {
		return FONTSHEET.getSubimage(x * w, y * h, w, h);
	}

	public BufferedImage getFont(char letter) {
		int value = letter - 65;
		
		int x = value % wLetter;
		int y = value / wLetter;
			
		return getLetter(x,y);
	}
}


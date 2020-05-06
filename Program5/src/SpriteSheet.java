import java.awt.Graphics2D;

public class SpriteSheet {
	public static Font currentFont;

	public static void drawArray(Graphics2D g, Font f, String word, Vector2f pos, int width, int height, int xOffset, int yOffset) {
		float x = pos.x;
		float y = pos.y;
		currentFont = f;

		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) != 32)
				g.drawImage(f.getFont(word.charAt(i)), (int) x, (int) y, width, height, null);

			x += xOffset;
			y += yOffset;
		}

	}
}

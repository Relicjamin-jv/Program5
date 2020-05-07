import java.awt.Graphics2D;
import java.util.ArrayList;
/*
 * makes the tiles that you can walk on walkable
 */
public class TileMapNorm extends TileMap {
	
	private ArrayList<Block> blocks;
	
	
	public TileMapNorm(String data, Objects sprite, int width, int height,int tileWidth, int tileHeight, int tileCol) {
		blocks = new ArrayList<Block>();
		
		String[] block = data.split(",");
		for(int i = 0; i < (width * height); i++) {
			int temp = Integer.parseInt(block[i].replaceAll("\\s+", ""));
			if(temp != 0) {
				blocks.add(new NormBlock(sprite.getSprite((int) ((temp - 1) % tileCol), (int) ((temp - 1)) / tileCol),new Vector2f((int) (i % width) * tileWidth, (int) ( i /height) * tileHeight),tileWidth, tileHeight));
			}
			
		}
	}
	
	public void render(Graphics2D g) {
		for(int i =  0; i < blocks.size(); i++) {
			blocks.get(i).render(g);
		}
	}
	
}

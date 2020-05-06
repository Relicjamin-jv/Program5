import java.io.File;

import java.util.ArrayList;

import java.awt.Graphics2D;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public class tileManager {

	public static ArrayList<TileMap> tm;
	private int columns;
	private String file;
	
	public tileManager() {
		tm = new ArrayList<TileMap>();

	}

	public tileManager(String p) {
		tm = new ArrayList<TileMap>();
		addTileMap(p, 80, 80);
	}

	private void addTileMap(String p, int bw, int bh) {
		String imageP;
		int w = 0;
		int h = 0;
		int tileW;
		int tileH;
		int tileCount;
		int tileCol;
		int layers = 0;
		Objects sprite;

		String[] data = new String[10];

		  try {
	            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder builder = builderFactory.newDocumentBuilder();
				Document doc = builder.parse(new File(getClass().getClassLoader().getResource(p).toURI()));
	            doc.getDocumentElement().normalize();

	            NodeList list = doc.getElementsByTagName("tileset");
	            Node node = list.item(0);
	            Element eElement = (Element) node;

	            imageP = eElement.getAttribute("name");
	            tileW = Integer.parseInt(eElement.getAttribute("tilewidth"));
	            tileH = Integer.parseInt(eElement.getAttribute("tileheight"));
	            tileCol = Integer.parseInt(eElement.getAttribute("columns"));
	            
	            this.columns = tileCol;
	            this.file = imageP;
	            sprite = new Objects(imageP + ".png", tileW, tileH);

	            list = doc.getElementsByTagName("layer");
	            layers = list.getLength();

	            for(int i = 0; i < layers; i++) {
	                node = list.item(i);
	                eElement = (Element) node;
	                if(i <= 0) {
	                    w = Integer.parseInt(eElement.getAttribute("width"));
	                    h = Integer.parseInt(eElement.getAttribute("height"));
	                }

	                data[i] = eElement.getElementsByTagName("data").item(0).getTextContent();

	                if(i >= 1) {
	                    tm.add(new TileMapNorm(data[i], sprite, w, h, bw, bh, tileCol));
	                } else {
	                    tm.add(new TileMapObj(data[i], sprite, w, h, bw, bh, tileCol));
	                }
	            }

	           
	        } catch(Exception e) {
	            System.out.println("ERROR: can not read tilemap:");
	            e.printStackTrace();
	            System.exit(0);
	        }
		
		

	}
	
	public void render(Graphics2D g) {
		for(int i = 0; i < tm.size(); i++) {
			tm.get(i).render(g);
		}
	}

}

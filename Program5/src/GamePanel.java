import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

/*
 * Collin - Make the panel for Window Class to call from, sets the height and width of the panel, with input being allowed.
 */
public class GamePanel extends JPanel implements Runnable{

	public static int width;
	public static int height;

	private Thread thread;
	private boolean running = false;
	private BufferedImage img;
	private Graphics2D g;
	private KeyHandler key;
	private GameStateMang gsm;

	/*
	 * Constructure for gamepanel
	 */
	public GamePanel(int width, int height) {
		this.width = width;
		this.height = height;
		setPreferredSize(new Dimension(width, height)); //makes resolution of the JPanel.
		setFocusable(true);
		requestFocus(); //allow input as soon a the Jframe is made.
	}
	/*
	 * allow for keyboard input
	 */
	@Override
	public void addNotify() {
		super.addNotify(); //inputs for the keyboard and mouse.

		if(thread == null) {
			thread = new Thread(this, "GameThread");
			thread.start();
		}
	}
	/*
	 * init the game with buffered image and graphics.
	 */
	public void init() {
		running = true;

		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		g = (Graphics2D) img.getGraphics(); // we use g to draw the image to the screen not g2. g -> img -> g2.

		
		key = new KeyHandler(this);
		
		gsm = new GameStateMang();
	}

	/*
	 * creates the game loop
	 * Collin -  Ummmm game loops yeah there fun and all/
	 * This is a FIXED one, meaning that there might be an issue with rendering and updates but to counteract that I have this set up to 
	 * render 5 times more than the render happens. Hopefully deleting the issue to another time.
	 */
	public void run() {
		init();
		
		final double GAMEHZ = 60.0; //sets target game hz.
		final double TBU = 1000000000 / GAMEHZ; //time before upadate
		
		final int MUBR = 5; //Must upadate before render of img.
		
		double lastUpdateTime = System.nanoTime(); // 1*10^-9;
		double lastRenderTime;
		
		final double TARGETF = 60.0; //sets target frame rate
		final double TTBR = 1000000000 / TARGETF; // total time before render 
		
		int frame = 0; //count of how many frames were done
		int lastSecondTime = (int) (lastUpdateTime / 1000000000 );
		int oldFrameCount = 0;
		
		while(running) {
			double now = System.nanoTime();
			int updateCount = 0;
			while(((now - lastUpdateTime) > (TBU)) && (updateCount < MUBR)){//set up an render before and update and allow it to update
				update();
				input(key);
				lastUpdateTime += TBU; //last time it update in terms of ns;
				updateCount++;//it Updated so add it y'know;
			}
			/*
			 * grabs in terms of ns but with the idea of a lower number instead of billions of ns.
			 */
			if(now - lastUpdateTime > TBU) {
				lastUpdateTime = now - TBU;
			}
			
			input(key);
			render();
			draw();
			lastRenderTime = now;
			frame++;
			
			
			int thisSecond = (int) (lastUpdateTime / 1000000000);
			if(thisSecond > lastSecondTime) {
				if(frame != oldFrameCount) {
					 System.out.println("NEW SECOND " + thisSecond + " " + frame);
					 oldFrameCount = frame;
				}
				frame = 0;
				lastSecondTime = thisSecond;
			}
			
			while(now - lastRenderTime < TTBR && now - lastUpdateTime < TBU ) {
				Thread.yield();
				
				try {
					Thread.sleep(1); //I think this lets the CPU rest for 1 milsec
				}
				catch(Exception e){
					System.out.println("ERROR: yield thread");
				}
				now = System.nanoTime();
			}
		}
	}
	
	public void input(KeyHandler key) {
		gsm.input(key);
	}
	
	
	public void update() {
		gsm.update();
	}
	
	public void render() {
		if(g != null) {
			g.setColor(new Color(44, 134, 244)); //set the backround color
			g.fillRect(0, 0, this.width, this.height); //set the backround color
			gsm.render(g);
		}
	}
	/*
	 * Draws the image to the screen
	 */
	public void draw() {
		Graphics g2 = (Graphics) this.getGraphics();
		g2.drawImage(img, 0, 0, this.width, this.height, null);
		g2.dispose(); //Disposes of the images, or we would have a ghost effect of images.
	}



}

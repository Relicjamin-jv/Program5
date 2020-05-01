import java.awt.image.BufferedImage;

public class Animation {
	
	private BufferedImage[] frames;
	private int cFrame;
	private int nFrame;
	
	private int count;
	private int delay;
	
	private int timesPlayed;
	
	public Animation(BufferedImage[] frames) {
		timesPlayed = 0;
		setFrames(frames);
	}
	public Animation() {
		timesPlayed = 0;
	}
	
	public void setFrames(BufferedImage[] frames) {
		this.frames = frames;
		cFrame = 0;
		count = 0;
		timesPlayed = 0;
		delay = 2;
		nFrame = frames.length;
		
	}
	
	public void setDelay(int i) {
		delay = i;
	}
	public void setFrame(int i) {
		cFrame = i;
	}
	public void setFrames(int i) {
		nFrame = i;
	}
	
	public int getDelay() {
		return delay;
	}
	public int getFrame() {
		return cFrame;
	}
	public int getFrames() {
		return nFrame;
	}
	
	public void update() {
		if(delay == -1) {
			return;
		}
		
		count++;
		
		if(count == delay) {
			cFrame++;
			count = 0;
		}
		if(cFrame == nFrame) {
			cFrame = 0;
			timesPlayed++;
		}
	}
	
	public BufferedImage getImage() {
		return frames[cFrame];
	}
	public boolean hasPlayedOnce() {
		return timesPlayed > 0;
	}
	public boolean hasPlayed(int i) {
		return timesPlayed == i;
	}
}

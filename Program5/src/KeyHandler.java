/*
 * Credit to TheZeroDoctor
 * https://www.youtube.com/watch?v=VBk9RHnLVkg
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

/*
 * handles the keys and interaction between the user and the keyboard
 */
public class KeyHandler implements KeyListener {
	
	public static List<Key> keys = new ArrayList<Key>();
	/*
	 * Another class inside a class, allow the tracking of clicking the key(toggle) and holding it down.
	 */
	public class Key{
		public int presses, absorbs;
		public boolean down, clicked;
		
		public Key() {
			keys.add(this);
		}
		
		public void toggle(boolean pressed) {
			if(pressed != down) {
				down = pressed;
			}
			if(pressed) {
				presses++;
			}
		}
		
		public void tick() {
			if(absorbs < presses) {
				absorbs++;
				clicked = true;
			}else {
				clicked = false;
			}
		}
	}
	/*
	 * assortment of keys being used
	 */
	public Key up = new Key();
	public Key down = new Key();
	public Key left = new Key();
	public Key right = new Key();
	public Key attack = new Key();
	public Key menu = new Key();
	public Key enter = new Key();
	public Key escape = new Key();
	
	/*
	 * resets the key being pushed
	 */
	public void releaseAll() {
		for(int i = 0; i < keys.size(); i++) {
			keys.get(i).down = false;
		}
	}
	/*
	 * A method that waits for the key to be pressed
	 */
	public void tick() {
		for(int i = 0; i < keys.size(); i++) {
			keys.get(i).tick();
		}
	}
	/*
	 * 
	 */
	public KeyHandler(GamePanel game) {
		game.addKeyListener(this);
	}
	
	public void toggle(KeyEvent e, boolean pressed) {
		if(e.getKeyCode() == KeyEvent.VK_W) up.toggle(pressed);
		if(e.getKeyCode() == KeyEvent.VK_S) down.toggle(pressed);
		if(e.getKeyCode() == KeyEvent.VK_A) left.toggle(pressed);
		if(e.getKeyCode() == KeyEvent.VK_D) right.toggle(pressed);
		if(e.getKeyCode() == KeyEvent.VK_SPACE) attack.toggle(pressed);
		if(e.getKeyCode() == KeyEvent.VK_E) menu.toggle(pressed);
		if(e.getKeyCode() == KeyEvent.VK_ENTER) enter.toggle(pressed);
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) escape.toggle(pressed);
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		toggle(e, true);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		toggle(e, false);
		
	}

	@Override
	public void keyTyped(KeyEvent ae) {
		//nth
		
	}
	
}

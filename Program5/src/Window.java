import javax.swing.JFrame;


/*
 * Going to create the window for the game to be projected on.
 * Collin - Worked on this a bit on 4/10/20, thought to get ahead on the GUI.
 */
public class Window extends JFrame{
	
	
	public Window() {
		setTitle("From Private Dan");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(new GamePanel(1280, 720)); // get the window to be the resolution desired 
		pack(); //compacts the window
		setLocationRelativeTo(null);
		setVisible(true);
	}
}

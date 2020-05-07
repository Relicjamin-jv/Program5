import java.awt.Color;
import java.awt.Graphics2D;
/*
 * reference GS
 */
public class PlayState extends GS {

	private player player;
	private Font font;
	private tileManager tm;
	protected static Vector2f map;
	private Enemy enemy;
	private boolean lost = true;


	public PlayState(GameStateMang gsm) {
		super(gsm);
		map = new Vector2f();
		Vector2f.setWorldVar(map.x, map.y);
		font = new Font("ZeldaFont.png", 16, 16);


		tm = new tileManager("Game.xml");
		player = new player(new Objects("Dog.png"), new Vector2f((1280 / 2) - 32 , (720/2) - 32), 64);
		enemy = new Enemy(new Objects("blobSH.png" , 32, 32), new Vector2f(465, 368), 64);
	}

	public void update() {
		Vector2f.setWorldVar(map.x, map.y);
		if(lost == true) {
			player.update(enemy);
		}
		enemy.update(player);
		if(lost == true) {
			if(player.getHits() == true) {
				if(gs.getState(GameStateMang.GO)) {
					gs.pop(GameStateMang.GO);
				}else {
					gs.add(GameStateMang.GO);
				}
				lost = false;
			}
		}
	}

	public void input(KeyHandler key) {
		key.escape.tick();
		key.enter.tick();
		player.input(key);

		if(key.escape.clicked) {
			System.exit(0);
		}
		if(player.pos.x < 2345 && player.pos.x > 2140 && player.pos.y < 384 && player.pos.y > 55 && key.enter.clicked) {
			if(gs.getState(GameStateMang.GW)) {
				gs.pop(GameStateMang.GW);
			}else {
				gs.add(GameStateMang.GW);
			}
		}
	}


	public void render(Graphics2D g) {
		tm.render(g);
		player.render(g);
		enemy.render(g);
	}


}

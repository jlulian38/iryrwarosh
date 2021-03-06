package iryrwarosh.screens;

import iryrwarosh.Creature;
import iryrwarosh.World;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

public class JumpScreen implements Screen {
	private Screen previous;
	private World world;
	private Creature player;
	
	public JumpScreen(Screen previous, World world, Creature player){
		this.previous = previous;
		this.world = world;
		this.player = player;
	}
	
	@Override
	public void displayOutput(AsciiPanel terminal) {
		previous.displayOutput(terminal);
		
		terminal.write("Which direction do you want to jump?", 1, 20);
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		switch (key.getKeyCode()){
        case KeyEvent.VK_LEFT:
        case KeyEvent.VK_4:
        case KeyEvent.VK_H: jumpBy(-1, 0); break;
        case KeyEvent.VK_RIGHT:
        case KeyEvent.VK_6:
        case KeyEvent.VK_L: jumpBy( 1, 0); break;
        case KeyEvent.VK_UP:
        case KeyEvent.VK_8:
        case KeyEvent.VK_K: jumpBy( 0,-1); break;
        case KeyEvent.VK_DOWN:
        case KeyEvent.VK_2:
        case KeyEvent.VK_J: jumpBy( 0, 1); break;
        case KeyEvent.VK_7:
        case KeyEvent.VK_Y: jumpBy(-1,-1); break;
        case KeyEvent.VK_9:
        case KeyEvent.VK_U: jumpBy( 1,-1); break;
        case KeyEvent.VK_1:
        case KeyEvent.VK_B: jumpBy(-1, 1); break;
        case KeyEvent.VK_3:
        case KeyEvent.VK_N: jumpBy( 1, 1); break;
		}
		
		return previous;
	}

	private void jumpBy(int dx, int dy) {
		player.jumpBy(world, dx, dy);
	}
}

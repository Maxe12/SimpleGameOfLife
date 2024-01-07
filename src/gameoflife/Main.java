package gameoflife;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Main extends JFrame{
	
	public static void main(String [] args) {
		
		Draw drawer = new Draw();
		drawer.setVisible(true);

		JFrame GUI = new JFrame("Game of Life");
		GUI.setSize(540, 310);
		GUI.setDefaultCloseOperation(EXIT_ON_CLOSE);
		GUI.setResizable(false);
		GUI.setLocationRelativeTo(null);
		GUI.add(drawer);
		GUI.setVisible(true);

		Grid g = new Grid();
		GameLoop gl = new GameLoop();
		g.init();
		gl.start();
	}
	
}

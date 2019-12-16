package gameoflife;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Main extends JFrame{
	
	public static void main(String [] args) {
		JFrame GUI = new JFrame("Game of Life");
		GUI.setSize(550, 570);
		GUI.setDefaultCloseOperation(EXIT_ON_CLOSE);
		GUI.setResizable(false);
		GUI.setLocationRelativeTo(null);
		GUI.setVisible(true);
		
		Draw drawer = new Draw();
		GUI.add(drawer);
		drawer.setVisible(true);
		
		Grid g = new Grid();
		GameLoop gl = new GameLoop();
		g.init();
		gl.start();
	}
	
}

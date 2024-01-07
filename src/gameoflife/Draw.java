package gameoflife;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Draw extends JPanel{
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		g.drawRect(9, 9, 514, 258);
		
		for(int x=0; x < Grid.CELLCOUNT; x++) {
			for(int y=0; y < Grid.CELLCOUNT_Y; y++) {
				if(Grid.cells[x][y]) {
					g.setColor(Color.RED);
					g.drawRect(x + 10, y + 10, 1, 1);
				}else {
					g.setColor(Color.WHITE);
					g.drawRect(x + 10, y + 10, 1, 1);
				}
			}
		}
		repaint();
	}
}

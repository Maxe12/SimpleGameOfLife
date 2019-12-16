package gameoflife;

import java.util.concurrent.ThreadLocalRandom;

public class Grid {
	public static final int CELLCOUNT = 512;
	public static boolean[][] cells = new boolean[CELLCOUNT][CELLCOUNT];
	
	public final int startCells = 10000;
	private static int gen = 0;

	public void init() {
		for (int i = 0; i < startCells; i++) {
			int x = genRandom(0, CELLCOUNT);
			int y = genRandom(0, CELLCOUNT);
			cells[x][y] = true;
		}
	}
	
	public static void step() {
		gen++;
		System.out.println("generation: " + gen);
		for (int x = 0; x < CELLCOUNT; x++) {
			for (int y = 0; y < CELLCOUNT; y++) {
				int neighbours = countNeighbours(x, y);
				// rule: if cell is dead and has 3 neighbours revive it
				if (neighbours == 3 && !cells[x][y]) {
					cells[x][y] = true;
				}
				// rule: underpopulation < 2 neighbours and overpopulation > 3 neighbpurs -->
				// kill cell
				if (neighbours < 2 || neighbours > 3) {
					cells[x][y] = false;
				}
			}
		}
	}
	
	public static int countNeighbours(int x, int y) {
		int count = 0;
		int[] xoff = { 1, 1, 0, -1, -1, -1, 0, 1 };
		int[] yoff = { 0, 1, 1, 1, 0, -1, -1, -1 };

		for (int i = 0; i < 8; i++) {
			try {
				if (cells[x + xoff[i]][y + yoff[i]])
					count++;
			} catch (Exception e) {
				//ignore
			}
		}
		return count;
	}

	public int genRandom(int begin, int end) {
		return ThreadLocalRandom.current().nextInt(begin, end);
	}
}

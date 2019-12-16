package gameoflife;

public class GameLoop extends Thread {
	public boolean running = true;

	public void run() {
		while (running) {
			try {
				sleep(50);
				Grid.step();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

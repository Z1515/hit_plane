package Example2;

import java.util.Vector;

public class GameRule implements Runnable {
	private MainFrame mainFrame;
	private Vector<Bullet> bullets;

	public GameRule(MainFrame mainframe, Vector<Bullet> bullets) {
		this.mainFrame = mainframe;
		this.bullets = bullets;

		// Bullet b = new Bullet(this.mainFrame, x, y, direction);
		for (int i = 0; i < bullets.size(); i++) {
			Thread t = new Thread(bullets.get(i));
			t.start();
		}

	}

	synchronized void removeBullet() {
		for (int i = 0; i < bullets.size(); i++) {
			if (bullets.get(i).isAlive == false) {
				mainFrame.remove(bullets.get(i));
			}
		}
	}

	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			mainFrame.requestFocus();
			removeBullet();

			mainFrame.repaint();
		}
	}

}

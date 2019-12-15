package Example2;

import java.awt.Rectangle;
import java.util.Vector;



public class GameRule implements Runnable {
	private MainFrame mainFrame;
	private Vector<Bullet> bullets;
	private Vector<Plane> planes;

	public GameRule(MainFrame mainframe, Vector<Bullet> bullets, Vector<Plane> planes) {
		this.mainFrame = mainframe;
		this.bullets = bullets;
		this.planes = planes;
		for (int i = 0; i < 6; i++) {
			int y = (int) (Math.random() * 100);
			Plane pl = new Plane(this.mainFrame, y % 600, ((i + 1) * 80 - 70) % 550);
			Thread t = new Thread(pl);
			t.start();
			planes.add(pl);
		}

	}
	
	private void remove_b(Bullet bullet , int i) {
		mainFrame.remove(bullet);
		bullets.remove(i);
		mainFrame.validate();
	}
	
	private void remove_p(Plane plane, int i) {
		mainFrame.remove(plane);
		planes.remove(i);
		int y = (int) (Math.random() * 100);
		Plane pl = new Plane(this.mainFrame, y % 600, ((i + 1) * 80 - 70) % 550);
		Thread t = new Thread(pl);
		t.start();
		planes.add(pl);
		mainFrame.validate();
	}

	synchronized void removePlane() {
		for (int j = 0; j < planes.size(); j++) {
			if (planes.get(j).isAlive == false) {
				mainFrame.remove(planes.get(j));
				planes.remove(j);
				int y = (int) (Math.random() * 5);
				Plane pl = new Plane(mainFrame, 0, ((y + 1) * 100 - 70) % 550);
				Thread t = new Thread(pl);
				t.start();
				planes.add(pl);
			}
		}
	}
	synchronized void removeBullet() {
		for (int i = 0; i < bullets.size(); i++) {
			if (bullets.get(i).isAlive == false) {
				mainFrame.remove(bullets.get(i));
			}
		}
	}
	
	synchronized void hit_plane(Bullet bullet, int j) {
		Rectangle b_rec = new Rectangle(bullet.getBounds());
		for(int i = 0; i < planes.size(); i++) {
			Rectangle p_rec = new Rectangle(planes.get(i).getX(), planes.get(i).getY(), 48, 48);
			if(b_rec.intersects(p_rec)) {
				bullet.isAlive = false;
				planes.get(i).isAlive = false;
				remove_b(bullet, j);
				remove_p(planes.get(i), i);
				break;
			}
		}
	}
	
	synchronized void boom() {
		for(int i = 0; i < bullets.size(); i ++) {
			hit_plane(bullets.get(i),i);
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
			removePlane();
			boom();
			mainFrame.repaint();
		}
	}

}

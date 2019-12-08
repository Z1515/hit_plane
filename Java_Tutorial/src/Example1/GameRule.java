package Example1;

import java.util.Vector;

public class GameRule implements Runnable {

	private MainFrame mainFrame;
	private Vector<Plane> planes;

	public GameRule(MainFrame mainFrame, Vector<Plane> planes) {
		this.mainFrame = mainFrame;
		this.planes = planes;

		for (int i = 0; i < 6; i++) {
			int y = (int) (Math.random() * 100);
			Plane pl = new Plane(this.mainFrame, y % 600, ((i + 1) * 80 - 70) % 550);
			Thread t = new Thread(pl);
			t.start();
			planes.add(pl);
		}
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
			removePlane();

			mainFrame.repaint();
		}

	}

}

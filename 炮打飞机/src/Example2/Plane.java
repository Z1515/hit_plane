package Example2;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Plane extends JLabel implements Runnable {
	private int x, y; // 飞机出现的位置
	private int speed; // 飞机的速度
	boolean isAlive = true;
	MainFrame mainFrame;

	public Plane(MainFrame mainFrame, int x, int y) {
		// TODO Auto-generated constructor stub
		 speed = (int) (Math.random() * 2) + 1; // 随机产生飞机速度
		this.mainFrame = mainFrame;
		this.x = x;
		this.y = y;
		setIcon(new ImageIcon("images/plane.png"));
	}

	synchronized void refresh() {
		mainFrame.repaint();
	}

	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			if (x < 800) {
				x = x + speed;
				setBounds(x, y, 48, 48);
				refresh();
			} else {
				isAlive = false;
				return;
			}

			try {
				Thread.sleep(10);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	}

}

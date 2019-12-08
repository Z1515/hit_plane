package Example2;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bullet extends JLabel implements Runnable {
	private int x, y;
	private int speed;
	Direction direction;
	MainFrame mainFrame;
	boolean isAlive = true;

	private final ImageIcon up_ic = new ImageIcon("images/bullet_up.png");
	private final ImageIcon down_ic = new ImageIcon("images/bullet_down.png");
	private final ImageIcon left_ic = new ImageIcon("images/bullet_left.png");
	private final ImageIcon right_ic = new ImageIcon("images/bullet_right.png");

	public Bullet(MainFrame mainFrame, int x, int y, Direction direction) {
		this.mainFrame = mainFrame;
		this.x = x;
		this.y = y;
		speed = 1;
		this.direction = direction;
		if (this.direction == Direction.NORTH) {
			setIcon(up_ic);
		} else if (this.direction == Direction.SOUTH) {
			setIcon(down_ic);
		} else if (this.direction == Direction.WEST) {
			setIcon(left_ic);
		} else {
			setIcon(right_ic);
		}
	}

	synchronized void refresh() {
		mainFrame.repaint();
	}

	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			if (direction == Direction.NORTH) {
				if (y > 0) {
					y = y - speed;
					setBounds(x, y, 16, 25);
					refresh();
				} else {
					isAlive = false;
					return;
				}
			} else if (direction == Direction.SOUTH) {
				if (y < 700) {
					y = y + speed;
					setBounds(x, y, 16, 25);
					refresh();
				} else {
					isAlive = false;
					return;
				}
			} else if (direction == Direction.WEST) {
				if (x > 0) {
					x = x - speed;
					setBounds(x, y, 25, 16);
					refresh();
				} else {
					isAlive = false;
					return;
				}
			} else {
				if (x < 800) {
					x = x + speed;
					setBounds(x, y, 25, 16);
					refresh();
				} else {
					isAlive = false;
					return;
				}

			}
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
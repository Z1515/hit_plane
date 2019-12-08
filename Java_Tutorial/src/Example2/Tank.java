package Example2;

import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class Tank extends JLabel {
	private int x, y;
	private int speed;
	Direction direction;
	MainFrame mainFrame;
	private Vector<Bullet> bullets = new Vector<Bullet>();
	private int i = 0;

	private final ImageIcon[] up_ic = { new ImageIcon("images/dra_11.gif"), new ImageIcon("images/dra_10.gif"),
			new ImageIcon("images/dra_12.gif") };
	private final ImageIcon[] down_ic = { new ImageIcon("images/dra_02.gif"), new ImageIcon("images/dra_03.gif"),
			new ImageIcon("images/dra_01.gif") };
	private final ImageIcon[] left_ic = { new ImageIcon("images/dra_05.gif"), new ImageIcon("images/dra_04.gif"),
			new ImageIcon("images/dra_06.gif") };
	private final ImageIcon[] right_ic = { new ImageIcon("images/dra_08.gif"), new ImageIcon("images/dra_07.gif"),
			new ImageIcon("images/dra_09.gif") };

	public Tank(MainFrame mainFrame) {
		// TODO Auto-generated constructor stub
		setIcon(new ImageIcon("images/dra_02.gif"));
		x = y = 300;
		speed = 3;
		direction = Direction.SOUTH;
		this.mainFrame = mainFrame;
	}

	public void moveUp() {
		// TODO Auto-generated method stub
		mainFrame.remove(this);
		direction = Direction.NORTH;
		y = (y - speed) >= 0 ? y - speed : 0;
		this.setBounds(x, y, 48, 48);
		this.setIcon(up_ic[i]);
		i = (i + 1) % 3;
		mainFrame.add(this, JLayeredPane.LAYER_PROPERTY);
		mainFrame.repaint();
	}

	public void moveLeft() {
		// TODO Auto-generated method stub
		mainFrame.remove(this);
		direction = Direction.WEST;
		x = (x - speed) >= 0 ? x - speed : 0;
		this.setBounds(x, y, 48, 48);
		this.setIcon(left_ic[i]);
		i = (i + 1) % 3;
		mainFrame.add(this, JLayeredPane.LAYER_PROPERTY);
		mainFrame.repaint();
	}

	public void moveDown() {
		// TODO Auto-generated method stub
		mainFrame.remove(this);
		direction = Direction.SOUTH;
		y = (y + speed) + 48 <= 700 ? y + speed : 700 - 48;
		this.setBounds(x, y, 48, 48);
		this.setIcon(down_ic[i]);
		i = (i + 1) % 3;
		mainFrame.add(this, JLayeredPane.LAYER_PROPERTY);
		mainFrame.repaint();
	}

	public void moveRight() {
		// TODO Auto-generated method stub
		mainFrame.remove(this);
		direction = Direction.EAST;
		x = (x + speed) + 48 <= 800 ? x + speed : 800 - 48;
		this.setBounds(x, y, 48, 48);
		this.setIcon(right_ic[i]);
		i = (i + 1) % 3;
		mainFrame.add(this, JLayeredPane.LAYER_PROPERTY);
		mainFrame.repaint();
	}

	public void shotBullet() {
		Bullet bullet = new Bullet(mainFrame, x, y, direction);
		bullets.add(bullet);
		// mainFrame.add(bullet, JLayeredPane.LAYER_PROPERTY);
		// mainFrame.repaint();
	}

	public Vector<Bullet> get_bullets() {
		return this.bullets;
	}
}

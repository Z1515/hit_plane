package Example2;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private JLayeredPane container;
	private Tank tank;
	private Vector<Bullet> bullets = new Vector<Bullet>();

	public MainFrame() {
		// TODO Auto-generated constructor stub
		super("炮打飞机");
		setResizable(false);
		setLayout(null);
		setBackground(Color.WHITE);

		container = new JLayeredPane();
		container.setLayout(null);
		setContentPane(container);

		JPanel panel_null = new JPanel();
		add(panel_null, JLayeredPane.LAYER_PROPERTY);

		tank = new Tank(this);
		add(tank, JLayeredPane.POPUP_LAYER);
		tank.setBounds(300, 300, 48, 48);
		bullets = tank.get_bullets();

		Controller controller = new Controller(this, tank); // 创建一个控制器

		setSize(800, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

//		GameRule gameRule = new GameRule(this, bullets);
//		Thread begin = new Thread(gameRule);
//		begin.start();
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		for (int i = 0; i < bullets.size(); i++) {
			int x = bullets.get(i).getX();
			int y = bullets.get(i).getY();
			bullets.get(i).setBounds(x, y, 16, 25);
			getContentPane().add(bullets.get(i), JLayeredPane.POPUP_LAYER);
		}
		validate(); // 使容器上的控件生效
	}
}

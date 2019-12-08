package Example1;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private JLayeredPane container;
	private Vector<Plane> planes = new Vector<Plane>();

	public MainFrame() {
		// TODO Auto-generated constructor stub
		super("炮打飞机");
		setResizable(false);
		setLayout(null);
		setBackground(Color.WHITE);
		container = new JLayeredPane();
		container.setLayout(null);
		setContentPane(container);

		JPanel tank = new JPanel();
		add(tank, JLayeredPane.LAYER_PROPERTY);

		setSize(800, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		GameRule gameRule = new GameRule(this, planes);
		Thread begin = new Thread(gameRule);
		begin.start();
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);

		for (int i = 0; i < planes.size(); i++) {
			int x = planes.get(i).getX();
			int y = planes.get(i).getY();
			planes.get(i).setBounds(x, y, 48, 48);
			getContentPane().add(planes.get(i), JLayeredPane.POPUP_LAYER);
		}

		validate(); // 使容器中的控件生效
	}
}

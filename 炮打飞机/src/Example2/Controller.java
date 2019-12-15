package Example2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {
	private Tank tank;

	public Controller(MainFrame mainFrame, Tank tank) {
		this.tank = tank;

		mainFrame.addKeyListener(this); // 添加按键监视器
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
//		System.out.println(e.getExtendedKeyCode());
		switch (e.getKeyCode()) {
		case 38:
			tank.moveUp();
			break;
		case 40:
			tank.moveDown();
			break;
		case 37:
			tank.moveLeft();
			break;
		case 39:
			tank.moveRight();
			break;
		case 32:
			tank.shotBullet();
			break;
		}
	}
}

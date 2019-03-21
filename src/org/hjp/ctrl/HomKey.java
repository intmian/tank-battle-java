package org.hjp.ctrl;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.hjp.bean.BaseTank;
import org.hjp.bean.Bullet;
import org.hjp.main.Demo;

public class HomKey implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		BaseTank t = Demo.game.getList().get(0);
		if (e.getKeyCode() == KeyEvent.VK_W) {
			System.out.println("上键");
			if (t.getTy() - t.getDistance() > 0) {
				t.setDir(0);
				t.touchMap(t, Demo.game.getMap());
			} else {
				t.setTy(0);
			}

		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			System.out.println("下键");
			if (t.getTy() + t.getDistance() <= 560) {
				t.setDir(1);
				t.touchMap(t, Demo.game.getMap());
			} else {
				t.setTy(560);
			}

		} else if (e.getKeyCode() == KeyEvent.VK_A) {
			System.out.println("左键");
			if (t.getTx() - t.getDistance() > 0) {
				t.setDir(2);
				t.touchMap(t, Demo.game.getMap());
			} else {
				t.setTx(5);
			}

		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			System.out.println("右键");
			if (t.getTx() + t.getDistance() <= 560) {
				t.setDir(3);
				t.touchMap(t, Demo.game.getMap());
			} else {
				t.setTx(560);
			}

		} else if (e.getKeyCode() == KeyEvent.VK_J) {
			System.out.println("J");
			t.lauch();

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

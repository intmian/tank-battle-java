package org.hjp.ctrl;

import java.util.ArrayList;

import org.hjp.bean.Bullet;
import org.hjp.bean.EnemyTank;
import org.hjp.main.Demo;

public class BulletTime extends Thread {
	public void run() {
		while (true) {

			ArrayList<Bullet> bullet = Demo.game.getBullet();
			for (int i = 0; i < bullet.size(); i++) { // 获取游戏中所有的子弹
				Bullet b = bullet.get(i);
				// b.move(); // 调用移动方法
				b.touchMap(b, Demo.game.getMap());

			}
			for (int i = 0; i < bullet.size(); i++) { // 获取游戏中所有的子弹
				Bullet b = bullet.get(i);
				if (b.getBy() < 0 || b.getBy() > 600 || b.getBx() < 0 || b.getBx() > 600) {
					bullet.remove(i); // 删除子弹
				}
			}
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}

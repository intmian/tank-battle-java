package org.hjp.bean;

import java.util.Random;

import javax.swing.ImageIcon;
import org.hjp.main.*;
import org.hjp.main.*;

public class Tool {
	static void paint(String path, int x, int y, int w, int h) { // 绘制图片
		ImageIcon ii2 = new ImageIcon(path);
		Demo.hf2.getHop2().getGraphics().drawImage(ii2.getImage(), x, y, w, h, Demo.hf2);
	}

	static public void bomp(int x, int y) {
		Demo.game.bomps.add(new Bomp(x, y));
	}

	static public void make_tank(int kind) { // 敌方坦克工厂
		int[][] map = Demo.game.map;
		Random random = new Random();
		int x;
		int y;
		while (true) {
			x = random.nextInt(15);
			y = random.nextInt(10);
			if (map[y][x] == 0 || map[y][x] == 1)
				break;
		}
		int dir = random.nextInt(4);
		Demo.game.list3.add(new EnemyTank(x * 40, y * 40, dir, kind));
	}
}

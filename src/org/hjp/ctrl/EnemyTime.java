package org.hjp.ctrl;

import java.util.ArrayList;

import org.hjp.bean.EnemyTank;
import org.hjp.main.Demo;

public class EnemyTime extends Thread {

	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			if (Demo.controler.run == true)
				break;
		}
		while (true) {

			ArrayList<EnemyTank> et = Demo.game.getList3();
			for (int i = 0; i < et.size(); i++) { // 获取游戏中所有的地方坦克
				et.get(i).touchMap(Demo.game.map); // 调用移动方法

			}
			for (int i = 0; i < et.size(); i++) { // 获取游戏中所有的地方坦克
				if (et.get(i).getEty() < 0 || et.get(i).getEty() > 600 || et.get(i).getEtx() < 0
						|| et.get(i).getEtx() > 600) {
					et.remove(i); // 删除这辆坦克 死掉了
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

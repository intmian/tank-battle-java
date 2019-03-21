package org.hjp.bean;

import org.hjp.main.Demo;
import java.awt.Rectangle;

public class Bullet {
	private int bx;
	private int by;
	private int bw;
	private int bh;
	private int bdir;// 方向
	private int dictance;// 距离
	private boolean isAppear = false; // 是否出现
	private int kind; // 1 是 自己的坦克的子弹，2是敌人的

	public Bullet() {
		super();
	}

	public Bullet(int bx, int by, int bw, int bh, int bdir, int dictance, int kind) {
		super();
		this.bx = bx;
		this.by = by;
		this.bw = bw;
		this.bh = bh;
		this.bdir = bdir;
		this.dictance = dictance;
		this.kind = kind;
		System.out.println(by);
		System.out.println(dictance);
	}

	public void move() { // 子弹移动的方法

		if (bdir == 0) {
			this.by = this.by - dictance;

		} else if (bdir == 1) {
			by = by + dictance;
		} else if (bdir == 2) {
			bx = bx - dictance;
		} else if (bdir == 3) {
			bx = bx + dictance;
		}

	}

	public void touchMap(Bullet bullet, int[][] map) { // 子弹碰撞消失的方法
		Rectangle r2 = new Rectangle(bullet.bx, bullet.getBy(), bullet.getBw(), bullet.getBh()); // 通过两个正方形的碰撞检测代替点与点的碰撞
		if (this.kind == 1) // 正义的子弹
		{
			for (EnemyTank enemy_tank : Demo.game.list3) { // 遍历敌方坦克，是否碰撞
				Rectangle r1 = new Rectangle(enemy_tank.getEtx(), enemy_tank.getEty(), 40, 40);
				if (r2.intersects(r1) == true) {
					by = 1000; // 子弹消失
					bx = 1000;
					enemy_tank.die();
					return;
				}
			}
		} else // 敌人的子弹
		{
			for (BaseTank my_tank : Demo.game.list) { // 是否会被敌人攻击致死
				Rectangle r1 = new Rectangle(my_tank.getTx(), my_tank.getTy(), 40, 40);
				if (r2.intersects(r1) == true) {
					by = 1000; // 子弹消失
					bx = 1000;
					my_tank.die();
					return;
				}
			}
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 2) {

					Rectangle r1 = new Rectangle(j * 40, i * 40, 40, 40);

					if (r2.intersects(r1) == true) {
						by = 1000; // 子弹消失
						bx = 1000;
						return;

					}
				} else if (map[i][j] == 3) { // 如果是砖头，那么子弹和前面两个一起消失
					Rectangle r1 = new Rectangle(j * 40, i * 40, 40, 40);

					if (r2.intersects(r1) == true) {
						by = 1000;
						bx = 1000;
						map[i][j] = 0;
						return;
					}
				} else if (map[i][j] == 4) {
					Rectangle r1 = new Rectangle(j * 40, i * 40, 40, 40);
					if (r2.intersects(r1) == true) {
						by = 1000;
						bx = 1000;
						map[i][j] = 0;
						Demo.controler.fail(); // 老巢被引爆 失败
					}
				}

			}
		}
		bullet.move();
	}

	public void determine() { // 子弹边界类

	}

	public void boom() { // 爆炸的方法

	}

	public void drawRole() { // 绘画子弹

	}

	public int getBx() {
		return bx;
	}

	public void setBx(int bx) {
		this.bx = bx;
	}

	public int getBy() {
		return by;
	}

	public void setBy(int by) {
		this.by = by;
	}

	public int getBw() {
		return bw;
	}

	public void setBw(int bw) {
		this.bw = bw;
	}

	public int getBh() {
		return bh;
	}

	public void setBh(int bh) {
		this.bh = bh;
	}

	public int getBdir() {
		return bdir;
	}

	public void setBdir(int bdir) {
		this.bdir = bdir;
	}

	public int getDictance() {
		return dictance;
	}

	public void setDictance(int dictance) {
		this.dictance = dictance;
	}

	public boolean isAppear() {
		return isAppear;
	}

	public void setAppear(boolean isAppear) {
		this.isAppear = isAppear;
	}

}

package org.hjp.bean;

import java.awt.Rectangle;
import java.util.ArrayList;

import javax.security.auth.x500.X500Principal;

import org.hjp.main.Demo;

public class BaseTank { // 坦克类
	/*
	 * 0 2 3 1
	 */
	private int tx; // 坐标
	private int ty;
	private int tw; // 宽
	private int th; // 高
	private int hp; // x血量
	private int dir; // 方向
	private int distance; // 距离

	public BaseTank() {
		super();
	}

	public BaseTank(int tx, int ty, int tw, int th, int hp, int dir, int distance) {
		super();
		this.tx = tx;
		this.ty = ty;
		this.tw = tw;
		this.th = th;
		this.hp = hp;
		this.dir = dir;
		this.distance = distance;
	}

	public void move() {

		if (dir == 0) {
			ty = ty - distance;

		} else if (dir == 1) {
			ty = ty + distance;
		} else if (dir == 2) {
			tx = tx - distance;
		} else if (dir == 3) {
			tx = tx + distance;
		}

	}

	public void lauch() { // 发射的方法
		int bdir = getDir();
		int bx = getTx();
		int by = getTy();
		if (bdir == 0) {
			Bullet bullet = new Bullet(tx + 15, ty - 10, 10, 10, dir, 10, 1);
			Demo.game.getBullet().add(bullet);
		} else if (bdir == 1) {
			Bullet bullet = new Bullet(tx + 15, ty + 40, 10, 10, dir, 10, 1);
			Demo.game.getBullet().add(bullet);
		} else if (bdir == 2) {
			Bullet bullet = new Bullet(tx - 10, ty + 15, 10, 10, dir, 10, 1);
			Demo.game.getBullet().add(bullet);
		} else if (bdir == 3) {
			Bullet bullet = new Bullet(tx + 40, ty + 15, 10, 10, dir, 10, 1);
			Demo.game.getBullet().add(bullet);
		}

	}

	public void touchMap(BaseTank tank, int[][] map) {
		Rectangle r2 = new Rectangle(tank.tx - 10, tank.ty - 10, tank.getTw() + 20, tank.getTh() + 20);
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 2 || map[i][j] == 3 || map[i][j] == 5) {

					Rectangle r1 = new Rectangle(j * 40, i * 40, 40, 40);
					int newx = j * 40;
					int newy = i * 40;
					if (r2.intersects(r1) == true) { // 如果相撞就检测是那条边相碰
						if (newy + 40 <= ty && dir == 0 && newx - tx > -40 && newx - tx < 40) // 上部碰撞
						{
							ty = newy + 40; // 移动到障碍物下沿，避免撞见空气墙或者卡进去
							return;
						}
						if (newy - 40 >= ty && dir == 1 && newx - tx > -40 && newx - tx < 40) {
							ty = newy - 40;
							return;
						}
						if (newx + 40 <= tx && dir == 2 && newy - ty > -40 && newy - ty < 40) {
							tx = newx + 40;
							return;
						}
						if (newx - 40 >= tx && dir == 3 && newy - ty > -40 && newy - ty < 40) {
							tx = newx - 40;
							return;
						}
					}
				}

			}
		}
		tank.move();
	}

	public void die() {
		Tool.bomp(tx, ty);
		Demo.controler.fail();

	}

	public int getTx() {
		return tx;
	}

	public void setTx(int tx) {
		this.tx = tx;
	}

	public int getTy() {
		return ty;
	}

	public void setTy(int ty) {
		this.ty = ty;
	}

	public int getTw() {
		return tw;
	}

	public void setTw(int tw) {
		this.tw = tw;
	}

	public int getTh() {
		return th;
	}

	public void setTh(int th) {
		this.th = th;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

}

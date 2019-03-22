package org.hjp.bean;

import java.awt.Rectangle;
import java.util.Random;
import org.hjp.main.Demo;

public class EnemyTank { // 敌人坦克类
	private int x;
	private int y;
	private int hp;
	private int edir; // 方向
	private int edictance; // 单次移动距离
	private int speed; // 单次ai中可以进行移动的次数
	private int attack; // 弹速
	private int attack_last; // 还剩几步
	private int attack_rate; // 几步射击一次
	private int dir_change_last; // 随机变相
	private int kind;

	public EnemyTank() {
		super();
	}

	public EnemyTank(int etx, int ety, int ehp, int edir, int edictance, int attack, int attack_speed) {
		super();
		this.x = etx;
		this.y = ety;
		this.hp = ehp;
		this.edir = edir;
		this.edictance = edictance;
		this.attack = attack;
		this.attack_rate = attack_speed;
		this.attack_last = 10;
		this.dir_change_last = 50;
	}

	public EnemyTank(int x, int y, int dir, int kind) {
		this.x = x;
		this.y = y;
		this.edir = dir;
		this.kind = kind;
		switch (kind) {
		case 1: // 狙击者
			hp = 1;
			attack = 3;
			attack_rate = 10;
			this.edictance = 1;
			break;
		case 2: // 捍卫者
			hp = 3;
			attack = 1;
			attack_rate = 10;
			this.edictance = 1;
			break;
		case 3: // 偷袭者
			attack = 1;
			attack_rate = 10;
			hp = 1;
			this.edictance = 3;
			break;
		default:
			break;
		}
	}

	public void move() {

		if (edir == 0) {
			y = y - edictance;

		} else if (edir == 1) {
			y = y + edictance;
		} else if (edir == 2) {
			x = x - edictance;
		} else if (edir == 3) {
			x = x + edictance;
		}

	}

	public int getEtx() {
		return x;
	}

	public void setEtx(int etx) {
		this.x = etx;
	}

	public int getEty() {
		return y;
	}

	public void setEty(int ety) {
		this.y = ety;
	}

	public int getEhp() {
		return hp;
	}

	public void setEhp(int ehp) {
		this.hp = ehp;
	}

	public int getEdir() {
		return edir;
	}

	public void setEdir(int edir) {
		this.edir = edir;
	}

	public int getEdictance() {
		return edictance;
	}

	public void setEdictance(int edictance) {
		this.edictance = edictance;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void die() {
		hp--;
		if (hp == 0) {
			Tool.bomp(x, y); // 炸开
			this.x = 1000;
			this.y = 1000;
			Demo.controler.enemy_tank_died(kind);

		}
	}

	public void lauch() { // 发射的方法
		int bdir = edir;
		if (attack_last > 0) {
			attack_last--;
			return;
		}
		attack_last = attack_rate;
		if (bdir == 0) {
			Bullet bullet = new Bullet(x + 15, y - 10, 10, 10, edir, attack * 10, 2);
			Demo.game.getBullet().add(bullet);
		} else if (bdir == 1) {
			Bullet bullet = new Bullet(x + 15, y + 40, 10, 10, edir, attack * 10, 2);
			Demo.game.getBullet().add(bullet);
		} else if (bdir == 2) {
			Bullet bullet = new Bullet(x - 10, y + 15, 10, 10, edir, attack * 10, 2);
			Demo.game.getBullet().add(bullet);
		} else if (bdir == 3) {
			Bullet bullet = new Bullet(x + 40, y + 15, 10, 10, edir, attack * 10, 2);
			Demo.game.getBullet().add(bullet);
		}

	}

	public void touchMap(int[][] map) {
		lauch();
		if (dir_change_last == 0) {
			dir_change_last = 50;
			Random random = new Random();
			edir = random.nextInt(4); // 转向
		}
		dir_change_last--;
		if (x <= 0 + edictance) {
			if (edir == 2) {
				x += 1;
				edir = 3;
				return;
			}
		}
		if (x >= 600 - edictance - 40) {
			if (edir == 3) {
				x -= 1;
				edir = 2;
				return;
			}
		}
		if (y <= edictance) {
			if (edir == 0) {
				edir = 1;
				y -= 1;
				return;
			}

		}
		if (y >= 600 - edictance) {
			if (edir == 1) {
				y += 1;
				edir = 0;
				return;
			}

		}
		Rectangle r2 = new Rectangle(x - edictance, y - edictance, 40 + 2 * edictance, 40 + 2 * edictance); // 外围碰撞框
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 2 || map[i][j] == 3 || map[i][j] == 5) {

					Rectangle r1 = new Rectangle(j * 40, i * 40, 40, 40);
					int newx = j * 40;
					int newy = i * 40;
					if (r2.intersects(r1) == true) { // 如果相撞就检测是那条边相碰
						if (newy + 40 <= y && edir == 0 && newx - x > -40 && newx - x < 40) // 上部碰撞
						{
							y = newy + 40; // 移动到障碍物下沿，避免撞见空气墙或者卡进去
							dir_change_last = 50;
							Random random = new Random();
							edir = random.nextInt(4); // 转向
							return;
						}
						if (newy - 40 >= y && edir == 1 && newx - x > -40 && newx - x < 40) {
							y = newy - 40;
							dir_change_last = 50;
							Random random = new Random();
							edir = random.nextInt(4); // 转向
							return;
						}
						if (newx + 40 <= x && edir == 2 && newy - y > -40 && newy - y < 40) {
							x = newx + 40;
							dir_change_last = 50;
							Random random = new Random();
							edir = random.nextInt(4); // 转向
							return;
						}
						if (newx - 40 >= x && edir == 3 && newy - y > -40 && newy - y < 40) {
							x = newx - 40;
							dir_change_last = 50;
							Random random = new Random();
							edir = random.nextInt(4); // 转向
							return;
						}
					}
				}

			}
		}
		move();
	}
}

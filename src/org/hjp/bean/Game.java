package org.hjp.bean;

import java.util.ArrayList;
import java.util.Random;
import org.hjp.main.Demo;
import org.hjp.bean.Bomp;

public class Game {

	public ArrayList<BaseTank> list = new ArrayList<BaseTank>(); // 坦克集合
	public ArrayList<Bullet> list2 = new ArrayList<>();
	public ArrayList<EnemyTank> list3 = new ArrayList<EnemyTank>();
	public ArrayList<Bullet> bullet = new ArrayList<>();
	public ArrayList<Bomp> bomps = new ArrayList<>();

	public int[][] map;

	public Game() {
		init();
	}

	public Game(ArrayList<BaseTank> list) {
		this.list = list;
	}

	public void init() { // 初始化自己的坦克
		BaseTank t = new BaseTank(50, 300, 40, 40, 2, 0, 8);
		list.add(t);
	}

	private int getTy() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getTx() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getDir() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void initEnemy() { // 初始化敌人坦克类
		// Random r = new Random();
		// for (int i = 0; i < 3; i++) {
		// int etx = r.nextInt(500) + 10;
		// int ety = r.nextInt(500) + 10;
		// int hp = 100;
		// int dir = r.nextInt(4); // TODO
		// int edictance = 1;
		// EnemyTank et = new EnemyTank(etx, ety, hp, dir, edictance, 1, 1);
		// list3.add(et);
		// }
		Tool.make_tank(1);
		Tool.make_tank(2);
		Tool.make_tank(3);
	}

	public ArrayList<BaseTank> getList() {
		return list;
	}

	public void setList(ArrayList<BaseTank> list) {
		this.list = list;
	}

	public int[][] getMap() {
		return map;
	}

	public void setMap(int[][] map) {
		this.map = map;
	}

	public ArrayList<Bullet> getList2() {
		return list2;
	}

	public void setList2(ArrayList<Bullet> list2) {
		this.list2 = list2;
	}

	public ArrayList<EnemyTank> getList3() {
		return list3;
	}

	public void setList3(ArrayList<EnemyTank> list3) {
		this.list3 = list3;
	}

	public ArrayList<Bullet> getBullet() {
		return bullet;
	}

	public void setBullet(ArrayList<Bullet> bullet) {
		this.bullet = bullet;
	}

}

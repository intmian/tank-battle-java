package org.hjp.ctrl;

import javax.swing.JOptionPane;

import org.hjp.bean.Game;
import org.hjp.bean.Tool;
import org.hjp.main.Demo;

public class Controler { // 关卡得分配置;
	int tk_num; // 捍卫者人数
	int assa_num; // 偷袭者人数
	int attck_num; // 狙击手人数
	int stage; // 目前属于的关卡
	int grade = 0;
	int kill_num = 0;
	int grade_stage = 0;
	int kill_stage = 0;
	public boolean run = false;
	// 1草地，2铁墙，3砖头，4国王，5水，
	static int[][] map1 = { // 第一关
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2 },
			{ 0, 0, 0, 2, 3, 0, 0, 0, 3, 2, 0, 0, 0, 0, 0 }, { 0, 0, 0, 3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0 }, { 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 1, 1, 3, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0 }, { 5, 0, 0, 5, 5, 5, 0, 0, 5, 5, 0, 0, 5, 5, 5 },
			{ 0, 1, 1, 3, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0 }, { 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0 }, { 0, 0, 0, 2, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2 }, { 0, 0, 0, 0, 0, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 3, 4, 3, 0, 0, 0, 0, 0, 0, 0 } };
	static int[][] map2 = { // 第二关
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 2, 2 },
			{ 0, 0, 0, 2, 3, 0, 0, 0, 3, 2, 1, 1, 2, 0, 0 }, { 0, 0, 0, 3, 0, 0, 0, 2, 0, 3, 1, 1, 2, 0, 0 },
			{ 0, 0, 0, 3, 0, 0, 0, 2, 0, 3, 1, 1, 1, 0, 0 }, { 0, 0, 0, 3, 0, 0, 0, 2, 0, 0, 1, 1, 2, 0, 0 },
			{ 0, 1, 1, 3, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0 }, { 5, 0, 0, 5, 5, 5, 0, 0, 5, 5, 0, 0, 5, 5, 5 },
			{ 0, 1, 1, 3, 0, 0, 0, 0, 0, 0, 5, 1, 0, 0, 0 }, { 0, 0, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 2, 3, 0, 0, 0, 0, 0, 3, 5, 0, 0, 1, 0 }, { 0, 0, 2, 2, 0, 0, 0, 0, 0, 2, 5, 0, 0, 1, 0 },
			{ 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 5, 0, 2, 1, 2 }, { 0, 0, 0, 0, 0, 3, 2, 2, 0, 0, 5, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 3, 4, 3, 0, 0, 5, 0, 0, 0, 0 } };
	static int[][] map3 = { // 第三关
			{ 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0 }, { 2, 0, 3, 3, 3, 0, 0, 5, 3, 0, 3, 0, 2, 2, 2 },
			{ 2, 0, 0, 3, 3, 0, 0, 5, 3, 3, 0, 0, 0, 0, 0 }, { 0, 1, 0, 3, 0, 0, 0, 5, 3, 3, 0, 0, 0, 0, 0 },
			{ 0, 1, 0, 3, 0, 0, 0, 5, 3, 3, 3, 0, 0, 0, 0 }, { 0, 1, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 1, 1, 3, 0, 2, 0, 0, 0, 0, 1, 1, 1, 1, 0 }, { 0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 1, 1, 0, 0 },
			{ 0, 1, 1, 3, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0 }, { 0, 0, 0, 3, 0, 0, 0, 0, 3, 0, 0, 0, 3, 0, 0 },
			{ 0, 0, 1, 3, 0, 0, 0, 0, 3, 3, 0, 0, 3, 0, 0 }, { 0, 0, 1, 2, 0, 2, 2, 2, 3, 2, 0, 0, 0, 0, 0 },
			{ 0, 0, 1, 0, 0, 0, 0, 0, 0, 5, 5, 0, 2, 2, 2 }, { 2, 0, 0, 0, 0, 3, 3, 3, 0, 0, 5, 0, 0, 0, 0 },
			{ 4, 0, 0, 0, 0, 3, 4, 3, 0, 0, 0, 0, 0, 0, 0 } };

	public Controler() {
	}

	private void prepare_chage_stage() {
		// 为准备切换关卡做好准备
		tk_num = 10;
		assa_num = 10;
		attck_num = 10; // 重置人数
		kill_stage = 0; // 关卡数据清空
		grade_stage = 0;
		Demo.game.bomps.clear();
		Demo.game.bullet.clear();
		Demo.game.list.get(0).setTx(50);
		Demo.game.list.get(0).setTy(300);
		Demo.game.list2.clear();
		Demo.game.list3.clear();
		// 重置敌方坦克，我方坦克，子弹，移除所有未炸完的爆炸
	}

	public void change_stage(int map) {
		stage = 1;
		prepare_chage_stage();
		switch (map) {
		case 1:
			Demo.game.map = map1;
			break;
		case 2:
			Demo.game.map = map2;
			break;
		case 3:
			Demo.game.map = map3;
			break;
		default:
			break;
		}
		Tool.make_tank(1); // 先刷个三个出来
		Tool.make_tank(2);
		Tool.make_tank(3);
		Tool.make_tank(1); // 先刷个三个出来
		Tool.make_tank(2);
		Tool.make_tank(3);
		Tool.make_tank(1); // 先刷个三个出来
		Tool.make_tank(2);
		Tool.make_tank(3);
		Tool.make_tank(1); // 先刷个三个出来
		Tool.make_tank(2);
		Tool.make_tank(3);
		setStatus();
	}

	public void enemy_tank_died(int kind) {
		setStatus();
		grade_stage += kind;
		kill_num++;
		grade += kind;
		kill_stage++;
		// 敌人死掉后我方需要做出的改变
		switch (kind) {
		case 1: // 死了一个狙击手
			attck_num--;
			if (attck_num != 0) // 有存量的话的造一个
			{
				Tool.make_tank(1);
			}
			break;

		case 2:
			tk_num--;
			if (tk_num != 0) // 有存量的话的造一个
			{
				Tool.make_tank(2);
			}
			break;
		case 3:
			assa_num--;
			if (assa_num != 0) // 有存量的话的造一个
			{
				Tool.make_tank(3);
			}
			break;
		default:
			break;
		}
		if (attck_num == 0 && tk_num == 0 && assa_num == 0) {
			// 这张地图上敌人杀光了
			if (stage == 3) { // 没有下一关了{
				// TODO success
			} else {
				change_stage(stage + 1); // 下一关
			}
		}
	}

	public void fail() {
		JOptionPane.showMessageDialog(null, "失败", "失败", JOptionPane.OK_OPTION);
		System.exit(0);
	}

	public void success() {
		JOptionPane.showMessageDialog(null, "成功", "成功", JOptionPane.OK_OPTION);
		System.exit(0);
	}

	public void setStatus() { // 设置侧边栏
		Demo.hf2.getHop2().tank_num.setText(String.format("捍卫者:%d 偷袭者:%d 狙击手:%d", tk_num, assa_num, attck_num));
		Demo.hf2.getHop2().kill.setText("该关击毁坦克数:" + Integer.toString(kill_stage));
		Demo.hf2.getHop2().kill_all.setText("击毁坦克数:" + Integer.toString(kill_num));
		Demo.hf2.getHop2().grade.setText("该关得分:" + Integer.toString(grade_stage));
		Demo.hf2.getHop2().grade_all.setText("得分:" + Integer.toString(grade));

	}

}

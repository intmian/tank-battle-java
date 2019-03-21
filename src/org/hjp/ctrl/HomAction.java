package org.hjp.ctrl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.hjp.main.Demo;

public class HomAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String act = e.getActionCommand();
		if (act.equals("login") == true) {
			// 跳转到登录界面
			// 隐藏注册界面，显示登录界面
			Demo.controler.run = true;
			Demo.hf.setVisible(false);
			Demo.hf2.setVisible(true);
		} else if (act.equals("exit") == true) {
			int i = JOptionPane.showConfirmDialog(null, "你确定要退出游戏吗？");
			if (i == 0) {
				System.exit(0);
			}
		}
		if (act.equals("jump1"))
			Demo.controler.change_stage(1);
		if (act.equals("jump2"))
			Demo.controler.change_stage(2);
		if (act.equals("jump3"))
			Demo.controler.change_stage(3);
		if (act.equals("start") == true) {
			// 当点击开始的时候就开始初始化游戏
		} else if (act.equals("Exit") == true) {
			// 点击退出游戏的时候，就退出游戏
			int i = JOptionPane.showConfirmDialog(null, "哈哈哈，玩不下去了吧，辣鸡");
			if (i == 0) {
				System.exit(0);
			}
		}

	}

}

package org.hjp.main;

import javax.swing.JOptionPane;

import org.hjp.bean.Game;
import org.hjp.ctrl.BulletTime;
import org.hjp.ctrl.EnemyTime;
import org.hjp.ctrl.HomAction;
import org.hjp.ctrl.HomKey;
import org.hjp.ctrl.HomWindow;
import org.hjp.view.LoginFrame;
import org.hjp.view.GameFrame;
import org.hjp.view.GamePanel;
import org.hjp.ctrl.*;

public class Demo {

	public static Game game = new Game(); // 全局游戏参数
	public static Controler controler = new Controler();
	public static HomAction ha = new HomAction(); // 按钮监听
	public static LoginFrame hf = new LoginFrame(); // 登录界面

	public static GameFrame hf2 = new GameFrame(); // 游戏界面 包括菜单栏和 游戏界面
	public static HomWindow hW = new HomWindow(); // 窗体的监听
	public static HomKey hk = new HomKey(); // 按键监听
	public static EnemyTime et = new EnemyTime(); // 控制物体移动 敌人
	public static BulletTime bt = new BulletTime(); // 控制子弹移动
	public static Repainter rpRepainter = new Repainter(); // 统一控制重绘

	public static void main(String[] args) {
		hf.getHop().getButton().addActionListener(ha); // 按钮监听
		hf.getHop().getButton2().addActionListener(ha);
		hf2.getHop2();
		hf.addWindowListener(hW);// 窗体监听
		hf2.addWindowListener(hW);
		hf2.addKeyListener(hk);
		et.start();
		bt.start();
		rpRepainter.start();
		controler.change_stage(1);
		String s = JOptionPane.showInputDialog("请输入ID:");
		hf2.getHop2().id.setText(s); // 重置id
	}
}

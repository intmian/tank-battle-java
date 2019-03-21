package org.hjp.view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.hjp.main.Demo;

public class GameFrame extends JFrame {

	private GamePanel hop2 = new GamePanel(); // 初始化主游戏面板
	private JMenuBar jmb = new JMenuBar();
	private JMenu jm = new JMenu("游戏");
	private JMenuItem jmi1 = new JMenuItem("开始游戏");
	private JMenuItem jmi2 = new JMenuItem("重新开始");
	private JMenuItem jmi3 = new JMenuItem("排行榜");
	private JMenuItem jmi4 = new JMenuItem("自定义");
	private JMenuItem jmi5 = new JMenuItem("退出");

	private JMenu jm2 = new JMenu("跳关");
	private JMenuItem jmi01 = new JMenuItem("1");
	private JMenuItem jmi02 = new JMenuItem("2");
	private JMenuItem jmi03 = new JMenuItem("3");

	public GameFrame() {
		jmi1.setActionCommand("start");
		jm.add(jmi1);
		jm.addSeparator();// 分隔线
		jm.add(jmi2);
		jm.addSeparator();
		jm.add(jmi3);
		jm.addSeparator();
		jm.add(jmi4);
		jm.addSeparator();
		jmi1.setActionCommand("Exit");
		jm.add(jmi5);
		jm2.add(jmi01);
		jm.addSeparator();
		jm2.add(jmi02);
		jm.addSeparator();
		jm2.add(jmi03);
		jmi5.addActionListener(Demo.ha);
		jmi01.setActionCommand("jump1"); // 跳关指令
		jmi02.setActionCommand("jump2"); // 跳关指令
		jmi03.setActionCommand("jump3"); // 跳关指令
		jmi01.addActionListener(Demo.ha); // 添加action listener
		jmi02.addActionListener(Demo.ha);
		jmi03.addActionListener(Demo.ha);
		jmb.add(jm);
		jmb.add(jm2);
		this.setJMenuBar(jmb);

		this.setResizable(false);// 让界面不能最大化以及修改大小
		this.add(hop2);
		this.setTitle("单机版坦克大战_mian");// 设置面板的标题
		this.pack(); // 根据jpanel的大小来设置jframe的大小
		this.setLocationRelativeTo(null);// 当面板显示出来后，居中（如果不设置，他的位置在左上角）
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//// 当面板关闭时，程序也跟着关闭
		this.setVisible(false);// 让面板隐藏 待登录后再出现
	}

	public GamePanel getHop2() {
		return hop2;
	}

	public void setHop(GamePanel hop2) {
		this.hop2 = hop2;
	}

}

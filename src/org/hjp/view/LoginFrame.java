package org.hjp.view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class LoginFrame extends JFrame {

	private LoginPanel hop = new LoginPanel(); // 初始化纸
	private JMenuBar jmb = new JMenuBar();
	private JMenu jm = new JMenu("游戏");
	private JMenuItem jmi1 = new JMenuItem("开始游戏");
	private JMenuItem jmi2 = new JMenuItem("重新开始");
	private JMenuItem jmi3 = new JMenuItem("排行榜");
	private JMenuItem jmi4 = new JMenuItem("自定义");
	private JMenuItem jmi5 = new JMenuItem("退出");

	private JMenu jm2 = new JMenu("帮助");
	private JMenuItem jmi01 = new JMenuItem("游戏说明");

	public LoginFrame() {
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

		jmb.add(jm);
		jmb.add(jm2);
		this.setJMenuBar(jmb);

		this.add(hop);
		this.setTitle("单机版坦克大战_mian");// 设置面板的标题
		this.setResizable(false);// 让界面不能最大化以及修改大小
		this.pack(); // 根据jpanel的大小来设置jframe的大小
		this.setVisible(true);// 让面板显示出来
		this.setLocationRelativeTo(null);// 当面板显示出来后，居中（如果不设置，他的位置在左上角）
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//// 当面板关闭时，程序也跟着关闭
	}

	public LoginPanel getHop() {
		return hop;

	}

	public void setHop(LoginPanel hop) {
		this.hop = hop;
	}

}

package org.hjp.view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.hjp.util.HomUtil;

public class LoginPanel extends JPanel {

	private JButton button = new JButton("进入游戏");
	private JButton button2 = new JButton("退出游戏");

	public LoginPanel() {
		this.setLayout(null);// 将原本的布局取消掉，我自己定义布局
		button.setBounds(330, 310, 145, 45);// 添加控件之后需要设置控件的宽高和位置
		button.setActionCommand("login");
		button.setFocusable(false);
		this.add(button);
		button2.setBounds(330, 410, 145, 45);
		button2.setActionCommand("Exit");
		button.setFocusable(false);
		this.add(button2);

		this.setPreferredSize(new Dimension(HomUtil.HOMPANEL_WIDTH1, HomUtil.HOMPANEL_HIGHT1));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// 绘制图片
		ImageIcon ii = new ImageIcon("img/fm2.PNG");
		// 2.开始绘制图片,参数：1.图片对象；2,3图片的左上角到原点的距离；4,5图片的尺寸；6.this
		g.drawImage(ii.getImage(), 0, 0, HomUtil.PHOTO_WIDTH, HomUtil.PHOTO_HEIGHT, this);

	}

	public JButton getButton() {
		return button;
	}

	public void setButton(JButton button) {
		this.button = button;
	}

	public JButton getButton2() {
		return button2;
	}

	public void setButton2(JButton button2) {
		this.button2 = button2;
	}

}

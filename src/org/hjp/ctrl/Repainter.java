package org.hjp.ctrl;

import org.hjp.main.Demo;

public class Repainter extends Thread {
	public void run() {
		while (true) {
			Demo.hf2.getHop2().repaint();// 刷新
			Demo.hf.getHop().repaint();
			try {
				Thread.sleep(20);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}

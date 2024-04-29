package ch02;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 패널에 그림을 그리는 방법 자바 문법 - 중첩 클래스( 클래스안에 클래스를 만드는것) 외부 클래스, 내부클래스, outer class,
 * inner class
 */
public class MyDrawFrame extends JFrame {
	// 내부 클래스를 외부 클래스에 사용 할려면
	// 멤버로 가지고 있어야 한다
	MyDrawPanel myDrawPanel;

	public MyDrawFrame() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("내부클래스를 활용한 그림 그리는 연습");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		myDrawPanel = new MyDrawPanel();
	}

	private void setInitLayout() {
		add(myDrawPanel);
		setVisible(true);
	}

	// 내부 클래스 만들어 보기
	//
	// paint --> 좌표값 x = 0, y = 0
	// JPanel 에 있는 기능을 확장해 보기

	class MyDrawPanel extends JPanel {

		// paints ---> X
		// print --> X
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawRect(100, 100, 50, 100);
			g.drawRect(200, 200, 150, 150);
			g.drawLine(250, 300, 300, 300);
			g.drawOval(100, 150, 200, 300);
			g.drawString("난 나다", 400, 400);
			g.drawString("👽", 500, 500);
		}

	} // end of inner class
}

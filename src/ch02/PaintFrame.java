package ch02;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintFrame extends JFrame {
	
	MyDrawPanel1 myDrawPanel1;
	
	// 생산자
	public PaintFrame() {
		initData1();
		setInitData1();
	}

	private void initData1() {
		setTitle("춘자집");
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		myDrawPanel1 = new MyDrawPanel1();

	}

	public void setInitData1() {
		add(myDrawPanel1);
		setVisible(true);

	}

	// inner
	class MyDrawPanel1 extends JPanel {

		public void paint(Graphics g) {
			super.paint(g);
			
			//g.drawRect(100, 100, 50, 100);
			g.drawRect(250, 250, 350, 350); // 집본체
			
			g.drawRect(480, 275, 80, 80); // 창문
			
			g.drawRect(350, 450, 150, 150); // 입구
			
			g.drawLine(250, 250, 425, 75); // 지붕 왼쪽
			g.drawLine(425, 75, 600, 250); // 지붕 오른쪽
			
			g.drawLine(480, 315, 560, 315); // 창선 가로
			g.drawLine(520, 275, 520, 355); // 창선 세로
			
			g.drawLine(275, 650, 275, 675); // 사료 그릇 왼
			g.drawLine(325, 650, 325, 675); // 사료 그릇 오
			g.drawLine(275, 675, 325, 675); // 사료 그릇 아래
			g.drawLine(275, 650, 325, 650); // 사료 그릇 위
			
			g.drawOval(275, 640, 10, 10); //사료 1-1
			g.drawOval(285, 640, 10, 10); //사료 1-2
			g.drawOval(295, 640, 10, 10); //사료 1-3
			g.drawOval(305, 640, 10, 10); //사료 1-4
			g.drawOval(315, 640, 10, 10); //사료 1-5
			
			g.drawOval(280, 630, 10, 10); //사료 2-1
			g.drawOval(290, 630, 10, 10); //사료 2-2
			g.drawOval(300, 630, 10, 10); //사료 2-3
			g.drawOval(310, 630, 10, 10); //사료 2-4
			
			g.drawOval(285, 620, 10, 10); //사료 3-1
			g.drawOval(295, 620, 10, 10); //사료 3-2
			g.drawOval(305, 620, 10, 10); //사료 3-3
			
			g.drawOval(290, 610, 10, 10); //사료 4-1
			g.drawOval(300, 610, 10, 10); //사료 4-2
			
			g.drawOval(295, 600, 10, 10); //사료 5-1
			
			g.drawString("춘자집", 400, 200);
			g.drawString("냠냠", 290, 665); //사료 그릇 이름
			g.drawString("사료", 290, 690); //사료 그릇 이름
			
			g.drawString("💩", 550, 600);
			g.drawString("응가", 545, 590); //사료 그릇 이름
			
			g.drawString("🐕", 425, 600);
			g.drawString("춘자", 420, 590); //사료 그릇 이름
		}

	}// end of inner

}

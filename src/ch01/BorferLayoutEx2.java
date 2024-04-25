package ch01;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

// 단축키 습관 --> 컨트롤 + 쉬프트 + f,s,o
public class BorferLayoutEx2 extends JFrame {

	final int WIDTH = 600;
	final int HEIGHT = 600;
	JButton[] buttons;
	String[] directions = { BorderLayout.EAST, BorderLayout.WEST, BorderLayout.SOUTH, BorderLayout.NORTH,
			BorderLayout.CENTER };

	// 생성자
	public BorferLayoutEx2() {
		intitData();
		setInifLayout();

	}

	public void intitData() {
		setTitle("borderLayout연습");
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		buttons = new JButton[directions.length];

	}

	public void setInifLayout() {
		// 배치관리자 선정(컨테이너)
		// borderLayout <-- 컴포넌트들을 동서남북 가운데로 배치 시켜주는 레이아웃이다.
		setLayout(new BorderLayout());

		// 반복문을 확용해서 코드를 완성 하세요
		for (int i = 0; i < buttons.length; i++) {
			add(new JButton(directions[i]), directions[i]);
		}

	}

	public static void main(String[] args) {
		new BorferLayoutEx2();
	}// end of main

}

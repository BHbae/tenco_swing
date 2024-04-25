package ch01;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

// 단축키 습관 --> 컨트롤 + 쉬프트 + f,s,o
public class BorferLayoutEx1 extends JFrame {

	// 생성자
	public BorferLayoutEx1() {
		intitData();
		setInifLayout();

	}

	public void intitData() {
		setTitle("borderLayout연습");
		setSize(600, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void setInifLayout() {
		// 배치관리자 선정(컨테이너)
		// borderLayout <-- 컴포넌트들을 동서남북 가운데로 배치 시켜주는 레이아웃이다.
		setLayout(new BorderLayout());
		add(new JButton("동"), BorderLayout.EAST);
		add(new JButton("서"), BorderLayout.WEST);
		add(new JButton("남"), BorderLayout.SOUTH);
		add(new JButton("북"), BorderLayout.NORTH);
		add(new JButton("센터"), BorderLayout.CENTER);

	}

	public static void main(String[] args) {
		new BorferLayoutEx1();
	}// end of main

}

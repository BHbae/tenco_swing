package ch01;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

// Swing --> 배치 관리자 : FlowLayoutEx
// 컴포넌트들을 ( 버튼, 라벨)  들을 수평 수직으로 배치하는 클래스이가
public class FlowLayoutEx2 extends JFrame {

	// 반복문 활용

	private JButton[] buttons = new JButton[6];

	// 생성자
	public FlowLayoutEx2() {
		super.setTitle("FlowLayoutEx 연습");
		setSize(500, 500);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 생성자에서 메서드 호출 가능
		initData();
		setInitLayout();
	}

	// 멤버 변수를 초기화 하는 기능(값넣다)
	public void initData() {

		for (int i = 0; i < 6; i++) {
			buttons[i] = new JButton("button" + i);
		}
	}

	// 컴포넌트들을 배치하는 기능
	public void setInitLayout() {
		// 배치 관리자 --> BorderLayout 이라는 배치 관리자가 기본으로 활용된다.
		// FlowLayout flowLayout = new FlowLayout;
		// super.setLayout(flowLayout); // 배치관리자 --> FlowLayout

		// 배치 관리자 생성 및 JFrame 셋팅
		super.setLayout(new FlowLayout(FlowLayout.LEADING, 50, 50)); // 배치관리자 --> FlowLayout

		// 컴포넌트들을 붙이다. -> add(button1);
		// add(button1);
		// add(button2);
		// add(button3);
		for (int i = 0; i < buttons.length; i++) {
			super.add(buttons[i]);
		}

	}

	public static void main(String[] args) {
		// FlowLayoutEx f1 = new FlowLayoutEx(); // <------- 부를수 있는 이름이 있는 상태
		new FlowLayoutEx2(); // <------- 익명 클래스
		// 다시 접근해서 사용 할 일 없으면

	}// end of main

}

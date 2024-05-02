package Bubble.test.ex01;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Moveable {

	private int x;
	private int y;
	private ImageIcon playerR, playerL; // , 를 통해 여러개 가능

	public Player() {
		initData();
		setInitLayout();

	}

	private void initData() {
		playerR = new ImageIcon("img/playerR.png");
		playerL = new ImageIcon("img/playerL.png");

		// 실행 시 초기 값 셋팅
		x = 55;
		y = 535;
		// this.setIcon(playerR);
		setIcon(playerR);
		// this.setSize(50, 50);
		setSize(50, 50);
		setLocation(x, y);
	}

	private void setInitLayout() {
	}

	@Override
	public void left() {
		// 왼쪽 방향키가 이벤트 상생기
		// 이미지를 왼쪽으로 보는 이미지로 셋팅
		setIcon(playerL);
		x = x - 10;
		setLocation(x, y);
	}

	@Override
	public void right() {
		setIcon(playerR);
		x = x + 10;
		setLocation(x, y);
	}

	@Override
	public void up() {
		System.out.println("점프!!");
	}

	@Override
	public void down() {
		System.out.println("내려간다!!");
	}

}

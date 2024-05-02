package Bubble.test.ex03;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Player extends JLabel implements Moveable {

	private int x;
	private int y;
	private ImageIcon playerR, playerL; // , 를 통해 여러개 가능

	// 움직임의 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	
	// 벽에 충돌한 상태 
	private boolean leftWallCrash;
	private boolean rightWallCrash;

	// 플레이어 속도 상태
	private final int SPEED = 4;
	private final int JUMPSPEED = 2;

	// setter
	public void setLeft(boolean left) {
		this.left = left;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public Player() {
		initData();
		setInitLayout();

	}

	private void initData() {
		playerR = new ImageIcon("img/playerR.png");
		playerL = new ImageIcon("img/playerL.png");

		// 실행 시 초기 값 셋팅
		x = 450;
		y = 535;

		// 플레이어가 가만히 멈춤상태
		left = false;
		right = false;
		up = false;
		down = false;
		
		leftWallCrash = false;
		rightWallCrash = false;
		

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
		left = true;
		setIcon(playerL);

		// 방향의 반복문
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (left == true) {
					x = x - SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}).start();

		// 왼쪽 방향키가 이벤트 상생기
		// 이미지를 왼쪽으로 보는 이미지로 셋팅
		// 왼쪽으로 가고 있는 상태
		// 멈춰 있는 상태란 개녕이 필요

	} // end of left

	@Override
	public void right() {
		right = true;
		setIcon(playerR);

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (right == true) {
					x = x + SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10); // 0.01
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}).start();

	} // end of right

	@Override
	public void up() {
		System.out.println("점프!!");
		up = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 130 / JUMPSPEED; i++) {
					y = y - JUMPSPEED;
					setLocation(x, y);

					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				// 객체의 상태값을 잘 조절해야 한다.
				up = false;
				down();
			}
		}).start();

	}

	@Override
	public void down() {
		System.out.println("내려간다!!");
		down = true;
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 130 / JUMPSPEED; i++) {
					y = y + JUMPSPEED;
					setLocation(x, y);
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}).start();
		// 상태값 처리를 확실히 하자
		down = false;
	}

}

package Bubble.test.ex10;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Enemy extends JLabel implements Moveable {

	BubbleFrame mContext;
	// 살아 있는 상태 0, 물방울에 갇힌 상태 1
	private int state;
	
	
	
	// 적군의 좌표값 위치 상태
	private int x;
	private int y;
	private ImageIcon enemyR, enemyL;

	// 움직임의 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;

	// 적군 속도 상태
	private final int SPEED = 3;
	private final int JUMPSPEED = 1;
	// 적군 방향 상태
	EnemeyWay enemeyWay;

	// get, set

	public Enemy(BubbleFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
	}
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}

	

	private void initData() {
		enemyR = new ImageIcon("img/enemyR.png");
		enemyL = new ImageIcon("img/enemyL.png");
		
		state = 0;
		
		// 처음 실행 시 초기 값 셋팅
		x = 720;
		y = 175;

		// 플레이어가 가만히 멈춤 상태
		left = false;
		right = false;
		up = false;
		down = false;

		

		enemeyWay = EnemeyWay.RIGHT;

		setIcon(enemyL);
		setSize(50, 50);
		setLocation(x, y);
	}
	
	

	private void setInitLayout() {
	}

	@Override
	public void left() {
		this.enemeyWay = EnemeyWay.LEFT;
		left = true;
		setIcon(enemyL);

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (left) {
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
	} // end of left

	@Override
	public void right() {
		enemeyWay = EnemeyWay.RIGHT;
		right = true;
		setIcon(enemyR);

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (right) {
					x = x + SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	} // end of right

	@Override
	public void up() {
		System.out.println("점프");
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

	} // end of up

	@Override
	public void down() {
		System.out.println("다운");
		down = true;

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (down) {
					y = y + SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				down = false;
			}
		}).start();

	}//  end of down

	

} 
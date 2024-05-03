package Bubble.test.ex0707;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bubble extends JLabel implements Moveable {

	private Player player;

	private int x;
	private int y;

	// 움직임 상태
	private boolean left;
	private boolean right;
	private boolean up;

	// 적군을 맞춘 상태
	private int state; // 0. 기본물방울 1.적을 가둔 상태 물방울

	private ImageIcon bubble; // 기본물방울
	private ImageIcon bubbled; // 적을 가둔 물방울
	private ImageIcon bomb; // 퍼엉!

	// 연관관계, 의존성 컴포지션 관계, 생성자의존(DI)
	public Bubble(Player player) {
		this.player = player;
		initData();
		setInitLayout();

		// 객체생성시 무조거 스레드 시작
		initThread();
	}

	// get,set
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public ImageIcon getBubble() {
		return bubble;
	}

	public void setBubble(ImageIcon bubble) {
		this.bubble = bubble;
	}

	public ImageIcon getBubbled() {
		return bubbled;
	}

	public void setBubbled(ImageIcon bubbled) {
		this.bubbled = bubbled;
	}

	public ImageIcon getBomb() {
		return bomb;
	}

	public void setBomb(ImageIcon bomb) {
		this.bomb = bomb;
	}

	private void initData() {
		bubble = new ImageIcon("img/bubble.png");
		bubbled = new ImageIcon("img/bubbled.png");
		bomb = new ImageIcon("img/bomb.png");

		left = false;
		right = false;
		up = false;
		state = 0;
	}

	private void setInitLayout() {
		x = player.getX();
		y = player.getY();
		setIcon(bubble);
		setSize(50, 50);
		setLocation(x, y);

	}

	// 공통으로 사용하는 부분을 메서드로 만드러 보자
	// 이 메서드는 내부에서만 사용할 예정
	private void initThread() {
		// 버블을 스레드가 하나면 된다.
		// 익명 클래스
		new Thread(new Runnable() {

			@Override
			public void run() {
				if (player.playerWay == PlayerWay.LEFT) {
					left();
				} else {
					right();
				}
			}
		}).start();
	}

	@Override
	public void left() {
		left = true;
		for (int i = 0; i < 400; i++) {
			if (x == 50) {
				up();
				break;
			}
			x--;
			setLocation(x, y);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		up();
	}

	@Override
	public void right() {
		right = true;
		for (int i = 0; i < 400; i++) {
			if (x == 900) {
				up();
				break;
			}
			x++;
			setLocation(x, y);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		up();

	}

	@Override
	public void up() {
		up = true;
		while (up) {
			if (y == 20) {
				up = false;
				setIcon(bomb);
				if (up == false) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					setIcon(null);
				}
				break;
			}
			y--;
			setLocation(x, y);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

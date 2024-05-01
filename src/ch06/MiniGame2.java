package ch06;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniGame2 extends JFrame {

	private JLabel jPlayer;
	private JLabel backgroundMap;

	private int x = 100;
	private int y = 100;
	private final int MOVDE_DISTANCE = 10;
	private final int FRAME_WIDTH = 1100;
	private final int FRAME_HEIGHT = 1000;
	private final String PLAYER_NAME = "보그르 보그르";
	private final int PLAYER_WIDTH = 100;
	private final int PLAYER_HEIGHT = 100;

	public MiniGame2() {
		initData();
		setLayout();
		addEventListener();
	}

	private void initData() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//배경
		Icon icon = new ImageIcon("images/backgroundMap.png");
		backgroundMap = new JLabel(icon);
		backgroundMap.setSize(1100, 800);
		backgroundMap.setLocation(0, 0);
		
		
		
		//캐릭
		jPlayer = new JLabel(new ImageIcon("images/playerR.png"));
		jPlayer.setSize(PLAYER_WIDTH, PLAYER_HEIGHT);
		jPlayer.setLocation(x, y);
	}

	private void setLayout() {
		// 좌표 기반으로 배치관리자 변경
		setLayout(null);
		add(backgroundMap);
		backgroundMap.add(jPlayer);
		setVisible(true);
	}

	private void addEventListener() {
		// jPlayer 객체에게서만 KeyListener 동작을 시키고자 한다면
		// 익명 구현 클래스로 KeyListener 인터페이스를 재 정의 할 수 있다.
		// jPlayer.addKeyListener(this);

		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_UP) {
					System.out.println("위");
					y -= MOVDE_DISTANCE;

				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					System.out.println("왼");
					x -= MOVDE_DISTANCE;

				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					System.out.println("오른");
					x += MOVDE_DISTANCE;

				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					System.out.println("아래");
					y += MOVDE_DISTANCE;
				}

				jPlayer.setLocation(x, y);
			}
		});

	}

	// 코드 테스트
	public static void main(String[] args) {

		new MiniGame2();

	}// end of main

}// end of class

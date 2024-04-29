package ch04;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * JLble 이용 해서 이미지를 다룰 수있다 JLble.add(); 메서드를 톨래서 이미지를 겹필 수 있다. 좌표 기분으로 이미지를
 * 셋팅할려ㅕ면 배치관리자를 null 값으로 셋팅 해야 한다.
 */
public class MyFrame extends JFrame {

	private JLabel backgroundMap;
	private JLabel player;

	public MyFrame() {
		initData();
		setinitLayout();
	}

	public void initData() {
		setTitle("JLable 을 활용한 이미지 사용연습");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Icon icon = new ImageIcon("images/image2.png"); // 업캐스팅 상태
		backgroundMap = new JLabel(icon);

		backgroundMap.setSize(500, 500);
		backgroundMap.setLocation(0, 0);

		player = new JLabel(new ImageIcon("images/image5.gif"));
		player.setSize(100, 100);
		player.setLocation(300, 100);

	}

	public void setinitLayout() {
		// 좌표 값으로 셋팅하기 위해서는 배치관리자를 null 값으로 만들어 주어야 한다.
		setLayout(null);
		add(backgroundMap);
		backgroundMap.add(player);
		setVisible(true);

	}

}

package ch05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorChangeFrame2 extends JFrame implements ActionListener {

	private JPanel panel;
	private JButton button1;
	private JButton button2;

	public ColorChangeFrame2() {
		initData();
		setInitLatout();
		addEventListEner();
	}

	private void initData() {
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		panel = new JPanel();
		panel.setBackground(Color.yellow);

		button1 = new JButton("click1");
		button2 = new JButton("click2");
	}

	private void setInitLatout() {
		add(button1, BorderLayout.NORTH);
		add(button2, BorderLayout.SOUTH);
		add(panel, BorderLayout.CENTER);
		setVisible(true);

	}

	// 이 메서드에 책임은 이벤트 리스너만 등ㄹ혹
	private void addEventListEner() {
		button1.addActionListener(this);
		button2.addActionListener(this);

	}

	// 오버라이드 : 이벤트가 일어나면 호출 되어지는 메서드
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(button1)) {
			System.out.println(e.getSource().toString());
			panel.setBackground(Color.black);
		} 
		if(e.getSource().equals(button2)){
			System.out.println(e.getSource().toString());
			panel.setBackground(Color.YELLOW);
		}

	}

	public static void main(String[] args) {
		new ColorChangeFrame2();

	}// end of main

}

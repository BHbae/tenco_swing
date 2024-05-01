package ch07;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LottoFrame extends JFrame implements ActionListener {

	private JButton button;
	private LottoRandomNumber lottoRandomNumber;
	private boolean isStart = true;
	private int NUMBER_DISTANCE = 50;

	public LottoFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("Lotto Game");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button = new JButton("Game Start");
		lottoRandomNumber = new LottoRandomNumber();

	}

	private void setInitLayout() {
		add(button, BorderLayout.NORTH);
		setVisible(true);
	}

	private void addEventListener() {
		button.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("그림을 그린다");
		// 이벤트가 일어나면 그림을 다시그려라
		isStart = false;
		repaint();// 다시 그림을 그려라 요철하는 명형어 //F5
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Font f = new Font("궁서체", Font.BOLD, 20);
		g.setFont(f);

		if (isStart) {
			g.drawString("로또번호를 클릭하세요", 240, 200);
		} else {
			int[] getNumbers = lottoRandomNumber.createNumber();
			for (int i = 0; i < getNumbers.length; i++) {
				g.drawString(getNumbers[i] + " ", 150 + (i * NUMBER_DISTANCE), 200);

			}

		}

	}

	public static void main(String[] args) {
		new LottoFrame();
	} // end of main

} // end of class

package ch05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JPanel213 extends JFrame implements ActionListener{
	private JPanel panel;
	private JPanel buttonPanel;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	
	public JPanel213() {
		initData();
		setInitLayout();
		addEventListEner();
	}


	public void initData() {
		setSize(500, 500);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(Color.yellow);
		buttonPanel = new JPanel();
		button1 = new JButton("click1");
		button2 = new JButton("click2");
		button3 = new JButton("click3");
		
	}

	public void setInitLayout() {

		add(buttonPanel,  BorderLayout.SOUTH);
		buttonPanel.add(button1);
		buttonPanel.add(button2);
		buttonPanel.add(button3);
		add(panel, BorderLayout.CENTER);
		setVisible(true);
	}

	
	private void addEventListEner() {
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(button1)) {
			System.out.println("1번");
			panel.setBackground(Color.black);
		} 
		if(e.getSource().equals(button2)){
			System.out.println("2번");
			panel.setBackground(Color.YELLOW);
		}
		if(e.getSource().equals(button3)){
			System.out.println("3번");
			panel.setBackground(Color.GREEN);
		}
		
	}
	
	public static void main(String[] args) {
		new JPanel213();
	}

}

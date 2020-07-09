package com.Abhinav;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class VisualMain {
	public static void main(String[] args) {
		MyFrame myframe = new MyFrame();
	}
}

class MyFrame extends JFrame {
	Thread t1, t2, t3, t4;
	GraphicsPanel gd = new GraphicsPanel();
	JButton b2 = new JButton("bubblesort");
	JButton b4 = new JButton("mergesort");
	JButton b1 = new JButton("selectionsort");
	JButton b3 = new JButton("insertionsort");
	JButton b5 = new JButton("quicksort");
	JButton b6 = new JButton("shuffle");
	JButton b7 = new JButton("stop");

	public MyFrame() {

		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				t1 = new Thread(() -> {
					gd.exit = false;
					gd.bubblesort();
				});
				t1.start();

			}

		});
		b4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				t3 = new Thread(() -> {
					gd.exit = false;
					gd.mergeSorthelp();
				});
				t3.start();
			}

		});
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				t1 = new Thread(() -> {
					gd.exit = false;
					gd.selectionsort();
				});
				t1.start();

			}

		});
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				t1 = new Thread(() -> {
					gd.exit = false;
					gd.insertionsort();
				});
				t1.start();

			}

		});
		b5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				t1 = new Thread(() -> {
					gd.exit = false;
					gd.quicksortutil();
				});
				t1.start();

			}

		});
		b6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				gd.exit = false;
				gd.generate();

			}

		});
		b7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				t1 = new Thread(() -> {
					gd.current = -1;
					gd.compare = -1;
					gd.exit = true;

				});
				t1.start();

			}

		});

		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(b4);
		this.add(b5);
		this.add(b6);
		this.add(b7);

		b1.setBounds(10, 5, 135, 25);
		b2.setBounds(10, 35, 135, 25);
		b3.setBounds(10, 65, 135, 25);
		b4.setBounds(10, 95, 135, 25);
		b5.setBounds(10, 125, 135, 25);
		b6.setBounds(10, 215, 135, 25);
		b7.setBounds(10, 245, 135, 25);

		this.setLayout(null);
		this.setSize(950, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.add(gd);
		gd.setBounds(150, 0, 800, 500);

	}

}

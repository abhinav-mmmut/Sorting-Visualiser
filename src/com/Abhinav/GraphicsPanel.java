package com.Abhinav;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JPanel;

class GraphicsPanel extends JPanel {
	protected boolean exit = false;
	int[] a = new int[100];
	int delay = 25;
	Graphics2D g2d;
	int current = -1, compare = -1;

	GraphicsPanel() {

	}

	public void mergeSorthelp() {
		System.out.println("merge");
		mergeSort(a, 0, 99);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.black);

		g2d = (Graphics2D) g;
		g2d.setColor(Color.blue);
		g2d.setStroke(new BasicStroke(2));
		int n = a.length;
		for (int i = 0; i < n; i++) {
			if (i == current || i == compare)
				g2d.setColor(Color.green);
			g2d.drawLine(130 + i * 5, 40, 130 + i * 5, 40 + a[i] * 3);
			if (i == current || i == compare)
				g2d.setColor(Color.blue);
		}
	}

	

	public void generate() {

		for (int i = 0; i < a.length; i++) {
			a[i] = i + 1;
		}
		Random rand = new Random();
		for (int i = 0; i < a.length; i++) {
			int swapidx = rand.nextInt(100);
			int temp = a[swapidx];
			a[swapidx] = a[i];
			a[i] = temp;
		}
		current = -1;
		compare = -1;
		repaint();
	}
	void bubblesort() {
		System.out.println("bubble");
		int n = a.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (exit == true)
					return;
				try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				current = j;
				compare = j + 1;
				repaint();
				if (a[j] > a[j + 1]) {

					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;

				}

			}
		}
	}
	void merge(int[] arr, int l, int m, int r) {

		int i, j, k;
		int n1 = m - l + 1;
		int n2 = r - m;

		int L[] = new int[n1], R[] = new int[n2];

		for (i = 0; i < n1; i++)
			L[i] = arr[l + i];
		for (j = 0; j < n2; j++)
			R[j] = arr[m + 1 + j];

		i = 0;
		j = 0;
		k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				if (exit == true)
					return;
				arr[k] = L[i];
				i++;

			} else {
				if (exit == true)
					return;
				arr[k] = R[j];
				j++;

			}
			k++;
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			current = k;

			repaint();
		}

		while (i < n1) {
			if (exit == true)
				return;
			arr[k] = L[i];
			i++;
			k++;
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			current = k;
			repaint();
		}

		while (j < n2) {
			if (exit == true)
				return;
			arr[k] = R[j];
			j++;
			k++;
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			current = k;
			repaint();
		}

	}

	void mergeSort(int[] arr, int l, int r) {

		if (l < r) {

			int m = l + (r - l) / 2;
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);

			merge(arr, l, m, r);
			if (exit == true)
				return;
		}
	}

	public void selectionsort() {
		System.out.println("selection");

		for (int i = 0; i < a.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (exit == true)
					return;
				if (a[j] < a[min])
					min = j;
				try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				current = i;
				compare = j;
				repaint();
			}
			int temp = a[min];
			a[min] = a[i];
			a[i] = temp;
		}

	}

	public void insertionsort() {
		System.out.println("insertion");
		int n = a.length;
		for (int i = 1; i < n; ++i) {
			int key = a[i];
			int j = i - 1;

			while (j >= 0 && a[j] > key) {
				if (exit == true)
					return;
				a[j + 1] = a[j];
				j = j - 1;
				try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				current = i;
				compare = j;
				repaint();
			}
			a[j + 1] = key;
		}

	}

	public void quicksortutil() {
		System.out.println("quicksort");
		quickSort(a, 0, a.length - 1);
	}

	public void quickSort(int arr[], int low, int high) {
		if (low < high) {

			int pi = partition(arr, low, high);
			quickSort(arr, low, pi - 1);
			if (exit == true)
				return;
			quickSort(arr, pi + 1, high);
			if (exit == true)
				return;
		}
	}

	public int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = (low - 1);

		for (int j = low; j <= high - 1; j++) {

			if (arr[j] < pivot) {
				if (exit == true)
					return 0;
				try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				current = pivot;
				compare = j;
				repaint();
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return (i + 1);
	}
}
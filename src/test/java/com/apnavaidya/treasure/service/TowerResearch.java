package com.apnavaidya.treasure.service;

import java.io.*;
import java.util.Scanner;

public class TowerResearch {
	static long record[] = new long[10000];

	public static void main(String args[]) throws Exception {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT
		 */

		Scanner sc = new Scanner(System.in);

		long input[] = new long[10];
		int index = 0;
		long size = 0;
		long max_input = 0;
		long t = sc.nextLong();
		while (t > 0) {
			input[index] = sc.nextLong();
			if (input[index] > max_input) {
				max_input = input[index];
			}
			index++;
			size++;
			t--;
		}

		setRecord();

		for (int i = 0; i < size; i++) {
			System.out.println((compute((int) input[i])) - input[i]);
		}
	}

	private static long compute(int x) {
		if (x < 10000) {
			return record[x];
		} else {
			return compute(x / 2) + compute(x / 3) + compute(x / 4);
		}
	}

	private static void setRecord() {
		record[0] = 0;
		for (int i = 1; i < 100000; i++) {
			record[i] = Math.max((i), (record[i / 2] + record[i / 3] + record[i / 4]));
		}

	}
}

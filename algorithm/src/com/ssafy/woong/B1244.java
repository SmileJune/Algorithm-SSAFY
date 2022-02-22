package com.ssafy.woong;

import java.util.Scanner;

public class B1244 {
	static Scanner sc = new Scanner(System.in);
	static int[] switches;

	public static void main(String[] args) {
		int n = sc.nextInt();
		switches = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			switches[i] = sc.nextInt();
		}

		int studentNum = sc.nextInt();
		for (int i = 0; i < studentNum; i++) {
			int gender = sc.nextInt();
			int num = sc.nextInt();

			switchChange(gender, num);
		}
		
		for(int k = 1; k < switches.length; k++) {
			System.out.print(switches[k] + " ");
			if(k % 20 == 0) {
				System.out.println();
			}
		}
		
	}

	private static void switchChange(int gender, int num) {

		if (gender == 1) {
			for (int i = 1; i < switches.length; i++) {
				if (i % num == 0) {
					switches[i] = (switches[i] == 1) ? 0 : 1;
				}
			}

		}
		else if(gender == 2) {
			for(int i = 0; i < switches.length; i++) {
				if(num + i < switches.length && num - i >= 1 && switches[num+i] == switches[num-i]) {
					switches[num - i] = switches[num + i] = (switches[num + i] == 1) ? 0 : 1;
				}else {
					break;
				}
			}
		}

	}

}

package com.ssafy.yun;

import java.util.Scanner;

public class Baek_2527 {

	public static Scanner sc = new Scanner(System.in);
	public static int[] aArr;
	public static int[] bArr;
	public static int Ax, Ay, Bx, By, Cx, Cy, Dx, Dy;
	public static int xCnt, yCnt;

	public static void main(String[] args) {
		for (int tc = 1; tc <= 4; tc++) {
			aArr = new int[50001];
			bArr = new int[50001];

			xCnt = 0;
			yCnt = 0;

			Ax = sc.nextInt();
			Ay = sc.nextInt();
			Bx = sc.nextInt();
			By = sc.nextInt();

			Cx = sc.nextInt();
			Cy = sc.nextInt();
			Dx = sc.nextInt();
			Dy = sc.nextInt();

			for (int i = Ax; i <= Bx; i++) {
				aArr[i]++;
			}
			for (int i = Cx; i <= Dx; i++) {
				aArr[i]++;
			}

			for (int i = 0; i < aArr.length; i++) {
				if (aArr[i] == 2) {
					xCnt++;
				}
			}

			for (int i = Ay; i <= By; i++) {
				bArr[i]++;
			}
			for (int i = Cy; i <= Dy; i++) {
				bArr[i]++;
			}

			for (int i = 0; i < bArr.length; i++) {
				if (bArr[i] == 2) {
					yCnt++;
				}
			}

			if (xCnt == 0 || yCnt == 0) {
				System.out.println("d");
				continue;
			}

			if (xCnt == 1 && yCnt == 1) {
				System.out.println("c");
				continue;
			}

			if (xCnt == 1 || yCnt == 1) {
				System.out.println("b");
				continue;
			}
			System.out.println("a");
		}

	}

}

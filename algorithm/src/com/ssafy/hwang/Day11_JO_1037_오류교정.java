package com.ssafy.hwang;
/*
 * 짝수 패리티를 확인하는 문제.
 * 
 * 행과 열에서 각각의 1의 갯수를 담은 cnt를 확인하여 홀수개인 행과 열을 찾아 0으로 고쳐주고 다시 확인.
 */
import java.util.Scanner;

public class Day11_JO_1037_오류교정 {
	static int tempX;
	static int tempY;
	static int cnt ;
	static int N ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		tempX = -1;
		tempY = -1;
		cnt = 0;
		N = sc.nextInt();
		int[][] arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		// 행에서 짝수패리티가 아닌 곳 찾기.
		for (int i = 0; i < N; i++) {
			cnt = 0;
			for (int j = 0; j < N; j++) {

				if (arr[i][j] == 1)
					cnt++;
			}
			// 1의 갯수가 짝수가 아니면 당첨. 하나만 찾으면 바로 탈출.
			if (cnt % 2 != 0) {
				tempX = i;
				break;
			}
		}

		// 열에서 반복
		for (int i = 0; i < N; i++) {
			cnt = 0;
			for (int j = 0; j < N; j++) {

				if (arr[j][i] == 1)
					cnt++;
			}
			if (cnt % 2 != 0) {
				tempY = i;
				break;
			}
		}
		checkArr(arr);
		
	}
	public static void checkArr(int[][]arr) {
		if(tempX==-1&&tempY==-1) {
			System.out.println("OK");
			return;
		}
		if(tempX==-1 || tempY==-1) {
			System.out.println("Corrupt");
			return;
		}
		arr[tempX][tempY] = 0;
		for (int i = 0; i < N; i++) {
			cnt=0;
			for (int j = 0; j < N; j++) {
				if(arr[i][j]==1) cnt++;
			}
		}
		if(cnt%2==1) System.out.println("Corrupt");
		else System.out.printf("Change bit (%d,%d)", tempX + 1, tempY + 1);		
	}
}

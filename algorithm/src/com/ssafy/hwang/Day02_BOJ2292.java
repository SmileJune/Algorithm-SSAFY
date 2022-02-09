package com.ssafy.hwang;
/*
 * BOJ 2292 벌집문제(B2) 
 * 육각형으로 이루어진 벌집에서 중앙에 1번방을 기준으로
 * 이웃하는 방에 번호가 1씩 증가할때, N번방에 가는데 몇개의 방을 지나는지 구하는 문제 
 */
import java.util.Scanner;

public class Day02_BOJ2292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int step =0;
		int dest = sc.nextInt();
		int compareNum = 1;
		if (dest == 1) {
			System.out.println(1);
			return;
		}

		while (true) {
			step++;
			if(compareNum>=dest) {
				break;
			}
			compareNum += step * 6;
		}
		System.out.println(step);
	}
}

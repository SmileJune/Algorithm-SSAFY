package com.ssafy.hwang;
/*
 * BOJ 1193 분수찾기(B1)  
 * 주어진 배열에서 주어진 위치에 알맞은 분수 값 구하는 문제.
 * 대각선(/) 방향으로 한줄을 묶을 때 몇번째 line에 위치하는지, 
 * 그 line에는 몇번째 위치까지 들어가 있는지 확인 후 조합하여 분수 생성
 */
import java.util.Scanner;

public class Day02_BOJ1193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();

		int range = 1;
		int line = 1;

		while (input > range) {
			line++;
			range += line;
		}
		int diff = input-range+line;

		if (line % 2 == 0) {
			System.out.println(diff + "/" + (line-diff+1));
		} else {
			System.out.println((line-diff+1) + "/" + diff);

		}

	}
}

package com.ssafy.namja;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_5545_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		// 최고의 피자 : 가게에서 주문 가능한 피자 중 1원당 열량이 가장 높은 피자
		
		int N = sc.nextInt();	// 토핑의 종류의 수
		int A = sc.nextInt();	// 도우의 가격
		int B = sc.nextInt();	// 토핑의 가격
		int C = sc.nextInt();	// 도우의 열량
		int[] top = new int[N];	// 토핑
		
		for (int i = 0; i < N; i++) {
			top[i] = sc.nextInt();	// Di : 토핑의 열량
		}
		Arrays.sort(top);
		for (int i : top)
			System.out.print(i + " ");
		int price = A;
		int kcal = C;
		int max = kcal / price;
		for (int i = N - 1; i >= 0; i--) {
			price += B;
			kcal += top[i];
			max = Math.max(max, kcal / price);
		}
		System.out.println(max);
	}
}

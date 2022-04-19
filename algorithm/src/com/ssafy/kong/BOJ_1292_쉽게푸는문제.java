package com.ssafy.BOJ_SB;

import java.util.Scanner;

public class BOJ_1292_쉽게푸는문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int[] arr = new int[1001];
		int idx = 1;
		// A부터 B까지 어떤 특정 배열을 더할건데,
		// 1은 1까지. 2는 1+2까지. 3은 1+2+3까지. 이렇게된다.
		// 그러면 i번쨰 숫자가 시작되는 인덱스는?
		// 끝나는 인덱스가 n(n+1)/2 시작하는 인덱스가 n(n-1)/2.
		for (int i = 1; i <= 1000; ++i) {
			arr[i] = idx;
			if (idx * (idx + 1) / 2 == i) {
				idx++;
			}
		}
		int ans = 0;
		for (int i = A; i <= B; ++i) {
			ans += arr[i];
		}
		System.out.println(ans);
	}
}

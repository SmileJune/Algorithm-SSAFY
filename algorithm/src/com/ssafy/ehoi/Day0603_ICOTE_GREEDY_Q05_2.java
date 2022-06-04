package com.ssafy.ehoi;

import java.util.Scanner;

public class Day0603_ICOTE_GREEDY_Q05_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 볼링공 개수
		int m = sc.nextInt(); // 볼링공 최대 무게

		int[] arr = new int[11]; // 볼링공 무게가 최대 10일거래
		for (int i = 0; i < n; i++) {
			arr[sc.nextInt()]++; // 무게를 idx로 보고 더해주기
		}

		int ans = 0;
		// 이제 무게를 1부터 10까지 돌면서 -> 10까지 돌 필요 없이 최대 무게까지 돌면서
		for (int i = 1; i <= m; i++) {
			// 볼링공 개수에서 무게 i를 가진 볼링공의 개수를 빼주는 거야
			// arr[i]는 a가 선택할 볼링공의 갯수가 되고
			// n은 무게 i가 아닌 볼링공만 남을테니까 b가 선택할 수 있는 볼링공의 갯수가 되는 거지
			n -= arr[i];
			ans += n * arr[i]; // 곱한 가짓수만큼 ans에 더하고
		}
		
		System.out.println(ans);
		sc.close();
	}
}
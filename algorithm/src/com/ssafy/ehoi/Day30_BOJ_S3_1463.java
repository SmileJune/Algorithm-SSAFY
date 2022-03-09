package com.ssafy.ehoi;

import java.util.Scanner;
// 깃헙토큰 다시 만들기

public class Day30_BOJ_S3_1463 {
	// 메모리제이션을 위해서 배열 하나 만들어야 함
	static int[] memo;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 1보다 크거나 같고 10^6보다 작아요
		memo = new int[N + 1];

		// 그 자리에 전부다 -1을 저장
		// foreach 다시 공부하기
		for (int i = 0; i < memo.length; i++) {
			memo[i] = -1;
		}

		System.out.println(count(N));
		sc.close();
	}

//	static int cnt = 0;

	public static int count(int num) {
		if (num == 1) {
			memo[num] = 0;
			return 0;
		}
		// 2나 3이라면 연산 횟수는 1
		if (num == 2 || num == 3) {
			memo[num] = 1;
			return memo[num];
		}

		// 이미 계산된 적이 있다면 바로 리턴하고
		if (memo[num] != -1)
			return memo[num];

		// 없다면 연산을 시작하자
		// num은 
		// num/3 , num/2 , num-1 중에 가장 연산 횟수가 작은 애를 골라야 해
		// /3, /2 가 되는지 일단 고려해야해
		// 가능하면 memo[] 가 -1이 아니면 걔네 가져와
		// 그리고 걔네 최솟값 비교할 거야 

		int cnt = Integer.MAX_VALUE;
		if (num % 3 == 0) {
			if (memo[num/3] == -1) {
				memo[num/3] = count(num/3);
			}
			cnt = Math.min(cnt, memo[num/3]);
		}
		if (num % 2 == 0) {
			if (memo[num/2] == -1) {
				memo[num/2] = count(num/2);
			}
			cnt = Math.min(cnt, memo[num/2]);
		}
		if (memo[num-1] == -1) {
			memo[num-1] = count(num-1);
		}
		cnt = Math.min(cnt, memo[num-1]);
		
		memo[num] = 1 + cnt;
		
		return memo[num];
		

	}
}


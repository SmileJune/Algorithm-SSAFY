package com.ssafy.ehoi;

import java.util.Scanner;

public class Day11_BOJ_2798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] cards = new int[N];
		
		for (int i = 0; i<N;i++) {
			cards[i] = sc.nextInt();
		}
		
		// 첫카드 뽑고
		int max = 0;
		for (int i = 0; i < N - 2; i++ ) {
			// 이 카드가 최댓값보다 크면 다시 뽑게 돌려보내고
			if (cards[i] >= M) continue;
			// 두 번째 카드 뽑고
			for (int j = i+1; j < N - 1; j++) {
				// 1 + 2 가 M보다 크면 다시 뽑게 돌려 보내고
				if (cards[i] + cards[j] >= M) continue;
				// 세개 다 뽑고
				for (int k = j+1 ; k < N; k++) {
					int sum = cards[i] + cards[j] + cards[k];
					
					// 이 값의 합이 맥스보다 크고 최댓값보다는 작으면 이 값을 맥스에 저장하고 출력
					if (sum <= M) {
						max = Math.max(max, sum);
					}
				}
			}
		}
		System.out.println(max);
		
		
		sc.close();
	}
}

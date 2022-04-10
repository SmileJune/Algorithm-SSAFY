package com.ssafy.ehoi;

import java.util.Scanner;

public class Day61_BOJ_P5_1725 {
	static int[] arr;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N];
		ans = 0;
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();

		divide(0, N, N);

		System.out.println(ans);

		sc.close();
	}

	private static void divide(int s, int e, int size) {
		if (s + 1 >= e) {
			conquer(s, e, e);
			return;
		}

		size /= 2;
		int mid = (s + e) / 2;
		divide(s, mid, size);
		divide(mid, e, size);
		conquer(s, mid, e);
	}

	private static void conquer(int s, int mid, int e) {
		// 사이즈가 하나 짜리면
		if (s + 1 == e) {
			ans = Math.max(ans, arr[s]);
			return;
		}

		// 밑변의 시작과 끝의 포인터를 정해두고
		int l = mid - 1, r = mid;
		int minH = Integer.MAX_VALUE;
		while (s <= l && r < e) { // 범위 조건
			if (arr[l] <= arr[r]) {
				minH = Math.min(minH, arr[l]);
			} else {
				minH = Math.min(minH, arr[r]);
			}
			ans = Math.max(ans, (r - l + 1) * minH);
			if (s == l && r + 1 == e)
				break;

			// 내가 어디로 가야 큰 넓이를 먼저 얻어올 수 있을지 고려를 해보는 것이 중요!
			if (s <= l - 1 && r + 1 < e) {
				if (arr[l - 1] >= arr[r + 1])
					l--;
				else
					r++;
			} else {
				// 그런데 결국엔 크지 않아도 가봐야 하지 않나???????
				// 아직 포인터가 끝까지 다 이동하지 않았을 수도 있잖아
				if (r + 1 < e) {
					r++;
				}

				if (s <= l - 1) {
					l--;
				}
			}

		}

	}

	// 최소높이 for문 바꾸기 : 매번 연산하는 거 좀 에바
	// idx 처리 따로 하는 거!
}

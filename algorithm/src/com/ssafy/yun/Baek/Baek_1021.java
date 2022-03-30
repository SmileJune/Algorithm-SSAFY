package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_1021 {

	static Scanner sc = new Scanner(System.in);
	static int[] arr;
	static boolean[] visited;
	static int cnt = 0;
	static int now = 1;
	static int N, M;

	public static void main(String[] args) {
		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}
		visited = new boolean[N + 1];

		visited[0] = true;

		for (int i = 0; i < M; i++) {
			int input = sc.nextInt();
			if (arr[now] == input) {
				continue;
			}
			solution(input);
		}

		System.out.println(cnt);

	}

	static void solution(int num) {
		int leftCnt = 0;
		int rightCnt = 0;

		// 오른쪽 방향
		for (int i = 0; i < N; i++) {
			// 이미 지워졌는지 확인
			int index = now + i;
			if (index > N) {
				index -= N;
			}
			if (visited[index] == true) {
				continue;
			}

			// 아니라면 체크

			if (arr[index] == num) {
				break;
			}
			rightCnt++;
		}

		for (int i = 0; i < N; i++) {
			// 이미 지워졌는지 확인
			int index = now - i;
			if (index < 1) {
				index += N;
			}
			if (visited[index] == true) {
				continue;
			}

			// 아니라면 체크

			if (arr[index] == num) {
				break;
			}
			leftCnt++;
		}

		cnt += Math.min(leftCnt, rightCnt);
		visited[num] = true;
		now = num;
	}

}

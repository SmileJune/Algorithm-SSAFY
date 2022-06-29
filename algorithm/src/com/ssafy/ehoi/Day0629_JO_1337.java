package com.ssafy.ehoi;

import java.util.Arrays;
import java.util.Scanner;

public class Day0629_JO_1337 {
	static int n, arr[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		// 방향 배열 설정
		// 오른쪽 대각선 아래, 왼쪽, 위 순
		int[] dr = { 1, 0, -1 };
		int[] dc = { 1, -1, 0 };

		// 배열을 -1로 다 채워서 visit 역할도 할 수 있도록
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(arr[i], -1);
		}

		final int MOD = 10;
		int num = 0;
		int r = 0;
		int c = 0;
		int dir = 0;

		while (true) {
			arr[r][c] = num % MOD;

			int nr = r + dr[dir];
			int nc = c + dc[dir];

			if (changeDir(nr, nc)) {
				dir = (dir + 1) % 3;
				nr = r + dr[dir];
				nc = c + dc[dir];
				if (changeDir(nr, nc)) {
					break;
				}
			}

			r = nr;
			c = nc;
			num++;
		}

		// 무한반복을 돌면서
		// 해당 배열 자리에 num을 입력하고
		// 다음 자리로 넘어갈 건데
		// 다음 자리가 입력할 수 있는 자리인지 올바른 자리인지 판단하는 메서드
		// 보통 긍정보다는 부정으로 메서드를 작성하는 것이 좋은 것 같다
		// 여기 자리 없지? 와 같은 메서드를 이용해서
		// 응 이라면 방향을 바꾸고 진행하고
		// 아니라면 그냥 진행하고

		// 로 하면 되기 때문에 무언가 행동이 필요한 조건을 메서드로 만드는 것이 깔끔

		// 근데 방향을 바꾸고도 갈 수 있는지 체크하기 위해서 여기 자리 없지? 라고 물어봄
		// 없다고 하면 다 채워진 거니까 나가야 함

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] != -1) {
					System.out.print(arr[i][j] + " ");
				}
			}
			System.out.println();
		}

		// 나가서 출력하면 됨
		// -1이 아닌 것만
		sc.close();
	}

	// 방향을 전환하는 조건 = 더이상 입력할게 없어! 조건
	// 더이상의 입력을 멈추는 조건
	private static boolean changeDir(int x, int y) {
		// 배열의 범위를 벗어났거나 해당 자리의 값이 -1이 아니라면(채워져 있다는 것이므로)
		// 방향을 전환하라는 의미로 true를 던지고
		// 아니라면 false를 던진다
		if (x < 0 || y < 0 || x >= n || y >= n || arr[x][y] != -1) {
			return true;
		}
		return false;
	}
}

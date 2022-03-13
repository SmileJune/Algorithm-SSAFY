package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day14JO1733오목 { // 1733 오목... 이거 맞아...?
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int[][] arr = new int[19][19];
		for (int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = 0;
		int r = 0;
		int c = 0;
		outer: for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (arr[i][j] != 0) {
					if (check(arr, i, j)) {
						ans = arr[i][j];
						r = i;
						c = j;
						break outer;
					}
				}
			}
		}
		if (ans != 0)
			System.out.println(ans + "\n" + (r + 1) + " " + (c + 1));
		else
			System.out.println(0);
		br.close();
	}

	private static boolean check(int[][] arr, int i, int j) {
		int r = 0;
		int c = 0;
		int l = 0;
		int rl = 0;
		int N = arr.length;
		for (int n = 0; n < 5; n++) {
			if (i + n < N && arr[i + n][j] != 0 && arr[i + n][j] == arr[i][j])
				r++;
			if (j + n < N && arr[i][j + n] != 0 && arr[i][j + n] == arr[i][j])
				c++;
			if (i + n < N && j + n < N && arr[i + n][j + n] != 0 && arr[i + n][j + n] == arr[i][j])
				l++;
			if (i > 4 && j + n < N && arr[i - n][j + n] != 0 && arr[i - n][j + n] == arr[i][j])
				rl++;
		}
		// 5칸 연속 체크는 완료했으나, 딱 5칸만 되어야하므로, 추가 확인 필요
		if (r == 5 && i > 1 && arr[i - 1][j] == arr[i][j])
			r++; // 5가 아니면 볼 필요 없고, 딱 5칸인 경우만 true이므로
		if (c == 5 && j > 1 && arr[i][j - 1] == arr[i][j])
			c++;
		if (l == 5 && (i > 1 && j > 1) && arr[i - 1][j - 1] == arr[i][j])
			l++;
		if (rl == 5 && j > 1 && arr[i + 1][j - 1] == arr[i][j])
			rl++;
		// 5칸 이후값도 확인하기. 같이 쓸 수도 있으나, 줄이 길어지므로 별도로 쓴다.
		if (r == 5 && i + 5 < N && arr[i + 5][j] == arr[i][j])
			r++;
		if (c == 5 && j + 5 < N && arr[i][j + 5] == arr[i][j])
			c++;
		if (l == 5 && (i + 5 < N && j + 5 < N) && arr[i + 5][j + 5] == arr[i][j])
			l++;
		if (rl == 5 && (i > 5 && j + 5 < N) && arr[i - 5][j + 5] == arr[i][j])
			rl++;
		// 예외처리 끝.... 이거 맞아...?
		if (r == 5 || c == 5 || l == 5 || rl == 5) {
//			System.out.println(r + " " + c + " " + l + " " + rl);
			return true;
		}
		return false;
	}
}

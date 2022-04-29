package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day81BOJ5546파스타DP3중 {
	static final int MOD = 10_000;
	static int N, K, ans;
	static int[] arr;
	static Integer[][][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = ip(st.nextToken());
		K = ip(st.nextToken());
		ans = 0;
		arr = new int[N + 1];
		Arrays.fill(arr, -1);
		dp = new Integer[N + 1][3][2];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			arr[ip(st.nextToken())] = ip(st.nextToken()) - 1;
		}
		for (int i = 0; i < 3; i++) { // 맛
			for (int j = 0; j < 2; j++) { // 연속
				ans += recur(N, i, j);
//				System.out.println("result : " + recur(N, i, j));
//				print(dp);
			}
		}
		System.out.println(ans % MOD);
		br.close();
	}

	private static int recur(int cur, int sel, int cnt) {
		if (arr[cur] != -1 && arr[cur] != sel) // cur : 현재일자, sel : 선택된 맛, cnt : 일차
			return 0; // 맛이 정해진 날짜인데, 해당 맛이 아닌경우는 경우의 수 변화 없음
		if (cur == 1) // N일차 부터 시작해서 1일차까지 내려왔을 때, 
			return cnt == 0 ? 1 : 0; // cnt - 0 : 1일차 인 경우 1, 1 : 2일차인 경우는 불가 0
		if (dp[cur][sel][cnt] != null)
			return dp[cur][sel][cnt]; // 이미 계산된 값이면 메모이제이션으로 반환
		dp[cur][sel][cnt] = 0; // Integer로 배열을 만들면 초기화 없이 null비교가 가능하다.
		int tmp = 0; 
		if (cnt == 0) { // 방문 했을 때 1일차라면, 가능한 경우의 수는
			for (int i = 0; i < 3; i++) { // i는 전날 선택할 맛
				if (i == sel) // 현재 sel이 1일차이기 때문에, 전날 맛이 같을 수 없다.
					continue;
				tmp = (tmp + recur(cur - 1, i, 0) + recur(cur - 1, i, 1)) % MOD;
			} // 해당 맛이 1일차 일때 가능한 경우의 수는 cur-1 하루전날 다른 맛 경우의 수의 총합
		} else
			tmp = recur(cur - 1, sel, 0); // 해당 맛이 2일차면 전날 1일차(0)과 경우의 수가 같다.
		return dp[cur][sel][cnt] = tmp; // 메모이제이션
	}

	static int ip(String s) { // 길어
		return Integer.parseInt(s);
	}

	private static void print(Integer[][][] a) {
		StringBuilder tt = new StringBuilder();
		for (int j = 0; j < 3; j++) {
			tt.append(j + 1 + " : ");
			for (int i = 1; i < N + 1; i++) {
				String s = "";
				tt.append(s = (a[i][j][0] + "/" + a[i][j][1]).replaceAll("ull", ""))
						.append(s.length() > 2 ? " " : "\t");
			}
			tt.append("\n");
		}
		System.out.println(tt);
	}

}
// 1. 연속으로 3일이 되는 경우는 없다.
// 2. 오늘이 연속된 맛 2일차라면, 해당 맛의 그 전날 1일차인 경우의 수와 같다.
// 3. 오늘이 맛 1일차라면, 다른 두 맛의 1, 2일차의 경우의 수의 합과 같다.
// 4. 순회 경우는 마지막날 기준 (3가지 맛) * (1일차 인지, 2일차인지)의 총합이다.
// 5. 1일차를 무작정 1/0으로 초기화 할 수 없다. 
// 
// 예제 1
// 5 : DAY // 맛을 정해놓은 날 3: [3, 1][1, 1][4, 2]
// x o x x o -- x : 고정 o : 변화
// 1 2 1 2 1
// 1 2 1 2 2 -- 연속 2일차인 경우
// 1 2 1 2 3
// 1 3 1 2 1
// 1 3 1 2 2 -- 연속 2일차인 경우
// 1 3 1 2 3
// 예제 1 result 
// 1 : n/n 0/n 2/0 n/n 2/0 -- 4일차가 2로 고정이어서 연속 1일차만 2가지 경우가 있다.
// 2 : n/n 1/0 n/n 2/0 0/2 -- 4일차가 2로 고정이어서 연속 2일차만 2가지 경우가 있다.
// 3 : n/n 1/0 n/n n/n 2/0 -- 4일차가 2로 고정이어서 연속 1일차만 2가지 경우가 있다.

// 테스트 예제
// 5 : DAY // 맛을 정해놓은 날 1 : [2, 1]
// 테스트 예제 result 
// 테스트 예제 result : 60
// 1 : n/n 2/1 0/2 6/0 16/6 
// 2 : n/n n/n 3/0 5/3 14/5 
// 3 : n/n n/n 3/0 5/3 14/5 

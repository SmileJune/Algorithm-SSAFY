package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day89BOJ11501주식배열역순회 {
	static int N;
	static long ans; // 1_000_000 * (10_000 - 2) 모든날이 2이고 마지막날 최대값
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			ans = 0;
			arr = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());

			int tmp = 0;
			for (int i = N - 1; i >= 0; i--)
				if (arr[i] > tmp)
					tmp = arr[i];
				else
					ans += tmp - arr[i];

			sb.append(ans + "\n");
		}
		System.out.println(sb);
		br.close();
	}
}
// 팔아야 하는 날을 찾는다. -> 최대값을 갖는 날을 찾는다
// 최대값인 날 전에 있는 값들은 최대값에 팔 수 있지만,
// 최대값 다음 날부터는 다른 두번째 최대값을 찾아야 한다.
// 즉, 뒤에서부터 값을 최대값으로 놓고, 
// 나보다 큰 값이 나올때까진 그 값에 팔고, 새로운 큰 값이 나오면
// 그값으로 최대값을 변경한다.
// 어서 풀었던 문제 같은데, 왜 백준 기록에 없지..
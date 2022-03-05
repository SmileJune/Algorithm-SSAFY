package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day25BOJ3078좋은친구 { // 3078
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long ans = 0;

		Queue<Integer>[] q = new Queue[21];

		for (int i = 0; i <= 20; i++) {
			q[i] = new LinkedList<>();
		}

		for (int n = 0; n < N; n++) {
			int l = br.readLine().length();

			if (q[l].isEmpty()) {
				q[l].offer(n);
				continue;
			}

			while (n - q[l].peek() > K) {
				q[l].poll();
				if (q[l].isEmpty()) {
					break;
				}
			}
			ans += q[l].size();
			q[l].offer(n);
		}
		System.out.println(ans);
		br.close();
	}
}

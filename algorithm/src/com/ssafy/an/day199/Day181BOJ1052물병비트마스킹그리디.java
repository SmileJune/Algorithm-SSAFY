package com.ssafy.an.day199;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Day181BOJ1052물병비트마스킹그리디 {
	static int N, K, idx, ans;
	static boolean[] check;
	static List<Integer> flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");

		N = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1]);

		check = new boolean[24];
		flag = new ArrayList<>();

		idx = 0;

		while (true) {
			int rem = N % 2;
			N /= 2;
			if (rem == 1) {
				check[idx] = true;
				flag.add(idx);
			}
			if ((N + flag.size()) <= K) {
				System.out.print(0);
				return;
			}
			if (N == 1) {
				check[idx + 1] = true;
				flag.add(idx + 1);
				break;
			}
			idx++;
		}

		ans = 1;
		for (int i = flag.get(flag.size() - K); i >= 0; i--) {

			if (!check[i]) {
				ans += Math.pow(2, i);
			}
		}
		System.out.print(ans);
		br.close();
	}
}

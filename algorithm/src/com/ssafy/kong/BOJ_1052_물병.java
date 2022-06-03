package com.ssafy.BOJ_SB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1052_물병 {
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int pls = 0;
		while (true) {

			int tmp = N + pls;
			int count = 0;

			while (tmp > 0) {

				if (tmp % 2 != 0)
					count++;
				tmp /= 2;

			}

			if (count <= K)
				break;

			pls++;
		}

		System.out.println(pls);
	}
}

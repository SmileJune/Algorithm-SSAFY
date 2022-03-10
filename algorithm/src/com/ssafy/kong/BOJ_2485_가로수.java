package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2485_가로수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] tree = new int[N];
		for (int i = 0; i < N; ++i) {
			tree[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(tree);
		int[] dif = new int[N - 1];
		for (int i = 1; i < N; ++i) {
			dif[i - 1] = tree[i] - tree[0];
		}
		int treeDif = 0;
		outer : for (int i = dif[0]; i >= 1; --i) {
			for(int j = 0; j < N-1; j++) {
				if(dif[j] % i != 0) {
					continue outer;
				}
			}
			treeDif = i;
			break;
		}
		System.out.println(((tree[N-1]-tree[0])/treeDif - 1) - (N-2));
	}
}
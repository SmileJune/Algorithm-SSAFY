package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q6588골드바흐 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				System.out.println(sb);
				return;
			}
			int[] arr = new int[1000000];
			int[] prime = new int[1000000];
			for (int i =2; i<1000000; i++) {
				arr[i] = i;
			}
			for (int i =2; i<1000000; i++) {
				if (arr[i] == 0) continue;
				for (int j = i+i; j<1000000; j+=i) {
					arr[j] = 0;
				}
			}
			int idx = 0;
			for (int i = 3; i<1000000; i++) {
				if (arr[i] != 0) {
					prime[idx] = arr[i];
					idx++;
				}
					
			}
			sb.append(num + " = " + Goldbach(num, prime)).append("\n");

		}

	}

	public static String Goldbach(int num, int[] prime) {
		int[] gold = new int[2];
		String str;
		outer: for (int i = 0; i < prime.length; i++) {
			for (int j = i; j < prime.length; j++) {
				if (prime[i] + prime[j] == num) {
					gold[0] = prime[i];
					gold[1] = prime[j];
					break outer;
				}
			}
		}
		str = gold[0] + " + " + gold[1];
		return str;
	}
}

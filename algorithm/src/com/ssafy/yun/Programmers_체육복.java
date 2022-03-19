package com.ssafy.yun;

public class Programmers_체육복 {

	public static void main(String[] args) {
		Programmers_체육복 q;
		q = new Programmers_체육복();
		int[] arr = { 2, 4 };
		int[] arr2 = { 1, 3, 5 };
		System.out.println(q.solution(5, arr, arr2));

	}

	public int solution(int n, int[] lost, int[] reserve) {
		int[] lostArr = new int[n + 2];
		int[] reserveArr = new int[n + 2];

		for (int i = 0; i < lost.length; i++) {
			lostArr[lost[i]]++;
		}
		for (int i = 0; i < reserve.length; i++) {
			reserveArr[reserve[i]]++;
		}

		int recovery = 0;
		for (int i = n; i >= 1; i--) {
			if (lostArr[i] == 0) {
				continue;
			}

			if (reserveArr[i] == 1) {
				recovery++;
				reserveArr[i]--;
				lostArr[i]--;
			}
		}

		for (int i = n; i >= 1; i--) {
			if (lostArr[i] == 0) {
				continue;
			}

			if (reserveArr[i + 1] == 1) {
				recovery++;
				reserveArr[i + 1]--;
				continue;
			}
			if (reserveArr[i - 1] == 1) {
				recovery++;
				reserveArr[i - 1]--;
				continue;
			}
		}

		return n - lost.length + recovery;
	}

}

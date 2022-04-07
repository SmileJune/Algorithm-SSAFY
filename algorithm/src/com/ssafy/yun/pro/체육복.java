package com.ssafy.yun.pro;

public class 체육복 {
	public static void main(String[] args) {
		int n = 5;
		int[] lost = { 2, 4 };
		int[] reserve = { 1, 3, 5 };
		System.out.println(solution(n, lost, reserve));
	}

	public static int solution(int n, int[] lost, int[] reserve) {
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

package com.ssafy.an.day149;

import java.util.Scanner;

public class Day116SW4311오래된스마트폰A형교안답안 {
	static int N, O, M;
	static int targetNum;
	static int joCnt;
	static int[] nums, best, johap, used, johapNumCnt, johapUsed;
	static char[] opers;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			nums = new int[11];
			best = new int[1000];
			used = new int[1000];
			johap = new int[1000];
			johapNumCnt = new int[1000];
			johapUsed = new int[1000];
			opers = new char[5];

			N = sc.nextInt();
			O = sc.nextInt();
			M = sc.nextInt();

			for (int i = 0; i < N; i++)
				nums[i] = sc.nextInt();

			for (int i = 0; i < O; i++) {
				int t = sc.nextInt();
				if (t == 1)
					opers[i] = '+';
				if (t == 2)
					opers[i] = '-';
				if (t == 3)
					opers[i] = '*';
				if (t == 4)
					opers[i] = '/';
			}
			targetNum = sc.nextInt();
			// 입력 끝
			getJohap();
			init();

			int ret = 0;
			if (best[targetNum] != 99)
				ret = best[targetNum];
			else {
				for (int i = 0; i < joCnt; i++) {
					getMinTouchCnt(johapNumCnt[i], johap[i]);
				}
				ret = best[targetNum] + 1;
			}

			if (best[targetNum] == 99)
				ret = -1;
			System.out.println("#" + tc + " " + ret);
		}
		sc.close();
	}

	static void init() {
		for (int i = 0; i < 1000; i++) {
			best[i] = 99;
			used[i] = 0;
		}
		for (int i = 0; i < joCnt; i++) {
			int num = johap[i];
			best[num] = johapNumCnt[i];
		}
	}

	static int getCalResult(int a, char oper, int b) {
		if (oper == '*')
			return a * b;
		if (oper == '-')
			return a - b;
		if (oper == '/')
			return a / b;
		return a + b;
	}

	static void getMinTouchCnt(int touchCnt, int now) {
		for (int x = 0; x < O; x++) {
			for (int i = 0; i < joCnt; i++) {
				int num = johap[i];
				int nextCnt = touchCnt + johapNumCnt[i] + 1;
				if (nextCnt > M - 1)
					break;
				if (opers[x] == '/' && num == 0)
					continue;
				int next = getCalResult(now, opers[x], num);

				if (opers[x] == '+' && next > 999)
					break;
				if (opers[x] == '-' && next < 0)
					break;
				if (opers[x] == '*' && next > 999)
					break;
				if (used[next] == 1)
					continue;
				if (best[next] <= nextCnt)
					continue;

				best[next] = nextCnt;
				used[next] = 1;
				getMinTouchCnt(nextCnt, next);
				used[next] = 0;
			}
		}
	}

	static void getJoHapDFS(int lev, int sum) {
		for (int i = 0; i < N; i++) {
			int next = sum * 10 + nums[i];
			if (next > 999)
				continue;
			if (johapUsed[next] == 1)
				continue;
			johapUsed[next] = 1;
			getJoHapDFS(lev + 1, next);
		}
	}

	static void getJohap() {
		for (int i = 0; i < 1000; i++) {
			johap[i] = 0;
			johapUsed[i] = 0;
			johapNumCnt[i] = 0;
		}
		joCnt = 0;
		getJoHapDFS(0, 0);
		for (int i = 0; i < 1000; i++) {
			if (johapUsed[i] == 0)
				continue;
			johap[joCnt] = i;
			if (i < 10)
				johapNumCnt[joCnt] = 1;
			else if (i < 100)
				johapNumCnt[joCnt] = 2;
			else if (i < 1000)
				johapNumCnt[joCnt] = 3;
			joCnt++;
		}
	}

}

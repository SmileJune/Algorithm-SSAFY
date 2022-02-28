package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class newEmployee implements Comparable<newEmployee> {
	int document = 0;
	int interview = 0;

	public newEmployee(int document, int interview) {
		this.document = document;
		this.interview = interview;
	}

	@Override
	public int compareTo(newEmployee o) {
		if (this.document > o.document) {
			return 1;
		} else {
			return -1;
		}
	}
}

public class BOJ_1964_신입사원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; ++t) {
			int N = Integer.parseInt(br.readLine());
			newEmployee[] ne = new newEmployee[N];
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				int document = Integer.parseInt(st.nextToken());
				int interview = Integer.parseInt(st.nextToken());
				ne[i] = new newEmployee(document, interview);
			}
			// 적어도 하나가 다른 지원자보다 떨어지지 않아야 함.
			// A의 성적이 B의 성적에 비해 서류 심사 결과와 면접 성적이 모두 떨어진다면 A는 결코 선발되지 않는다
			Arrays.sort(ne);
			int min = ne[0].interview;			
			int ans = 1;
			for (int i = 1; i < N; ++i) {
				if (min > ne[i].interview) {
					ans++;
					min = ne[i].interview;
				}
			}
			System.out.println(ans);
		}
	}
}
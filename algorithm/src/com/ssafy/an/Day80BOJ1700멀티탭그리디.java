package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Day80BOJ1700멀티탭그리디 { // 1700 multi-tap scheduling 구현
	static int N, K, ans;
	static Integer[] seq;
	static List<Integer> tap;
	static LinkedList<Integer> tmp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		ans = 0;
		seq = new Integer[K];
		tap = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++)
			seq[i] = Integer.parseInt(st.nextToken());

		// 이미 사용중인 기기면 통과
		// 사용중이 아니고, 멀티탭에 자리가 있으면 사용
		// 사용중이 아니고, 멀티탭이 모두 사용중이면,
		// 더이상 사용하지 않거나, 가장 나중에 재사용할 기기와 교체, 답증가

		for (int k = 0; k < K; k++) {
			int cur = seq[k];
			if (tap.indexOf(cur) != -1)
				continue; // tap에 없는 seq값이면 -1, 있으면 통과
			if (tap.size() < N)
				tap.add(cur); // 자리가 있으면 추가
			else { // 자리가 없으면 후보군을 그리디적으로 선정
				tmp = new LinkedList<>();
				tmp.addAll(tap); // 뽑을 후보군 선정

				int n = k + 1; // 현재 꽂아야 할 k보다 뒤에 값들 탐색 idx
				while (tmp.size() > 1 && n < K)
					tmp.remove(seq[n++]);
				
				tap.set(tap.indexOf(tmp.getFirst()), cur);
				ans++;
			}
		}
		System.out.println(ans);
		br.close();
	}
}

package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Day114BOJ1092배ArrayList { // 1092 배
	static int N, M, ans;
	static ArrayList<Integer> crn, box;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		crn = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			crn.add(Integer.parseInt(st.nextToken()));
		Collections.sort(crn, Collections.reverseOrder());

		M = Integer.parseInt(br.readLine());
		box = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++)
			box.add(Integer.parseInt(st.nextToken()));
		Collections.sort(box, Collections.reverseOrder());

		if (box.get(0) > crn.get(0)) // 가장 큰 수를 보고 불가능 체크를 한다.
			ans = -1;
		else {
			ans = 0;
			while (!box.isEmpty()) {
				int idx = 0; // 이부분 구선생님 도움.. 원래 pq로 box 만들었는데,
				for (int i = 0; i < N; i++) {
					if (idx == box.size())
						break; 
					if (box.get(idx) <= crn.get(i))
						box.remove(idx);
					else {
						idx++;
						i--; // 지금 크레인 안썼으니 상자만 인덱스 이동
					}
				}
				ans++;
			}
		}

		System.out.println(ans);
		br.close();
	}
}

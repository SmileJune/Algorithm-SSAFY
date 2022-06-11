package com.ssafy.BOJ_GD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1092_배 {


	static int N; // 크레인 개수
	static int M; // 박스의 수
	static ArrayList<Integer> crane = new ArrayList<>();
	static ArrayList<Integer> box = new ArrayList<>();
	static int count = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++)
			crane.add(Integer.parseInt(st.nextToken()));

		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++)
			box.add(Integer.parseInt(st.nextToken()));

		Collections.sort(crane, Collections.reverseOrder());
		Collections.sort(box, Collections.reverseOrder());

		if (crane.get(0) < box.get(0)) {
			System.out.println("-1");
		} else {
			while (box.size() > 0) {
				int boxSize = 0;
				for (int i = 0; i < box.size(); i++) {
					if (boxSize == N)
						break;

					if (crane.get(boxSize) >= box.get(i)) {
						boxSize++;
						box.remove(i);
						if (box.size() == 0)
							break;
						i = i - 1;
					}
				}
				count++;
			}

			System.out.println(count);
		}
	}

}

package com.ssafy.an;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day8BOJ10825Fail국영수 { // 10825 그냥 순회로는 무조건 시간초과...
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream("C:/SSAFY/study_workspace/algorithm/src/com/ssafy/an/data/input10825.txt")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		String[][] persons = new String[N][4];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			persons[n][0] = st.nextToken();
			persons[n][1] = st.nextToken();
			persons[n][2] = st.nextToken();
			persons[n][3] = st.nextToken();
		}
		for (int n = 0; n < N; n++) {
			for (int i = 0; i < N - 1; i++) {
				for (int j = i; j < N - 1; j++) {
					if (Integer.parseInt(persons[j][1]) < Integer.parseInt(persons[j + 1][1])) {
						String[] temp = persons[j];
						persons[j] = persons[j + 1];
						persons[j + 1] = temp;
					} else if (Integer.parseInt(persons[j][1]) == Integer.parseInt(persons[j + 1][1])) {
						if (Integer.parseInt(persons[j][2]) > Integer.parseInt(persons[j + 1][2])) {
							String[] temp = persons[j];
							persons[j] = persons[j + 1];
							persons[j + 1] = temp;
						} else if (Integer.parseInt(persons[j][2]) == Integer.parseInt(persons[j + 1][2])) {
							if (Integer.parseInt(persons[j][3]) < Integer.parseInt(persons[j + 1][3])) {
								String[] temp = persons[j];
								persons[j] = persons[j + 1];
								persons[j + 1] = temp;
							} else if (Integer.parseInt(persons[j][3]) == Integer.parseInt(persons[j + 1][3])) {
								if (persons[j][0].charAt(0) > persons[j + 1][0].charAt(0)) {
									String[] temp = persons[j];
									persons[j] = persons[j + 1];
									persons[j + 1] = temp;
								}
							}
						}
					}
				}
			}
		}
		for (int n = 0; n < N; n++) {
			System.out.println(persons[n][0]);
		}

		System.out.println(sb);
		br.close();
	}
}
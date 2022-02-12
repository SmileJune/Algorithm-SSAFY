package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Day5MainSolution10814 { // 10814 나이순 이름 정렬, 나이가 같으면 등록순
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		String[][] nameArr = new String[N][2];
		for (int t = 0; t < N; t++) {
			st = new StringTokenizer(br.readLine());
			nameArr[t][0] = st.nextToken();
			nameArr[t][1] = st.nextToken();
		}

//		for (int i = N - 1; i >= 0; i--) {
//			for (int j = 0; j < i; j++) {
//				if (Integer.parseInt(nameArr[j][0]) > Integer.parseInt(nameArr[j + 1][0])) {
//					String[] temp = nameArr[j];
//					nameArr[j] = nameArr[j + 1];
//					nameArr[j + 1] = temp;
//				}
//			}
//		} // 아직 우리가 배운 정렬로는 백준 문제를 풀 수 없습니다..

		Arrays.sort(nameArr, new Comparator<String[]>() {
			@Override
			public int compare(String[] nameArr1, String[] nameArr2) {
				return Integer.parseInt(nameArr1[0]) - Integer.parseInt(nameArr2[0]);
			}
		});
		
		for (int i = 0; i < N; i++)
			sb.append(nameArr[i][0]).append(" ").append(nameArr[i][1]).append("\n");

		System.out.println(sb);
	}
}

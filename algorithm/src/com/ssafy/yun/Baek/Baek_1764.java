package com.ssafy.yun.Baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baek_1764 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String[] arrN = new String[N];
		for (int i = 0; i < N; i++) {
			arrN[i] = br.readLine();
		}

		String[] arrM = new String[M];
		for (int i = 0; i < M; i++) {
			arrM[i] = br.readLine();
		}

		Arrays.sort(arrN);
		Arrays.sort(arrM);

		List<String> list = new ArrayList<>();

		int idxN = 0;
		int idxM = 0;
		while (true) {
			// 먼저 인덱스 확인 후 벗어나면 break;
			if (!(0 <= idxN && idxN < N && 0 <= idxM && idxM < M)) {
				break;
			}

			// 같은것이 있으면 리스트에 추가하고 인덱스 둘다 증가
			if (arrN[idxN].equals(arrM[idxM])) {
				list.add(arrN[idxN]);
				idxN++;
				idxM++;
				continue;
			}

			// arrN이 더 크면 idxM++;
			if (arrN[idxN].compareTo(arrM[idxM]) > 0) {
				idxM++;
				continue;
			}

			// arrM이 더 크면 idxN++;
			if (arrN[idxN].compareTo(arrM[idxM]) < 0) {
				idxN++;
				continue;
			}
		}

		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}

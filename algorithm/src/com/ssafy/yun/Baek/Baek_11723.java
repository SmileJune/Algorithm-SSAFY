package com.ssafy.yun.Baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_11723 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int[] arr = new int[21];

	public static void main(String[] args) throws NumberFormatException, IOException {
		int M = Integer.parseInt(br.readLine());

		for (int i = 1; i <= M; i++) {
			check();
		}
		bw.close();
	}

	static void check() throws IOException {
		st = new StringTokenizer(br.readLine());
		String order = st.nextToken();
		int num = 0;
		if (st.hasMoreTokens()) {
			num = Integer.parseInt(st.nextToken());
		}

		switch (order) {
		case "add":
			arr[num]++;
			break;
		case "remove":
			arr[num] = 0;
			break;
		case "check":
			bw.write((arr[num] == 0 ? 0 : 1) + "\n");
//			bw.write(ans);
//			bw.write("\n");
			break;
		case "toggle":
			if (arr[num] == 0) {
				arr[num] = 1;
			} else {
				arr[num] = 0;
			}
			break;
		case "all":
			for (int i = 0; i < arr.length; i++) {
				arr[i] = 1;
			}
			break;
		case "empty":
			arr = new int[21];
			break;
		}

	}

}

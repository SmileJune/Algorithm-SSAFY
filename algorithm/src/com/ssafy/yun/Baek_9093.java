package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_9093 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			solution();
		}
		bw.close();
	}

	public static void solution() throws IOException {
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreElements()) {
			String str = st.nextToken();
			StringBuffer sb = new StringBuffer(str);
			sb = sb.reverse();
			bw.write(sb.toString() + " ");
		}
		bw.write("\n");

	}

}

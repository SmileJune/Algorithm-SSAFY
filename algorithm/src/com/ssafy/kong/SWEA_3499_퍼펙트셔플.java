package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author 숩니
 *
 */
public class SWEA_3499_퍼펙트셔플 {
	/**
	 * 
	 */
	private String msg;
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; ++t) {
			StringBuilder sb = new StringBuilder();
			int N = Integer.parseInt(br.readLine());
			String[] card = new String[N];
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; ++i) {
				card[i] = st.nextToken();
			}

			Queue<String> q1 = new LinkedList<>();
			Queue<String> q2 = new LinkedList<>();

			for (int i = 0; i < (N + 1) / 2; ++i) {
				q1.offer(card[i]);
			}
			for (int i = (N + 1) / 2; i < N; ++i) {
				q2.offer(card[i]);
			}

			while (!q1.isEmpty()) {
				sb.append(q1.poll()).append(" ");
				if (!q2.isEmpty())
					sb.append(q2.poll()).append(" ");
			}
			System.out.print("#" + t + " ");
			System.out.println(sb);
		}
	}
}
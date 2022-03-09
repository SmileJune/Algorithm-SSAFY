package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1107_리모컨 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		ArrayList<Integer> troubleButton = new ArrayList<Integer>();

		for (int i = 0; i < M; i++) {
			int but = Integer.parseInt(st.nextToken());
			troubleButton.add(but);

		}
		int ans = Math.abs(100 - N);
		int mini = 987654321;
		int cnt = 0;
		for (int i = 0; i <= 999999; i++) {

			String str = String.valueOf(i);
			boolean chk = true;
			for (int k = 0; k < str.length(); k++) {
				if (troubleButton.contains(str.charAt(k) - '0')) {
					chk = false;
					break;
				}
			}
			if (chk == false)
				continue;

			cnt = str.length() + Math.abs(i - N);

			if (cnt < mini) {
				mini = cnt;
			}
		}
		if (mini < ans)
			ans = mini;
		System.out.println(ans);
	}
}

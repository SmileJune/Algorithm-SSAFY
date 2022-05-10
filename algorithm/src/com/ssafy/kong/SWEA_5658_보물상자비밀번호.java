package com.ssafy.SWEA_SW모의;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class SWEA_5658_보물상자비밀번호 {
	static int N, K, len;
	static Deque<Character> box;
	static Object[] secretBox;
	static List<Integer> ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			box = new ArrayDeque<>();
			ans = new ArrayList<>();
//			secretBox = br.readLine().toCharArray();
			// 박스를 저장해볼까?
			String str = br.readLine();
			for (int i = 0; i < str.length(); ++i) {
				box.addLast(str.charAt(i));
			}
			len = box.size();
			secretBox = box.toArray();
			solution();
			// 회전을 몇번해야하게? K/4정도 해야겠지?
			for (int i = 1; i <= len/4; ++i) {
				rotate();
			}
			Collections.sort(ans, Collections.reverseOrder());
			ans = ans.stream().distinct().collect(Collectors.toList());

			System.out.println("#" + t + " " + ans.get(K-1));
		}

	}

	private static void solution() {
		char[] now = new char[len / 4];
		int idx = 0;
		for (int i = 1; i <= len; ++i) {
			now[idx++] = (char) secretBox[i - 1];
			if (i % (len / 4) == 0) {
				idx = 0;
				ans.add(calToTen(now));
			}
		}

	}

	private static int calToTen(char[] now) {
		int num = 0;
		for (int i = 0; i < now.length; ++i) {
			if (now[i] >= '0' && now[i] <= '9') {
				num += (now[i] - '0') * Math.pow(16, now.length - 1 - i);
			} else {
				num += (now[i] - 'A' + 10) * Math.pow(16, now.length - 1 - i);
			}
		}
		return num;
	}

	private static void rotate() {
		char end = box.removeLast();
		box.addFirst(end);
		secretBox = box.toArray();
		solution();
	}
}

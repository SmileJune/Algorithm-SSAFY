package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Conference implements Comparable<Conference> {
	int start;
	int end;

	public Conference(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Conference o) {
		if (this.end > o.end)
			return 1;
		else if (this.end < o.end)
			return -1;
		else {
			return this.start - o.start;
		}
	}

}

public class BOJ_1931_회의실배정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Conference[] con = new Conference[N];
		StringTokenizer st;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			con[i] = new Conference(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(con);
		/*
		 * for(int i = 0; i < N; ++i) { System.out.println("start : " + con[i].start +
		 * ", end : " + con[i].end ); }
		 */
		int cnt = 1;
		int tmp = con[0].end;
		for (int i = 1; i < N; ++i) {
			if (con[i].start >= tmp) {
				tmp = con[i].end;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
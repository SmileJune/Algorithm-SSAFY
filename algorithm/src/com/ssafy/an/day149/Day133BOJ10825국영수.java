package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Day133BOJ10825국영수 { // 10825
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		PriorityQueue<student> q = new PriorityQueue<student>();

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int mat = Integer.parseInt(st.nextToken());
			q.add(new student(kor, eng, mat, name));
		}
		while (!q.isEmpty()) {
			student tmp = q.poll();
			sb.append(tmp.name).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}

class student implements Comparable<student> {
	int kor, eng, mat;
	String name;

	@Override
	public int compareTo(student o) {
		if (this.kor == o.kor) {
			if (this.eng == o.eng) {
				if (this.mat == o.mat)
					return this.name.compareTo(o.name);
				return o.mat - this.mat;
			}
			return this.eng - o.eng;
		}
		return o.kor - this.kor;
	}

	public student(int kor, int eng, int mat, String name) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.name = name;
	}
}
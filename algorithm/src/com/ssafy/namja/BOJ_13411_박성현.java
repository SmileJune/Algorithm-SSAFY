package com.ssafy.namja;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_13411_박성현 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Robot[] order = new Robot[N]; 
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			double t = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) / v;
			order[i] = new Robot(i + 1, t);
		}
		
		Arrays.sort(order, new Comparator<Robot>(){
			public int compare(Robot r1, Robot r2) {
				double t1 = r1.getTime();
				double t2 = r2.getTime();
				if (t1 == t2) {
					int n1 = r1.getNum();
					int n2 = r2.getNum();
					return n1 > n2 ? 1 : (n1 < n2 ? -1 : 0);
				}
				return t1 > t2 ? 1 : (t1 < t2 ? -1 : 0);
			}
		});
		
		for (int i = 0; i < N; i++) {
			bw.write(order[i].getNum() + "\n");
		}
		
		bw.flush();
	}
}
class Robot {
	int num;
	double time;
	public Robot(int num, double time) {
		this.num = num;
		this.time = time;
	}
	public double getTime() { return time; }
	public int getNum( ) { return num; }
}
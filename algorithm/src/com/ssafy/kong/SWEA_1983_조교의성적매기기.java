package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
class Student {
	int mid;
	int fin;
	int ass;
	int num;
	double sum;
	public Student(int mid, int fin, int ass, int num) {
		this.num = num;
		this.mid = mid;
		this.fin = fin;
		this.ass = ass;
		this.sum = mid*0.35 + fin*0.45 + ass*0.2;
	}
}

public class SWEA_1983_조교의성적매기기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; ++t) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			Student[] stu = new Student[N];
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				stu[i] = new Student(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i+1);
			}
			Arrays.sort(stu, new Comparator<Student>() {
				@Override
				public int compare(Student o1, Student o2) {
					if(o1.sum > o2.sum) return -1;
					else if(o1.sum < o2.sum) return 1;
					else return (int)(o1.sum - o2.sum);
				}
			});
			int r = N/10;
			String[] grade = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
			
			for(int i = 0; i < N; ++i) {
				if(stu[i].num == K) {
					System.out.println("#" + t + " " + grade[i/r]);
				}
			}
			
		}
	}
}
package com.ssafy.hong;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj2166 {
	/**
	 * [BOJ: 2166] 다각형의 면적 꼭지점들이 다각형을 이루는 순서대로 입력 들어옴 다각형의 넓이를 구하라. 소수점 아래 둘째자리에서
	 * 반올림하여 첫째 자리까지 출력 input: N N각형 x y 좌표 .. output: ans 넓이
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Point> pointList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			pointList.add(new Point(sc.nextInt(), sc.nextInt()));
		}
		double sum = 0;
		for (int i = 0; i < N - 2; i++) {
			sum += getArea(pointList.get(0), pointList.get(i + 1), pointList.get(i + 2));
		}
		System.out.printf("%.1f", Math.abs(sum));
	}

	static double getArea(Point p1, Point p2, Point p3) {
		double ans = 0;
		double vx1 = p2.x - p1.x, vy1 = p2.y - p1.y, vx2 = p3.x - p2.x, vy2 = p3.y - p2.y;
		ans = vx1 * vy2 - vy1 * vx2;
		return ans / 2;
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

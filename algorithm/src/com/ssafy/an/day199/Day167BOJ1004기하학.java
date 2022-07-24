package com.ssafy.an.day199;

public class Day167BOJ1004기하학 {
	static boolean enclosed(int x, int y, int cx, int cy, int r) {
		return (x - cx) * (x - cx) + (y - cy) * (y - cy) < r * r;
	}

	public static void main(String args[]) throws Exception {
		int T = readInt();
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int x1 = readInt(), y1 = readInt();
			int x2 = readInt(), y2 = readInt();
			int n = readInt();
			int cnt = 0;
			while (n-- > 0) {
				int cx = readInt(), cy = readInt(), r = readInt();
				if (enclosed(x1, y1, cx, cy, r) ^ enclosed(x2, y2, cx, cy, r))
					cnt++;
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}

	static int readInt() throws Exception {
		int sum = 0;
		boolean isNegative = false;
		while (true) {
			int input = System.in.read();
			if (input == '\n' || input == ' ')
				return isNegative ? sum * -1 : sum;
			else if (input == '-')
				isNegative = true;
			else
				sum = (sum * 10) + input - '0';
		}
	}
}
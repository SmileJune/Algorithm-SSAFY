package com.ssafy.an.day199;

public class Day182BOJ1072승률이분탐색BESTSol { // 1072 승률 이분탐색 BRST SOL
	public static void main(String args[]) throws Exception {
		long x = readLong();
		long y = readLong();
		long z = (long) ((double) y * 100) / x + 1;
		if (z >= 100)
			System.out.println(-1);
		else
			System.out.println((int) Math.ceil((double) (x * z - 100 * y) / (100 - z)));
	}

	static long readLong() throws Exception {
		long n = 0;
		boolean isNegative = false;
		while (true) {
			int input = System.in.read();
			if (input <= 32)
				return isNegative ? n * -1 : n;
			else if (input == '-')
				isNegative = true;
			else
				n = (n << 3) + (n << 1) + (input & 15);
		}
	}
}

package com.ssafy.an.day099;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day90BOJ13976행렬곱분할정복DP타일채우기2 { // 13976 타일 채우기 2 이지만, 분할정복이 더 중요한 문제
	static final long MOD = 1_000_000_007;
	static long N, ans; // 구선생님 도움 long타입의 배열은 못만듬
	static long[] bc = { 3, 1 }; // d[2] , d[0]

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Long.parseLong(br.readLine());
		if (N % 2 != 0)
			ans = 0L;
		else if (N == 2)
			ans = 3L;
		else {
			ans = mul(pow(new long[][] { { 4, -1 }, { 1, 0 } }, N / 2 - 1), bc);
		}
		System.out.println(ans);
		br.close();
	}

	private static long[][] pow(long[][] matrix, long n) {
		if (n == 1)
			return matrix;
		else if (n % 2 == 0) {
			long[][] tmp = pow(matrix, n / 2);
			return mul(tmp, tmp);
		} else
			return mul(pow(matrix, n - 1), matrix);
	}

	private static long[][] mul(long[][] a, long[][] b) { // MultiMatrix 2x2 * 2x2
		long[][] tmp = new long[2][2];
		tmp[0][0] = get(a[0][0], b[0][0], a[0][1], b[1][0]);
		tmp[0][1] = get(a[0][0], b[0][1], a[0][1], b[1][1]);
		tmp[1][0] = get(a[1][0], b[0][0], a[1][1], b[1][0]);
		tmp[1][1] = get(a[1][0], b[0][1], a[1][1], b[1][1]);
		return tmp;
	}
	// (1 2) - (a[0][0]*b[0][0]+a[0][1]*b[1][0] a[0][0]*b[0][1]+a[0][1]*b[1][1])
	// (3 4) - (a[1][0]*b[0][0]+a[1][1]*b[1][0] a[1][0]*b[0][1]+a[1][1]+b[1][1])

	private static long mul(long[][] a, long[] b) { // MultiMatrix 2x2 * 2x1
		return get(a[0][0], b[0], a[0][1], b[1]);
	}
	// 원래 식은 long[]으로 반환되며,
	// (d[ n ]) = a[0][0]*b[0] + a[0][1]*b[1]
	// (d[n-2]) = a[1][0]*b[0] + a[1][1]*b[1] 이지만, d[n]만 반환

	private static long get(long a, long b, long c, long d) { // 행렬 곱 + 음수 처리 + MOD
		return ((a * b % MOD) + (c * d % MOD) + MOD) % MOD;
	}
	// 원래 식은 a * b + c * d 인데 행렬에 -1값 때문에 음수가 나올 수 있어
	// MOD를 더해서 나머지를 유지한다.

}
// 2133 문제의 점화식은 dp[n] = dp[n-2]*3 + 2(dp[n-4] ~ dp[n-n])
// d[4] = 3*d[2] + 2*d[0]
// d[6] = 3*d[4] + 2*d[2] + 2*d[0]
// ---- = 3*d[4] + 2*d[2] + 2*d[0] + d[2] - d[2]
// ---- = 3*d[4] + 3*d[2] + 2*d[0] - d[2]
// ---- = 3*d[4] + d[4] - d[2]
// ---- = 4*d[4] - d[2] (4*d[n-2] - d[n-4])
// d[8] = 3*d[6] + 2*d[4] + 2*d[2] + 2*d[0]
// ---- = 3*d[6] + 2*d[4] + 2*d[2] + 2*d[0] + d[4] - d[4]
// ---- = 3*d[6] + 3*d[4] + 2*d[2] + 2*d[0] - d[4]
// ---- = 3*d[6] + d[6] - d[4]
// ---- = 4*d[6] - d[4]
// d[n] = 4d[n-2] - d[n-4] <<-- 최종식
// 행렬식
// d[4] = 4*d[2] - d[0]
// d[2] = d[2] 0
// (d[4]) - (4 -1)(d[2])
// (d[2]) - (1 _0)(d[0]) //행렬식...
// ----
// (d[6]) - (4 -1)^2(d[2])
// (d[4]) - (1 _0)__(d[0])
// ----
// (d[8]) - (4 -1)^3(d[2])
// (d[6]) - (1 _0)__(d[0])
// ----
// (d[10]) - (4 -1)^4(d[2])
// (_d[8]) - (1 _0)__(d[0])
// ----
// (d[ n ]) - (4 -1)^((n/2)-1)(d[2])
// (d[n-2]) - (1 _0)__________(d[0]) // 지수형 행렬식 -> 거듭제곱의 분할정복
// ----
// 행렬의 곱
// (a b)(i j) -\ (a * i + b * k  a * j + b * l)
// (c d)(k l) -/ (c * i + d * k  c * j + d * l)
// (a b)( i ) -\ (a * i + b * j)
// (c d)( j ) -/ (c * i + d * j)
// (___)( | ) 
// (___)( | ) 가로 세로 곱이라고 하면 기억이 나려나...

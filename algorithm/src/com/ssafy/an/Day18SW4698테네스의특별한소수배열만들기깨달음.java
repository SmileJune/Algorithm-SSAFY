package com.ssafy.an;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day18SW4698테네스의특별한소수배열만들기깨달음 { // 4698 테네스의 특별한 소수
	static boolean[] notPrimes;
	static int max = 1000000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("data/an/input4698.txt")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		// 소수 배열 만들기, 1번만 만들어서 재사용
		notPrimes = new boolean[max + 1];
		notPrimes[0] = notPrimes[1] = true;
		for (int i = 2; i * i < max + 1; i++) {
			if (!notPrimes[i]) {
				for (int j = i * i; j < max + 1; j += i) {
					notPrimes[j] = true;
				}
			}
		} // 이해했다. i+i가 아니라 i*i부터 하는 이유 
		// -> i = 5인경우에 이미 2i, 3i, 4i 모두 지워진 상태, 본인의 값인 5i부터 시작하면 됨.
		// -> 따라서 시작점인 i*i가 max보다 작은 범위에서만 체크했다면 j조건문에서 이미 배수들이 모두 사라진 상태임. 
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int cnt = 0;
			for (int i = A; i <= B; i++) {
				if (notPrimes[i])
					continue;
				if (!(i + "").contains(D + ""))
					continue;
				cnt++;
			}

			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}

		System.out.println(sb);
		br.close();
	}

}

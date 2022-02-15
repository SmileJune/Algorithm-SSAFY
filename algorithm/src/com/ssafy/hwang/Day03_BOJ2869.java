package com.ssafy.hwang;
/*
 * [BOJ2869 달팽이는 올라가고싶다(B1)]
 * 
 * 낮에 A만큼 올라가고, 밤에 B만큼 내려간다.
 * 최초로 V이상 올라가기 위해서는 몇일이 걸리는지 찾아내는 문제 .
 * 
 * 시간제한이 짧기때문에 반복문을 돌려서 days를 찾지 못한다.
 * 관계식을 세우고 한번에 days를 구했다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day03_BOJ2869 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int plus = Integer.parseInt(st.nextToken());
		int minus = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		
		int days = (height - plus) / (plus - minus) + 1;
		
		if((height - plus) % (plus - minus)!=0) {
			days++;
		}

		System.out.println(days);
	}
}

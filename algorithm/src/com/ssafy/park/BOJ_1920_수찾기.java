package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920_수찾기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arrN = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arrN);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			int left = 0;
            int right = arrN.length - 1;
            boolean flag = false;
            while (left <= right) {
                int midIndex = (left + right) / 2;
                int midValue = arrN[midIndex];
                if (midValue > num) {
                    right = midIndex - 1;
                } else if (midValue < num) {
                    left = midIndex + 1;
                } else { 
                    flag = true;
                    System.out.println(1);
                    break;
                }
            }
            if (!flag) {
                System.out.println(0);
            }
        }
    }
}
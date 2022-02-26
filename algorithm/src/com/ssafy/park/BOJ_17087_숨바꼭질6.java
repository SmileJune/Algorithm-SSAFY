package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17087_숨바꼭질6 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		Integer[] arr = new Integer[N];
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			arr[i] = Math.abs(S - arr[i]);
		}
		int ans = arr[0];
		  if (N != 1) {
	            for (int i = 1; i < arr.length; i++) {
	               ans = gcd(ans , arr[i]);
	            }
	        }
		System.out.println(ans);
	}
	static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}

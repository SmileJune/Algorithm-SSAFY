package com.ssafy.hong;
import java.util.*;

public class Boj2292{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int n = 1, t=1, ans = 1;
		while(t<N) {
			t= t + 6*n;
			n++;
			ans++;
		}
		System.out.println(ans);
	}
}

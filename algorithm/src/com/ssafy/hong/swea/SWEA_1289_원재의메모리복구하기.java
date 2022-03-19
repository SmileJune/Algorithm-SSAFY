package com.ssafy.hong;
import java.io.IOException;
import java.util.*;

public class SWEA_1289_원재의메모리복구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(), t=0;
		
		
		while(t++<T) {
			String str = sc.next();
			int ans = 0, curr = 0;
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i)-'0' != curr) {
					ans++; curr^=1;
				}
			}
			System.out.printf("#%d %d\n",t,ans);
		}
	}
}

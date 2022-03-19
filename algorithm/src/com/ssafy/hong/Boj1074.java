package com.ssafy.hong;
import java.util.*;

public class Boj1074 {
	/**
	 * [BOJ: 1074] Z
	 * 
	 * input:	N R C
	 * output:	ans
	 */
	static int ans = 0;
	static int temp = 0;
	static int R,C;
	static int[] dy = {0,0,1,1};
	static int[] dx = {0,1,0,1};
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		R = sc.nextInt();
		C = sc.nextInt();
		N = (int)(Math.pow(2, N) + 0.1);
		Z(0,0,N);
		System.out.println(ans);
	}
	
	static boolean Z(int y, int x, int size) {
		if(size == 1) {
			if(y == R && x == C) {
                ans = temp;
                return true;
            }
			temp++;
			return false;
		}
		size/=2;
		for(int i=0; i<4; i++) {
			int ty = y+dy[i]*size, tx = x+dx[i]*size;
			if(!(R>=ty && R<ty+size && C>=tx && C<tx+size)) {
				temp += size*size;
				continue;
			}
			if(Z(ty, tx,size)) return true;
		}
        return false;
	}
	
}

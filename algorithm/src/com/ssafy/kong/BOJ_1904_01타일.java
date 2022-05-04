package com.ssafy.BOJ_SB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1904_01타일 {

	static int[] tile;
	static int N ;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		tile = new int[N+1];
		
		System.out.println(tile_f(N));
		
}
	public static int tile_f(int fibo) {
		if(tile[fibo]!=0)
		return tile[fibo];
		
		if(fibo == 1)
			return 1;
		else if(fibo == 2)
			return 2;
		else if(fibo > 2)
			return tile[fibo] = (tile_f(fibo-1) + tile_f(fibo-2))%15746;
		else
			return fibo;
	}

}
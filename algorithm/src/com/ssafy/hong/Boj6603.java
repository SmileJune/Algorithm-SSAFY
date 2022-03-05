package com.ssafy.hong;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Boj6603 {
	static int[] temp = new int[7];
	static int[] arr;
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		while(true) {
			int N = sc.nextInt();
			if(N == 0)break;
			arr= new int[N];
			for(int i=0; i<N; i++)arr[i]=sc.nextInt();
			Arrays.sort(arr);
			recur(0,0,0);
			System.out.println();
		}
	}
	
	static void recur(int idx, int check, int len) {
		if(len == 6) {
			for(int i=0; i<6; i++)System.out.printf("%d ",temp[i]);
			System.out.println();
			return ;
		}
		
		for(int i=idx; i<arr.length; i++)if((check & 1<<i) == 0) {
			temp[len]=arr[i];
			recur(i+1, check | 1<<i, len+1);
		}
	}
	
}

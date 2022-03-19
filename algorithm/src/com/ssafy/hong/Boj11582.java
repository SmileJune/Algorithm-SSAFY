package com.ssafy.hong;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Boj11582 {
	
	static int[] arr;
	static int[] temp;
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		temp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int K = Integer.parseInt(br.readLine());
		mergeSort(0, N, K, 1);
		
		bw.append(sb).flush();
	}
	
	static void mergeSort(int s, int e, int K, int step) {
		if(s+1 >= e)return;
		
		int mid = (s+e)/2;
		
		mergeSort(s, mid, K, step * 2);
		mergeSort(mid, e, K, step * 2);
		merge(s, mid, e);
		
		if(step == K) {
			for(int i=s; i<e; i++) {
				sb.append(arr[i]).append(' ');
			}
		}
	}
	
	static void merge(int s, int mid, int e) {
		int l = s, r = mid, idx = s;
		
		while(l < mid && r < e) {
			if(arr[l] < arr[r]) {
				temp[idx++] = arr[l++];
			}
			else {
				temp[idx++] = arr[r++];
			}
		}
		
		while(l < mid) {
			temp[idx++] = arr[l++];
		}
		while(r < e) {
			temp[idx++] = arr[r++];
		}
		
		for(int i=s; i<e; i++) {
			arr[i] = temp[i];
		}
	}
}

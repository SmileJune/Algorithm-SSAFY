package com.ssafy.hong;
import java.util.*;

public class Boj6549 {
	public static long[] heightList = new long[100001];

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(true) {
			int N = sc.nextInt();
			if(N == 0)break;
			for(int i=0; i<N; i++) {
				heightList[i] = sc.nextLong();
			}
			System.out.println(histogram(0,N));
		}
	}

	public static long histogram(int s, int e){
		if(s + 1 == e) return heightList[s];
		
		int mid = (s + e) / 2;
		long leftAns = histogram(s, mid);
		long rightAns = histogram(mid, e);
	
		long result = Math.max(leftAns, rightAns);
		
		int left = mid - 1;
		int right = mid + 1;
		int width = 1;
		long height = heightList[mid];
	
		while(left >= s || right < e){
			long leftHeight = left >= s? Math.min(height, heightList[left]) : -1;
			long rightHeight = right < e? Math.min(height, heightList[right]) : -1;
			if(leftHeight > rightHeight){
				height = leftHeight;
				left -= 1;
			}
			else{
				height = rightHeight;
				right += 1;
			}
			
			width += 1;
			result = Math.max(result, height * width);
		}
		return result;
	}
}

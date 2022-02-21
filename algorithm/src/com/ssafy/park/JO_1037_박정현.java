package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_1037_박정현 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int no = Integer.parseInt(br.readLine());
		int[][] arr = new int[no+1][no+1];
		int idx = -1;
		int cnt = 0;
		for (int i = 1; i <= no; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int sum = 0;
			for (int j = 1; j <= no; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				sum += arr[i][j];
			}
			if (sum % 2 == 1) {
				cnt++;
				if (idx == -1) idx = i;
				else {
					sb.append("Corrupt" + "\n");
					break;
				}
			}
		}
		int idx2 = -1;
		int cnt2 = 0;
		if (cnt != 2) {
			for (int i =1; i <=no; i++) {
				int sum = 0;
				for (int j =1 ; j <=no; j++) {
					sum += arr[j][i];
				}
				if (sum % 2 ==1) {
					cnt2++;
					if (idx2 == -1) idx2 = i;
					else {
						sb.append("Corrupt" + "\n");
						break;
					}
				}
			}
		}
		if (cnt == 1 && cnt2 == 1) {
			sb.append("Change bit (" + idx +"," + idx2 + ")").append("\n");
		}
		if (cnt == 0 && cnt2 == 0) {
			sb.append("OK");
		}	
		System.out.println(sb);
	}
}

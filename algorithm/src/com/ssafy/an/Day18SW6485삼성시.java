package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day18SW6485삼성시 { // 6485 삼성시의 버스 노선     
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            int[] busStop = new int[5001];
            int N = Integer.parseInt(br.readLine());
             
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                 
                for (int j = A; j <= B; j++)
                    busStop[j]++;
            }
             
            sb.append("#"+ tc);
            int J = Integer.parseInt(br.readLine());
 
            for (int i = 0; i < J; i++) {
                int temp = Integer.parseInt(br.readLine());
                sb.append(" "+ busStop[temp]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}

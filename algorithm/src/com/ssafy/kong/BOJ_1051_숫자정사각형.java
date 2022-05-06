package com.ssafy.BOJ_SB;
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class BOJ_1051_숫자정사각형 {
    public static char[][] map;
 
    public static boolean checkSquare(int i, int j, int l) {
        if(map[i][j] == map[i+l][j] && map[i][j] == map[i][j+l] && map[i][j] == map[i+l][j+l]) return true;
        return false;
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) map[i][j] = s.charAt(j);
        }
        int maxLength = Math.max(N, M);
        int curLength = 1;
        loop:for(int l = maxLength; l>0; l--) {
            for(int i=0; i<N-l; i++) {
                for(int j=0; j<M-l; j++) {
                    if(checkSquare(i, j, l)) {
                        curLength = l+1;
                        break loop;
                    }
                }
            }
        }
        System.out.println(curLength*curLength);
    }
}

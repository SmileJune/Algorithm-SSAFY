package com.ssafy.hwang;

import java.util.Scanner;

public class Day12_BOJ_2567_색종이2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] map = new int[101][101];
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        int sum=0;
        for(int i=0;i<N;i++){
            int row = sc.nextInt();
            int col = sc.nextInt();
            for(int r = row;r<row+10;r++){
                for (int c = col;c<col+10;c++){
                    map[r][c] = 1;
                }
            }
        }

        for(int i=0;i<map.length;i++){
            for(int j=0;j<map.length;j++){
                if(map[i][j] == 1){
                    for(int d = 0; d<4;d++){
                        if(map[i+dx[d]][j+dy[d]]==0){
                            sum++;
                        }
                    }
                }
            }
        }
        System.out.println(sum);
    }
}

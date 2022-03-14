package com.ssafy.BOJ_GD;

import java.util.Scanner;

public class BOJ_2580_스도쿠 {
    static int arr[][];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        arr = new int[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        DFS(0,0);
    }
    public static void DFS(int r, int c){
        if(c == 9){
            DFS(r+1,0);
            return;
        }
        if(r == 9){
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }
        if(arr[r][c] == 0){
            for(int i = 1; i <= 9; i++){
                if(possible(r,c,i)){
                    arr[r][c] = i;
                    DFS(r,c+1);
                }
            }
            arr[r][c] = 0;
            return;
        }
        DFS(r,c+1);
    }
    public static boolean possible(int r, int c, int t){
        for(int i = 0; i < 9; i++){
            if(arr[r][i] == t){
                return false;
            }
        }
        for(int i = 0; i < 9; i++){
            if(arr[i][c] == t){
                return false;
            }
        }
        int nr = (r / 3) * 3;
        int nc = (c / 3) * 3;
        for(int i = nr; i < nr + 3; i++){
            for(int j = nc; j < nc + 3; j++){
                if(arr[i][j] == t){
                    return false;
                }
            }
        }
        return true;
    }
}
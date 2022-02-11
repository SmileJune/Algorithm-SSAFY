import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int[][] map;
    static int N;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t=1;
        while(t<=10){
            N = sc.nextInt();
            map=new int[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++)
                    map[i][j]=sc.nextInt();
            }
            getRidOfN();
            getRidOfS();
            int res =0;
            for(int i=0; i<N; i++){
                int cnt =0;
                int last =map[0][i];
                for(int j=1; j<N; j++){
                    if(map[j][i]>0 && map[j][i]!=last){
                        if(last!=0)cnt++;
                        last=map[j][i];
                    }
                }
                res+=(cnt+1)/2;
            }
            System.out.printf("#%d %d\n",t++,res);
        }
    }
    static void getRidOfS(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[j][i]==1)break;
                map[j][i]=0;
            }
        }
    }
    static void getRidOfN(){
        for(int i=0; i<N; i++){
            for(int j=N-1; j>=0; j--){
                if(map[j][i]==2)break;
                map[j][i]=0;
            }
        }
    }
}


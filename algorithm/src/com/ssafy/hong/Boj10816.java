package com.ssafy.hong
import java.io.*;
import java.util.*;

public class Boj10816 {
    /**
     * [BOJ: 10816] 숫자카드 2
     * 상근이 숫자 카드 N개 가지고 있다.
     * M개의 정수가 주어질때, 각 정수의 카드가 몇장 있는지 출력
     * 
     * input:   N       카드 수
     *          a1,a2.. 카드 번호
     *          M       정수 수
     *          b1,b2.. 정수
     * output:  c1,c2.. 카드 수      
     * @param args
     * @throws IOException
     */
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        int N = Integer.parseInt(input);
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++)A[i]=Integer.parseInt(st.nextToken());
        Arrays.sort(A);

        StringBuilder sb = new StringBuilder();

        input = br.readLine();
        int M = Integer.parseInt(input);
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int b =Integer.parseInt(st.nextToken());
            sb.append(upper(A,b)-lower(A,b));
            sb.append(" ");
        }
        bw.append(sb.toString());
        bw.flush();
    }


    static int upper(int[] arr, int t){
        int l=0, h=arr.length;
        while(l<h){
            int mid = (l+h)/2;
            if(arr[mid]>t)h=mid;
            else l=mid+1;
        }
        return h;
    }
    static int lower(int[] arr, int t){
        int l=0, h=arr.length;
        while(l<h){
            int mid = (l+h)/2;
            if(arr[mid]>=t)h=mid;
            else l=mid+1;
        }
        return h;
    }
}

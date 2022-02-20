package com.ssafy.hong;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Boj10815 {
	/**
	 * [BOJ: 10815] 숫자 카드
	 * 숫자 카드 N개 중 정수 M개가 적혀 있을 때, 이 카드를 갖고 있는지 유무 판단.
	 * 존재 (1), 없음(0)
	 * input:  N	  		카드 수
	 * 		   a1,a2..		배열
	 * 		   M			정수 수
	 * 		   b1,b2..		정수
	 * output: c1 c2 ..		존재 유무
	 */
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++)arr[i]=Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb =new StringBuilder();
        for(int i=0; i<M; i++){
            int v = Integer.parseInt(st.nextToken());
            sb.append(bs(arr,N,v)?1:0).append(" ");
        }
        System.out.println(sb.toString());
    }
    static boolean bs(int[] arr, int size, int val){
        int l = -1, h = size;
        while(l+1<h){
            int mid = (l+h)>>1;
            if(arr[mid]==val)return true;
            if(arr[mid]>val)h = mid;
            else l = mid;
        }
        return false;
    }
}

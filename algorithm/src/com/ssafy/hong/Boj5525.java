package com.ssafy.hong;
import java.io.IOException;
import java.util.*;

public class Boj5525 {
    /**
     * [BOJ: 5525] IOIOI
     * Pn = I+"OI"가 n개
     * 길이 M인 문자열 S안에 pn이 몇개 들어가는가
     * input:    N      Pn
     *           M      S의 길이
     *           S      문자열 S
     * output:   ans    S안의 Pn의 갯수
     * @param args
     * @throws IOException
     */
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextInt();
        String S = sc.next();
        StringBuilder sb = new StringBuilder();
        sb.append("I");
        for(int i=0; i<N; i++){
            sb.append("OI");
        }
        String P = sb.toString();

        int[] fail = new int[P.length()];

        for(int i=1, j=0; i<P.length(); i++){
            while(j>0 && P.charAt(i)!=P.charAt(j))j=fail[j-1];
            if(P.charAt(i)==P.charAt(j))fail[i]=++j;
        }
        int ans=0;
        for(int i=0, j=0; i<S.length();i++){
            while(j>0 && S.charAt(i) != P.charAt(j)) j=fail[j-1];
            if(S.charAt(i) == P.charAt(j)){
                j++;
                if(j==P.length()){
                    j=fail[j-1];
                    ans++;
                }
            }
        }
        System.out.printf("%d",ans);
    }

}

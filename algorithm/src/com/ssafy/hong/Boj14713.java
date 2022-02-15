package com.ssafy.hong;
import java.io.*;
import java.util.*;

public class Boj14713 {
    /**
     * [BOJ: 14713] 앵무새
     * 앵무새 N마리, 각자 한 문장을 말함.
     * 모든 앵무새들이 각자 단어를 말한 결과 문자열이
     * 다음 조건을 모두 만족하면 "Possible" 그렇지 않으면 "Impossible"
     *
     * 1. 한 앵무새는 한 문장을 기억하고 있다. 문장은 여러 단어로 이루어져 있는데, 
		 *		앵무새는 이 단어들을 순서대로 말한다.
     * 2. 한 앵무새가 단어를 말하고 그다음 단어를 말하기 전에는 약간의 간격이 있는데, 
		 * 		이때 다른 앵무새가 말을 가로채고 자신의 문장을 말할 수 있다.
     * 3. 한 앵무새가 단어를 말하는 도중에는, 다른 앵무새가 말을 가로채지 않는다.
     * 4. 어떤 단어도 앵무새가 말하는 모든 문장을 통틀어 2번 이상 등장하지 않는다.
     *
     * input:   N                   앵무새 수
     *          word1 word2 ..      앵무새가 말하는 문장
     *          ...
     *          res1 res 2..        모든 앵무새들이 말한 후 문장
     * output:  ans                 가능 여부
     * @param args
     * @throws IOException
     */
    public static final String POSSIBLE = "Possible";
    public static final String IMPOSSIBLE = "Impossible";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String ,Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        Queue<String>[] q = new LinkedList[N];
        StringTokenizer st = null;
        boolean flag=true;
        outer: for(int i=0; i<N; i++) {
            q[i] = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                String temp = st.nextToken();
                if(map.get(temp)!=null && map.get(temp)>0){
                    flag= false; break outer;
                }
                map.put(temp,i+1);
                q[i].add(temp);
            }
        }
        if(!flag){
            System.out.println(IMPOSSIBLE);
            return;
        }
        String ans = POSSIBLE;

        st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            String curr = st.nextToken();
            if(map.get(curr)==null){
                ans=IMPOSSIBLE;
                break;
            }
            int tidx = map.get(curr)-1;
            if(!q[tidx].peek().equals(curr)){
                ans=IMPOSSIBLE;
                break;
            }
            q[tidx].poll();
        }
        for(int i=0; i<N; i++)if(q[i].size()>0){
            ans=IMPOSSIBLE;
            break;
        }
        bw.append(ans);
        bw.flush();
    }

}

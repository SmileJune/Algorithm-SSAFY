package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj22946 {
    /**
     * [BOJ: 22946] 원 이동하기1
     * 원들을 하나의 노드로 인식
     * 원들의 관계를따져 트리로 만듬
     * 한 노드에서 가장 긴 경로를 가지는 노드까지의 거리를 출력
     *
     * input:   N 원들의 수
     *          x y r (x,y)을 중심으로 r의 반지름을 갖는 원
     *          ...
     * output:  ans 가장 긴 경로
     * @param args
     */
    public static boolean[] visit = new boolean[5002];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Circle> circleList = new ArrayList<>();
        circleList.add(new Circle(0,0,0,2000000000));
        circleList.get(0).dep=0;

        for(int i=0; i<N; i++){
            circleList.add(new Circle(i+1,sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        makeTree(circleList);
        int maxDep=0;
        Circle st = null;
        for (Circle circle: circleList) {
            if(circle.parent!=null) {
                circle.parent.children.add(circle);
                circle.children.add(circle.parent);
            }
            if(maxDep < circle.getDep()){
                maxDep=circle.getDep();
                st=circle;
            }
        }
        visit[st.n]=true;
        System.out.println(dfs(st));
    }


    static int dfs(Circle circle){
        int res=0;
        for (Circle child : circle.children) {
            if (!visit[child.n]) {
                visit[child.n] = true;
                res = Math.max(res, dfs(child) + 1);
            }
        }
        return res;
    }

    static void makeTree(List<Circle> circleList){
        for(int i=0; i< circleList.size(); i++){
            Circle circle = circleList.get(i);
            for(int j=i+1; j< circleList.size(); j++){
                Circle circle1 = circleList.get(j);
                if(circle.compareTo(circle1)==1){
                    if(circle1.parent==null) circle1.parent=circle;
                    else if(circle1.parent.compareTo(circle)==1)circle1.parent=circle;
                }
                else if(circle.compareTo(circle1)==-1){
                    if(circle.parent==null)circle.parent=circle1;
                    else if(circle.parent.compareTo(circle1)==1)circle.parent=circle1;
                }
            }
        }
    }

    static class Circle{
        public int n,x,y,r, dep;
        public Circle parent;
        public List<Circle> children = new ArrayList<>();

        public Circle(int n, int x, int y, int r){this.n=n;this.x=x; this.y=y; this.r=r;this.parent=null; this.dep=-1;}
        public int compareTo(Circle circle){
            double d = Math.sqrt(Math.pow(circle.x-this.x, 2)+Math.pow(circle.y-this.y,2));
            if(d==0) return this.r-circle.r>0?1:-1;
            if(circle.r+this.r<d)return 0;
            return this.r-circle.r>0?1:-1;
        }

        public int getDep(){
            if(this.dep!=-1)return this.dep;
            return dep = parent.getDep()+1;
        }
    }
}

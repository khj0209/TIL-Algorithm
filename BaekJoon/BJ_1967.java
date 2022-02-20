package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1967 {
    static class Node {
        public int par,parVal;
        ArrayList<int[]> son;
        public Node(){
            this.son=new ArrayList<>();
        }
        public void setPar(int par,int parVal){
            this.par=par;
            this.parVal=parVal;
        }
        public void addSon(int son, int value){
            this.son.add(new int[]{son,value});
        }
        public boolean hasSon(){
            if(son.size()==0) return false;
            else return true;
        }
    }
    static int N,max=0;
    static boolean[] visited;
    static Node[] tree;
    static Queue<Integer>q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        tree=new Node[N+1];
        for(int i=0;i<=N;i++) tree[i]=new Node();
        tree[1].par=0;
        tree[1].parVal=0;

        StringTokenizer st;
        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(br.readLine());
            int par=Integer.parseInt(st.nextToken());
            int son=Integer.parseInt(st.nextToken());
            int value=Integer.parseInt(st.nextToken());
            tree[par].addSon(son,value);
            tree[son].setPar(par,value);
        }

        for(int i=1;i<=N;i++){
            if(tree[i].hasSon())continue;
            visited=new boolean[N+1];
            visited[i]=true;
            q=new LinkedList<>();
            UP(tree[i].par,tree[i].parVal);
        }
        System.out.println(max);
    }
    private static void UP(int cur,int sum) {
        if(cur==0){
            return;
        }
        visited[cur]=true;
        Down(cur,sum);
        UP(tree[cur].par,sum+tree[cur].parVal);
    }
    private static void Down(int cur,int sum){
        if(!tree[cur].hasSon()){
            max=Math.max(max,sum);
            return;
        }else if(cur==1) max=Math.max(max,sum);

        visited[cur]=true;
        for(int i=0;i<tree[cur].son.size();i++){
            int[] tmp = tree[cur].son.get(i);
            if(!visited[tmp[0]]){
                Down(tmp[0],sum+tmp[1]);
            }
        }
    }

}

package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_11725 {
    static Node[] nodes;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static class Node{
        int num;
        int parent;
        public Node(int num,int parent){
            this.num=num;
            this.parent=parent;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        visited=new boolean[N+1];
        tree = new ArrayList[N+1];
        nodes = new Node[N+1];
        for(int i=0;i<N+1;i++){
            tree[i]=new ArrayList<>();
        }

        for(int i=0;i<N-1;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            tree[num1].add(num2);
            tree[num2].add(num1);
        }
        for(int i=1;i<=N;i++){
            visited[i]=true;
            remove(i);
        }

        for(int i=2;i<=N;i++){
            System.out.println(nodes[i].parent);
        }
    }

    private static void remove(int parent) {
        for(int i=0;i<tree[parent].size();i++){
            int son=tree[parent].get(i);
            if(!visited[son]) {
                visited[son] = true;
                nodes[son] = new Node(son, parent);
                remove(son);
            }
        }
    }
}

package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1260 {
    static StringBuilder dfs=new StringBuilder();
    static StringBuilder bfs=new StringBuilder();
    static Queue<Integer> b=new LinkedList<>();
    static ArrayList<Integer>[] lists;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int start=Integer.parseInt(st.nextToken());

        lists=new ArrayList[N+1];
        for(int i=0;i<=N;i++) {
            lists[i]=new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
//            System.out.println(s+" "+e);

            lists[s].add(e);
            lists[e].add(s);
//            for(int j=0;j<lists[s].size();j++){
//                if(lists[s].get(j)>e) {
//                    lists[s].add(j,e);
//                    break;
//                }
//                else if(j==lists[s].size()-1) {
//                    lists[s].add(e);
//                }
//            }
//            if(lists[s].size()==0) lists[s].add(e);
//            System.out.println(lists[s].toString());
//
//            for(int j=0;j<lists[e].size();j++){
//                if(lists[e].get(j)>s) {
//                    lists[e].add(j,s);
//                    break;
//                }
//                else if(j==lists[e].size()-1) {
//                    lists[e].add(s);
//                }
//            }
//            if(lists[e].size()==0) {
//                lists[e].add(s);
//            }
//            System.out.println(lists[e].toString());
        }

        for(int i=0;i<=N;i++) {
            Collections.sort(lists[i]);
        }

        visited=new boolean[N+1];
        DFS(start);
        System.out.println(dfs);
        visited=new boolean[N+1];
        BFS(start);
        System.out.println(bfs);
    }
    private static void DFS(int start) {
        visited[start]=true;
        dfs.append(start+" ");
        for(int i : lists[start]){
            if(!visited[i]) DFS(i);
        }
    }
    private static void BFS(int start) {
        b.add(start);
        while (!b.isEmpty()){
            int tmp=b.poll();
            if(visited[tmp]) continue;
            bfs.append(tmp+" ");
            visited[tmp]=true;
            for(int i : lists[tmp]) {
                b.add(i);
            }
        }
    }

}
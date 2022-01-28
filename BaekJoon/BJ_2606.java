package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2606 {
    static Queue<Integer> b=new LinkedList<>();
    static ArrayList<Integer>[] lists;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int M=Integer.parseInt(br.readLine());

        lists=new ArrayList[N+1];
        for(int i=0;i<=N;i++) {
            lists[i]=new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());

            lists[s].add(e);
            lists[e].add(s);
        }

        visited=new boolean[N+1];
        BFS(1);

        int cnt=0;
        for(int i=0;i<=N;i++){
            if(visited[i]) cnt++;
        }
        System.out.println(cnt-1);
    }

    private static void BFS(int start) {
        b.add(start);
        while (!b.isEmpty()){
            int tmp=b.poll();
            if(visited[tmp]) continue;
            visited[tmp]=true;
            for(int i : lists[tmp]) {
                b.add(i);
            }
        }
    }

}
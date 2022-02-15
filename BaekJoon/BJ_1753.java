package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1753 {
    static class Node implements Comparable<Node>{
        public int num, value;
        public Node(int num,int value){
            this.num=num;
            this.value=value;
        }
        @Override
        public int compareTo(Node o) {
            return this.value-o.value;
        }
        public int compareToNum(Node o) {
            return this.num-o.num;
        }
    }
    static int N,M,start;
    static int[] minD;
    static ArrayList<Node>[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        //필요한 정보들 초기화
        minD=new int[N+1];
        map = new ArrayList[N+1];
        for(int i=0;i<=N;i++) map[i]=new ArrayList<>();
        Arrays.fill(minD,Integer.MAX_VALUE);

        //연결정보 입력
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());

            map[from].add(new Node(to,size));
        }

        dijkstra(start);

        Collections.sort(map[start],Node::compareToNum);
        for(int i=1;i<=N;i++){
            if(minD[i]==Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(minD[i]);
        }
    }

    private static void dijkstra(int start) {
        minD[start]=0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));
        while (!pq.isEmpty()){
            int cur = pq.peek().num;
            int d = pq.poll().value;
            if(minD[cur]<d) continue;

            for(int i=0;i<map[cur].size();i++){
                int next = map[cur].get(i).num;
                int nextD = d + map[cur].get(i).value;
                if(nextD<minD[next]) {
                    minD[next] = nextD;
                    pq.add(new Node(next,nextD));
                }
            }
        }
    }
}

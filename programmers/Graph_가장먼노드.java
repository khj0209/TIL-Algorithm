package programmers;
import java.util.*;

public class Graph_가장먼노드 {
    static class Node{
        public int num;
        public LinkedList<Integer> list = new LinkedList<>();
    }
    public int solution(int n, int[][] edge) {
        // int n=7;
        // int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}, {2,7}};
        int answer = 0, max = 0;

        int[] visit = new int[n+1]; //방문체크
        Node[] node = new Node[n+1]; //노드 리스트
        for(int i=0;i<=n;i++){
            node[i]=new Node();
            node[i].num=i;
        }

        //연결정보 입력
        for(int i=0;i<edge.length;i++){
            int a,b;
            a=edge[i][0];
            b=edge[i][1];
            node[a].list.add(b);
            node[b].list.add(a);
        }

        //큐생성 후 초기값 1 입력
        Queue<Node> q = new LinkedList<Node>();
        q.offer(node[1]);
        visit[1]=1;

        //전체 탐색할때까지
        while(!q.isEmpty()){
            LinkedList<Integer> l = new LinkedList<>();
            Node tmp = new Node();
            tmp = q.poll();

            //큐에서 가져온 노트의 뎁스값
            int deps = visit[tmp.num];

            for(int i=0;i<tmp.list.size();i++){
                //큐에서 가져온 노드와 연결되있으면서 방문하지 않은 노드
                if(visit[tmp.list.get(i)]==0){
                    visit[tmp.list.get(i)]=deps+1; //이전 노드의 뎁스+1
                    max = max<visit[tmp.list.get(i)] ? visit[tmp.list.get(i)] : max;
                    q.offer(node[tmp.list.get(i)]); //큐에 넣어줌
                }
            }
        }

        //최대 깊이
        for(int i=1;i<n+1;i++){
            if(max == visit[i]) answer++;
        }

        return answer;
    }
}

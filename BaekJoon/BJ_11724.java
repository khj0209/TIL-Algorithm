package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_11724 {
    static int N,M,cnt=0;
    static boolean[] visited;
    static class Point{
        int num;
        ArrayList<Integer> con=new ArrayList<>();
        public Point(int num){
            this.num=num;
        }
        public void addCon(int conNum){
            con.add(conNum);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        visited=new boolean[N+1];

        Point[] list=new Point[N+1];
        for(int i=1;i<=N;i++){
            list[i]=new Point(i);
        }

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int num=Integer.parseInt(st.nextToken()), conNum=Integer.parseInt(st.nextToken());
            list[num].addCon(conNum);
            list[conNum].addCon(num);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=N;i++){
            if(!visited[i]){
                visited[i]=true;

                q.add(i);
                while(!q.isEmpty()){
                    int n=q.poll();
                    for(int j=0;j<list[n].con.size();j++){
                        if(!visited[list[n].con.get(j)]) {
                            q.add(list[n].con.get(j));
                            visited[list[n].con.get(j)] = true;
                        }
                    }
                }

                cnt++;
            }
        }

        System.out.println(cnt);

    }
}

package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15666 {
    static int N,M;
    static int[] list,result;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        visited=new boolean[N];
        list=new int[N];
        result=new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            list[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);

        visit(0,0,0);
    }

    private static void visit(int start, int resIdx, int sel) {
        if(sel==M) {
            print();
            return;
        }
        if(start>N) return;
        boolean[] visit=new boolean[10001];

        for(int i=0;i<N;i++){
//            if(visited[i] || visit[list[i]])continue;

            if(visit[list[i]] || list[start]>list[i])continue;
            visit[list[i]]=true;
            visited[i]=true;
            result[resIdx]=list[i];
            visit(i,resIdx+1, sel+1);
            visited[i]=false;
        }
    }

    private static void print() {
        for(int i=0;i<M;i++){
            System.out.print(result[i]+" ");
        }
        System.out.println();
    }
}

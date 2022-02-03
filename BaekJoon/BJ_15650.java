package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15650 {
    static int N,M;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        visit=new boolean[N+1];

        visit(1,0);
    }

    private static void visit(int start, int sel) {
        if(sel==M) {
            print();
            return;
        }
        if(start>N) return;

        for(int i=start;i<=N;i++){
            visit[i]=true;
            visit(i+1,sel+1);
            visit[i]=false;
        }
    }

    private static void print() {
        for(int i=1;i<=N;i++){
            if(visit[i]) System.out.print(i+" ");
        }
        System.out.println();
    }
}

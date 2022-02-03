package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15652 {
    static int N,M;
    static int[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        visit=new int[M];

        visit(1,0,0);
    }

    private static void visit(int start, int idx, int sel) {
        if(sel==M) {
            print();
            return;
        }
        if(start>N) return;

        for(int i=start;i<=N;i++){
            visit[idx]=i;
            visit(i,idx+1, sel+1);
        }
    }

    private static void print() {
        for(int i=0;i<M;i++){
            System.out.print(visit[i]+" ");
        }
        System.out.println();
    }
}

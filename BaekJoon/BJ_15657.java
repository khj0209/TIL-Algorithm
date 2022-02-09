package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15657 {
    static int N,M;
    static int[] list,result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        list=new int[N];
        result=new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            list[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);

        visit(0, 0);
    }

    private static void visit(int start, int sel) {
        if(sel==M) {
            print();
            return;
        }

        for(int i=start;i<N;i++){
            result[sel]=list[i];
            visit(i, sel+1);
        }
    }
    private static void print() {
        for(int i=0;i<M;i++){
            System.out.print(result[i]+" ");
        }
        System.out.println();
    }
}

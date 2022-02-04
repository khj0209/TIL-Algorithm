package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2630 {
    static int N,t,white=0,blue=0;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        map=new int[N][N];
        for(int i=1;i<=8;i++){
            if(Math.pow(2,i)==N) t=i;
        }
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<=t;i++){
            divide(i);
        }

        System.out.println(white);
        System.out.println(blue);
    }

    private static void divide(int time) {
        int num = (int) Math.pow(2,time);
        int size= N/(int)Math.pow(2,time);

        for(int i=0;i<num;i++){
            for(int j=0;j<num;j++){
                int startR=i*size,startC=j*size;
                check(startR,startC,size);
            }
        }
    }

    private static void check(int startR, int startC, int size) {
        int st=map[startR][startC];
        if(map[startR][startC]==2) return;
        for(int i=startR;i<startR+size;i++){
            for(int j=startC;j<startC+size;j++){
                if(map[i][j]!=st) return;
            }
        }

        if(st==1) blue++;
        else white++;
        for(int i=startR;i<startR+size;i++){
            for(int j=startC;j<startC+size;j++){
                map[i][j]=2;
            }
        }
    }
}

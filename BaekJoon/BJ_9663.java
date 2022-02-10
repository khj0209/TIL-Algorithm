package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9663 {
    static int N,answer=0;
    static boolean[] R,C;
    static boolean[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());

        map = new boolean[N][N];
        for(int i=0;i<N;i++){
            C=new boolean[N];
            C[i]=true;
            map[0][i]=true;
            countQ(1,1);
            C[i]=false;
            map[0][i]=false;
        }
        System.out.println(answer);
    }

    private static void countQ(int queenC, int r) {
        if(queenC==N) {
            answer++;
            return;
        }
        if(r==N) return;

        for(int j=0;j<N;j++){
            if(C[j])continue;
            if(checkCross(r,j)) continue;
            map[r][j]=true;
            C[j]=true;
            countQ(queenC+1,r+1);
            map[r][j]=false;
            C[j]=false;
        }
    }

    static int[][] d={{-1,-1},{-1,1},{1,-1},{1,1}};
    private static boolean checkCross(int r, int c) {
        for(int i=1;i<N;i++){
            for(int j=0;j<4;j++){
                int dr=r+d[j][0]*i;
                int dc=c+d[j][1]*i;
                if(dr<0 || dc<0 || dr>=N || dc>=N || !map[dr][dc]) continue;
                return true;
            }
        }
        return false;
    }
}

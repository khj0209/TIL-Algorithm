package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_7569 {
    static int[][][] d= {{{-1,0,0}},{{0,-1,0},{0,1,0},{0,0,-1},{0,0,1}},{{1,0,0}}};
    static int[][][] box;
    static int M,N,H;
    static int cnt=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        H=Integer.parseInt(st.nextToken());
        box = new int[H][N][M];
        boolean check = true;

        Queue<int[]> q=new LinkedList<>();
        for(int h=0;h<H;h++){
            for(int n=0;n<N;n++){
                st=new StringTokenizer(br.readLine());
                for(int m=0;m<M;m++){
                    box[h][n][m]=Integer.parseInt(st.nextToken());
                    if(box[h][n][m]==1){
                        int[] tmp = {h,n,m};
                        q.add(tmp);
                    }else if(check) check=false;
                }
            }
        }

        if(check){
            System.out.println(0);
            return;
        }

        while(!q.isEmpty()){
            int[] tmp=q.poll();
            int dh=tmp[0],dn=tmp[1],dm=tmp[2],num=box[dh][dn][dm];
            if(num<1) continue;
            for(int i=0;i<d.length;i++){
                for(int j=0;j<d[i].length;j++){
                    if(checkRange(dh,dn,dm,i,j)){
                        box[dh+d[i][j][0]][dn+d[i][j][1]][dm+d[i][j][2]]=num+1;
                        q.add(new int[] {dh+d[i][j][0],dn+d[i][j][1],dm+d[i][j][2]});
                        if(num>cnt) cnt=num;
                    }
                }
            }
        }

        for(int h=0;h<H;h++){
            for(int n=0;n<N;n++){
                for(int m=0;m<M;m++){
                    if(box[h][n][m]==0){
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        System.out.println(cnt);

    }

    private static boolean checkRange(int dh, int dn, int dm, int i, int j) {
        if(dh+d[i][j][0]<0 || dn+d[i][j][1]<0 || dm+d[i][j][2]<0 || dh+d[i][j][0]>=H || dn+d[i][j][1]>=N || dm+d[i][j][2]>=M) return false;
        if(box[dh+d[i][j][0]][dn+d[i][j][1]][dm+d[i][j][2]]!=0) return false;
        return true;
    }

}
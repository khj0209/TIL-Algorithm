package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14499 {
    static int[][] map, d={{0,0},{0,1},{0,-1},{-1,0},{1,0}};
    static int[] nowDice;
    static int N, M, x, y, K;
    static class dice{
        int up,down,north,south,east,west;
        void mapToDice(int row, int col){
            this.down=map[row][col];
            map[row][col]=0;        
        }
        void diceToMap(int row, int col){
            map[row][col]=this.down;
        }
        void rollDice(int way){
            int tmp=this.down;
            switch(way){
                case 1://동
                    this.down=this.east;
                    this.east=this.up;
                    this.up=this.west;
                    this.west=tmp;
                    break;
                case 2://서
                    this.down=this.west;
                    this.west=this.up;
                    this.up=this.east;
                    this.east=tmp;
                    break;
                case 3://북
                    this.down=this.north;
                    this.north=this.up;
                    this.up=this.south;
                    this.south=tmp;
                    break;
                case 4://남
                    this.down=this.south;
                    this.south=this.up;
                    this.up=this.north;
                    this.north=tmp;
                    break;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        dice di=new dice();

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        x=Integer.parseInt(st.nextToken());
        y=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        map=new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<K;i++){
            int way=Integer.parseInt(st.nextToken());
            int dx = x+d[way][0], dy = y+d[way][1];

            if(dx>=N || dx<0|| dy<0 || dy>=M) continue;
            x=dx;y=dy;

            di.rollDice(way);
            if(map[dx][dy]==0) di.diceToMap(dx, dy);
            else di.mapToDice(dx, dy);
            System.out.println(di.up);
        }

    }
}
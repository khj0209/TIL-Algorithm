package programmers.Level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Test3 {
    public static void main(String[] args) {
        int m=6,n=4;
        int[][] picture={{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

        System.out.println(Arrays.toString(solution(m,n,picture)));
    }
    static boolean[][] isVisit;
    static int[][] d={{-1,0},{1,0},{0,-1},{0,1}};
    static int numberOfArea = 0;
    static int maxSizeOfOneArea = 0;
    public static int[] solution(int m, int n, int[][] picture) {
        isVisit=new boolean[m][n];

        for(int i=0;i< picture.length;i++){
            for(int j=0;j<picture[i].length;j++){
                if(picture[i][j]!=0 && !isVisit[i][j]){
                    numberOfArea++;
                    BFS(picture,i,j);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    private static void BFS(int[][] picture, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        int areasize=1;

        q.add(new int[] {r,c});
        isVisit[r][c]=true;
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            for(int i=0;i<4;i++){
                int dx=tmp[0]+d[i][0];
                int dy=tmp[1]+d[i][1];
                if(dx<0||dx>=picture.length || dy<0||dy>=picture[dx].length || isVisit[dx][dy]) continue;
                if(picture[dx][dy]==picture[r][c]){
                    q.add(new int[] {dx,dy});
                    isVisit[dx][dy]=true;
                    areasize++;
                }
            }
        }
        maxSizeOfOneArea=maxSizeOfOneArea<areasize?areasize:maxSizeOfOneArea;
    }
}

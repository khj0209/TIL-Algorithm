package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class DP_등굣길 {
    public static void main(String[] args) {
        int m=7,n=4;
        int[][] puddles={{2, 1},{2, 2},{2, 3},{4, 2},{4, 3},{4, 4},{6, 2},{6, 3}};
        System.out.println(solution(m,n,puddles));
//        print(solution(2, 2, []), 2)
//        print(solution(3, 3, []), 6)
//        print(solution(3, 3, [[2, 2]]), 2)
//        print(solution(3, 3, [[2, 3]]), 3)
//        print(solution(3, 3, [[1, 3]]), 5)
//        print(solution(3, 3, [[1, 3], [3, 1]]), 4)
//        print(solution(3, 3, [[1, 3], [3, 1], [2, 3]]), 2)
//        print(solution(3, 3, [[1, 3], [3, 1], [2, 3], [2, 1]]), 1)
//        print(solution(7, 4, [[2, 1], [2, 2], [2, 3], [4, 2], [4, 3], [4, 4], [6, 2], [6, 3]]), 0) // 이 값이 잘 나오면 테스트1, 테스트9 통과, 위로 가면 안됨
//        print(solution(4, 4, [[3, 2], [2, 4]]), 7)
//        print(solution(100, 100, []), 690285631)
    }
    static int[][] dm={{0,-1},{-1,0}}; //좌,상
    static long[][] map;
    static boolean[][] visited;
    public static int solution(int m, int n, int[][] puddles) {
        map=new long[n+1][m+1];
        visited=new boolean[n+1][m+1];
        map[n][m]=1;
        visited[n][m]=true;

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[] {n,m});
        while(!q.isEmpty()){
            int[] tmpd=q.poll();
            for(int i=0;i<2;i++){
                int dx=tmpd[0]+ dm[i][0];
                int dy=tmpd[1]+ dm[i][1];
                if(dx<=0 || dy<=0 || visited[dx][dy] || check(puddles,dx,dy)) continue;
                long tmp=0;
                if(dx+1<=n) tmp=map[dx+1][dy];
                if(dy+1<=m) tmp+=map[dx][dy+1];
                map[dx][dy]=tmp%1000000007;
                visited[dx][dy]=true;
                q.add(new int[] {dx,dy});
            }
        }
        return (int)(map[1][1]%1000000007);
    }

    private static boolean check(int[][] puddles, int dx, int dy) {
        for(int i=0;i<puddles.length;i++){
            if(puddles[i].length==0)continue;
            if(puddles[i][0]==dy && puddles[i][1]==dx) {
                visited[dx][dy]=true;
                return true;
            }
        }
        return false;
    }
}

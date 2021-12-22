package programmers;

public class DFS_네트워크 {
    public static void main(){
        int n=3;
        int[][] computers={{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

        System.out.println(solution(n,computers));
    }

    static boolean[] visited;
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        visited=new boolean[n];

        for(int i=0;i<n;i++){
            if(visited[i]) continue;
            DFS(i, n, computers);
            answer++;
        }
        for(int i=0;i<n;i++){
            if(!visited[i]) answer++;
        }

        return answer;
    }

    public static void DFS(int a, int n, int[][] computers) {
        visited[a]=true;

        for(int i=0;i<n;i++){
            if(a==i) continue;
            if(computers[a][i]==1 && !visited[i]) DFS(i,n,computers);
        }
    }
}

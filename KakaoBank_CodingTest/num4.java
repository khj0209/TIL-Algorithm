package KakaoBank_CodingTest;

public class num4 {
    public static void main(String[] args){
        int[][] tower = {{0,2},{2,3},{3,2},{5,3},{6,2},{7,3},{9,4},{10,2},{11,2},{12,4},{14,2},{15,3},{16,2}};
        int k=3;
        System.out.println(solution(tower,k));
    }

    public static int solution(int[][] tower, int k) {
        int answer = 0;

        for(int i=0;i< tower.length;i++){
            if(tower[i][1]==0)continue;
            DFS(tower, k, i, tower[i][1]);
        }
        for(int i=0;i< tower.length;i++){
            if (tower[i][1]!=0) answer++;
        }

        return answer;
    }

    private static void DFS(int[][] tower, int k, int i, int height) {
        for(int a=i+1;a< tower.length;a++){
            if(tower[a][0]-tower[i][0]>k) break;
            else if(tower[a][1]==height) {
                tower[a][1]=0;
                DFS(tower, k, a, height);
                break;
            }
        }
    }
}

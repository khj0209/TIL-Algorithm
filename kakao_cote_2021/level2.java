package kakao_cote_2021;

import java.util.Arrays;

public class level2 {
    public static void main(String[] args){
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        System.out.println(Arrays.toString(solution(places)));

    }
    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        //탐색하다가 사람이 있으면 맨해튼 거리 2 확인
        for(int i=0;i< places.length;i++){
            here:for(int j=0;j<places[i].length;j++){
                for(int k=0;k<5;k++){
                    if(places[i][j].charAt(k)=='P' && !findMan(places, i, j, k)){
                        answer[i]=0;
                        break here;
                    }
                }
                if(j==places[i].length-1) answer[i]=1;
            }
        }

        return answer;
    }
    static int[][] d = {{-1,0},{1,0},{0,-1},{0,1}};
    private static boolean findMan(String[][] places, int classroom, int r, int c) {
        for(int i=0;i<4;i++){
            int dr = r+d[i][0];
            int dc = c+d[i][1];
            if(dr<0 || dr >= places[classroom].length || dc<0 || dc >= places[classroom].length ) continue;
            if(places[classroom][dr].charAt(dc)=='P') return false;
            else if(places[classroom][dr].charAt(dc)=='X') continue;
            for(int j=0;j<4;j++){
                if(dr+d[j][0]<0 || dr+d[j][0] >= places[classroom].length || dc+d[j][1]<0 || dc+d[j][1] >= places[classroom].length ) continue;
                if(dr+d[j][0] == r && dc+d[j][1]==c) continue;
                if(places[classroom][dr+d[j][0]].charAt(dc+d[j][1])=='P') return false;
                else if(places[classroom][dr+d[j][0]].charAt(dc+d[j][1])=='X') continue;
            }
        }
        return true;
    }
}

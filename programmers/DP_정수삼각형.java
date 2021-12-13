package programmers;
import java.util.*;

public class DP_정수삼각형 {
    static int[][] dp;
    public int solution(int[][] triangle) {
        int answer = 0;
        dp = new int[triangle.length][];
        for(int i=0;i<triangle.length;i++){
            dp[i] = new int[triangle[i].length];
        }
        dp[0][0]=triangle[0][0];

        for(int i=1;i<triangle.length;i++){
            dp[i][0]=dp[i-1][0]+triangle[i][0];

            for(int j=1;j<triangle[i].length-1;j++){
                dp[i][j] = dp[i-1][j-1]>dp[i-1][j] ? triangle[i][j]+dp[i-1][j-1] : triangle[i][j]+dp[i-1][j];
            }

            dp[i][dp[i].length-1] = dp[i-1][dp[i-1].length-1]+triangle[i][dp[i].length-1];
        }

        int max=-1;
        for(int i=0;i<dp.length;i++){
            if(dp[dp.length-1][i]>max) max=dp[dp.length-1][i];
        }

        answer=max;
        return answer;
    }
}

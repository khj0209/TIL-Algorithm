package KakaoBank_CodingTest;

public class num1 {
    public static void main(String[] args){
        int[][] fees={{200, 910, 93}, {400, 1600, 188}, {655, 7300, 281}, {0, 15372, 435}};
        int usage = 450;

        System.out.println(solution(fees,usage));
    }

    public static int solution(int[][] fees, int usage) {
        int answer = 0,part= fees.length-1;

        //기본요금 정산
        for(int i=0;i<fees.length-1;i++){
            if(usage <= fees[i][0]) {
                part=i;
                answer+=fees[i][1];
                break;
            }
        }
        if(answer==0) answer+=fees[fees.length-1][1];

        //사용요금 계산
        if(usage<fees[0][0]) {
            answer+=usage*fees[0][2];
            return answer;
        }

        answer+=fees[0][0]*fees[0][2];
        for(int i=1;i<part;i++){
            if(0<=usage-fees[i][0]){
                answer+=(fees[i][0]-fees[i-1][0])*fees[i][2];
            }
        }
        if(part==fees.length-1) answer+=(usage-fees[part-1][0])*fees[part][2];
//        else answer+=(usage-fees[part-1][0])*fees[part][2];

        return answer;
    }
}

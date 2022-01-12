package programmers;

import java.util.Arrays;

public class Greedy_큰수만들기 {
    public static void main(String[] args){
        String number="1924";
        int k =2;

        System.out.println(solution(number,k));
    }

    static String max="0";
    public static String solution(String number, int k) {
        String answer="";

        boolean[] visit = new boolean[number.length()];
        Arrays.fill(visit,Boolean.TRUE);

        Greedy(visit,0, 0, number, k);
        answer=max;

        return answer;
    }

    private static void Greedy(boolean[] visit, int idx, int uncheck, String number, int k){
        //종료조건
        if(idx==number.length() && uncheck!=k) return;

        //체크다했을떄 최대값 확인
        if(uncheck==k) {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i< visit.length;i++){
                if(visit[i]) sb.append(number.charAt(i));
            }
            findMax(sb.toString());
            return;
        }

        visit[idx]=false;
        Greedy(visit,idx+1, uncheck+1, number, k);
        visit[idx]=true;
        Greedy(visit,idx+1, uncheck, number, k);

    }

    private static void findMax(String toString) {
        for(int i=0;i<max.length();i++){
            if(Character.getNumericValue(max.charAt(i))>Character.getNumericValue(toString.charAt(i))){
                break;
            }else if(Character.getNumericValue(max.charAt(i))<Character.getNumericValue(toString.charAt(i))){
                max=toString;
                return;
            }
        }
    }
}

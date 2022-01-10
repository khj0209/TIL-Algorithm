package programmers;

import java.util.Arrays;

public class Sort_가장큰수 {
    public static void main(String[] args) {
        int[] numbers={3, 30, 34, 5, 9};

        System.out.println(solution(numbers));
    }

    static boolean[] isVisit;
    static int[] result;
    static String max="";
    public static String solution(int[] numbers) {
        isVisit=new boolean[numbers.length];
        result=new int[numbers.length];

        for(int i=0;i<numbers.length;i++){
            max+=Integer.toString(numbers[i]);
        }

        perm(numbers, 0);

        return max;
    }
    private static void perm(int[] numbers, int idx) {
        //기저조건
        if(idx == result.length) {
            biggest(result);
            return;
        }

        for(int i=0; i< numbers.length; i++) {
            if(isVisit[i]) continue; // 선택 되지 않은 것들만 선택(중복 X)
            result[idx] = numbers[i];
            isVisit[i] = true; // 선택
            perm(numbers, idx+1); // cnt++ 이 아니라 cnt+1 로 해야한다. (cnt 변경되면 안됨.)
            isVisit[i] = false; // 선택 해제
        }
    }

    private static void biggest(int[] result) {
        String tmp ="";
        for(int i=0;i< result.length;i++){
            tmp+=Integer.toString(result[i]);
        }
        for(int i=0;i<tmp.length();i++){
            if(Character.getNumericValue(max.charAt(i)) > Character.getNumericValue(tmp.charAt(i))) return;
            else if(max.charAt(i)<tmp.charAt(i)){
                max=tmp;
                return;
            }
        }
    }
}

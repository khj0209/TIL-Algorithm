package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class XSearch_소수찾기 {
    public static void main(String[] args) {
        String numbers="011";

        System.out.println(solution(numbers));

    }
    static int answer;
    static boolean[] visited;
    static boolean[] already=new boolean[10000000];
    public static int solution(String numbers) {
        answer = 0;

        for(int i=1;i<=numbers.length();i++){
            visited=new boolean[numbers.length()];
            int[] sel=new int[i];
            Perm(numbers, 0, sel,0, i);
        }

        return answer;
    }

    private static void Perm(String numbers, int idx,int[] sel,int seln, int r) {
        if(seln==r){
            if(check(sel)) answer++;
            return;
        }
        if(idx==visited.length) return;

        for(int i=0;i< visited.length;i++){
            if(!visited[i]){
                visited[i] = true;
                sel[seln] = Character.getNumericValue(numbers.charAt(i));
                Perm(numbers, idx + 1, sel, seln + 1, r);
                visited[i] = false; // 다음 시행을 위한 제거
            }
        }

    }

    private static boolean check(int[] sel) {
        int n=0;
        for(int i=0;i<sel.length;i++){
            n+=sel[sel.length-1-i]*Math.pow(10,i);
        }
        if(n==1 || n==0) return false;
        if(already[n])return false;
        else already[n]=true;
        for(int i=2;i<n;i++){
            if(n%i==0)return false;
        }
        return true;
    }

}

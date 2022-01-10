package KakaoBank_CodingTest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class num2 {
    public static void main(String[] args){
        String[] arr1={"()", "(()", ")()", "()"};
        String[] arr2={")()", "()", "(()"};

        System.out.println(solution(arr1,arr2));
    }
    public static long solution(String[] arr1, String[] arr2) {
        long answer = 0;
        boolean[] arr1B=new boolean[arr1.length];
        boolean[] arr2B=new boolean[arr2.length];
        int arr1b=0,arr2b=0;

        for(int i=0;i< arr1.length;i++){
            if(check1(arr1[i], 2)) {
                arr1B[i]=true;
                arr1b++;
            }
        }
        for(int i=0;i< arr2.length;i++){
            if(check1(arr2[i], 2)) {
                arr2B[i]=true;
                arr2b++;
            }
        }

        for(int i=0;i<arr1.length;i++){
            if(arr1B[i]){
                answer+=arr2b;
            }
            else if (!check1(arr1[i], 1)) continue;
            else {
                for (int j = 0; j < arr2.length; j++) {
                    if (check1(arr1[i] + arr2[j], 2)) answer++;
                }
            }
        }

        return answer==0?-1:answer;
    }

    private static boolean check1(String arr1, int mode) {
        Stack<Character> s = new Stack<>();
        for(int i=0;i<arr1.length();i++){
            if(arr1.charAt(i)=='(') s.push(arr1.charAt(i));
            else if(arr1.charAt(i)==')'){
                if(s.isEmpty()) return false;
                else s.pop();
            }
        }

        if(mode==1) return true;
        else if(mode==2 && s.isEmpty())return true;
        else return false;
    }
//    public static long solution(String[] arr1, String[] arr2) {
//        long answer = 0;
//        boolean[] ar1=new boolean[arr1.length];
//        Arrays.fill(ar1,Boolean.TRUE);
//        int[] arr1size=new int[arr1.length];
//
//        for(int i=0;i< arr1.length;i++){
//            Stack<Character> s = new Stack<>();
//            for(int j=0;j<arr1[i].length();j++){
//                if(arr1[i].charAt(j)=='(') s.push(arr1[i].charAt(j));
//                else if(arr1[i].charAt(j)==')'){
//                    if(s.isEmpty()) {
//                        ar1[i]=false;
//                        break;
//                    }
//                    else s.pop();
//                }
//            }
//            if(!s.isEmpty()) arr1size[i]=s.size();
//        }
//        for(int a=0;a<arr1.length;a++){
//            if(ar1[a]){
//                here : for(int i=0;i<arr2.length;i++){
//                    int checknum=0;
//                    Stack<Character> s = new Stack<>();
//                    for(int j=0;j<arr2[i].length();j++){
//                        if(arr2[i].charAt(j)=='(') s.push(arr2[i].charAt(j));
//                        else if(arr2[i].charAt(j)==')'){
//                            if(s.isEmpty()) {
//                                if(arr1size[a]>checknum)
//                                    checknum++;
//                                else
//                                    continue here;
//                            }
//                            else s.pop();
//                        }
//                    }
//                    if(s.isEmpty())answer++;
//                }
//            }
//        }
//
//
//        return answer==0?-1:answer;
//    }
}

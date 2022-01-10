package programmers;

import java.util.Arrays;
import java.util.HashMap;

public class Hash_전화번호목록 {
    public static void main(String[] args){
        String[] phone_book={"119", "97674223", "1195524421","3456789","11","345","344444444"};

        System.out.println(solution(phone_book));
    }
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String,Integer> m =new HashMap<>();

        Arrays.sort(phone_book);
        for(int i=0;i< phone_book.length;i++){
            m.put(phone_book[i], i);
        }

        for(int i=0;i< phone_book.length;i++){
            for(int j=0;j< phone_book.length;j++){
                if(m.containsKey(phone_book[i].substring(0,j))) return false;
            }
        }

        return answer;
    }

//    public static boolean solution(String[] phone_book) {
//        boolean answer = true;
//
//        Arrays.sort(phone_book);
//        System.out.println(Arrays.toString(phone_book));
//
//        for(int i=0;i<phone_book.length;i++){
//            for(int j=i+1;j<phone_book.length;j++){
//                if(phone_book[i].charAt(0)!=phone_book[j].charAt(0)) break;
//                if(check(phone_book[i],phone_book[j])) return false;
//            }
//        }
//
//        return answer;
//    }
//
//    private static boolean check(String s, String s1) {
//        int len=Math.min(s.length(),s1.length());
//
//        if(s.charAt(len-1)!= s1.charAt(len-1)) return false;
//        for(int i=0;i<len;i++){
//            if(s.charAt(i) != s1.charAt(i))return false;
//        }
//        return true;
//    }
}

package programmers.Level1;

public class Test1 {
    public static void main(String[] args){
        int n = 1234;

        System.out.println(solution(n));
    }
    public static int solution(int n) {
        int answer = 0;
        String num = Integer.toString(n);

        for(int i=0;i<num.length();i++){
            answer+=Character.getNumericValue(num.charAt(i));
        }

        return answer;
    }
}

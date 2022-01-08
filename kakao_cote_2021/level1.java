package kakao_cote_2021;

public class level1 {
    public static void main(String[] args){
        String s = "one4seveneight";
        String s2 = "23four5six7";
        String s3 = "2three45sixseven";
        String s4 = "123";

        System.out.println(solution(s));
        System.out.println(solution(s2));
        System.out.println(solution(s3));
        System.out.println(solution(s4));
    }
    static String[] num = {"zero","one","two","three","four","five","six","seven","eight","nine"};

    public static int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)-'0'>=10){
                for(int j=0;j<10;j++){
                    if(s.substring(i,i+2).equals(num[j].substring(0,2))){
                        sb.append(j);
                        i+=num[j].length()-1;
                        break;
                    }
                }
            }else{
                sb.append(s.charAt(i));
            }
        }
        answer=Integer.parseInt(sb.toString());

        return answer;
    }
}

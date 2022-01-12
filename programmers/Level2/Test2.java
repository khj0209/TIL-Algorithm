package programmers.Level2;

import java.util.HashMap;

public class Test2 {
    public static void main(String[] args){
        String[][] clothes={{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};

        System.out.println(solution(clothes));
    }
    public static int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String,Integer> m = new HashMap<>();

        for(int i=0;i< clothes.length;i++){
            if(m.get(clothes[i][1])==null){
                m.put(clothes[i][1],1);
            }
            else{
                m.put(clothes[i][1],m.get(clothes[i][1])+1);
            }
        }

//        clothes.lengthC1 + clothes.lengthC2 + ... + clothes.lengthCm.size();
        for(int i=1;i<=m.size();i++){
            answer+=(comb(clothes.length,i)-(m.size()-i));
        }

        return answer;
    }

    private static int comb(int n, int r) {
        int nf=1,rf=1,nmr=1;
        for(int i=n;i>0;i--){
            nf*=i;
        }
        for(int i=r;i>0;i--){
            rf*=i;
        }
        for(int i=n-r;i>0;i--){
            nmr*=i;
        }
        return nf/(rf*nmr);
    }
}

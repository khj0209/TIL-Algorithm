package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class XSearch_모의고사 {
    public static void main(String[] args) {
        int[] answers={1,3,2,4,2};

        System.out.println(Arrays.toString(solution(answers)));

    }
    static int[] A={1,2,3,4,5};
    static int[] B={2, 1, 2, 3, 2, 4, 2, 5};
    static int[] C={3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    public static int[] solution(int[] answers) {
        int[] answer={};
        int[] cor=new int[3];
        int max=0;

        for(int i=0;i< answers.length;i++){
            if(A[i% A.length]==answers[i]) {
                cor[0]++;
                max=max<cor[0]?cor[0]:max;
            }
            if(B[i% B.length]==answers[i]) {
                cor[1]++;
                max=max<cor[1]?cor[1]:max;
            }
            if(C[i% C.length]==answers[i]) {
                cor[2]++;
                max=max<cor[2]?cor[2]:max;
            }
        }

        ArrayList<Integer> a=new ArrayList<>();
        for(int i=0;i<3;i++){
            if(max==cor[i]) a.add(i);
        }
        answer=new int[a.size()];
        for(int i=0;i<answer.length;i++){
            answer[i]=a.get(i)+1;
        }

        return answer;
    }
}

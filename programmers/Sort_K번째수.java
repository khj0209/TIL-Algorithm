package programmers;

import java.util.Arrays;

public class Sort_K번째수 {
    public static void main(String[] args) {
        int[] array={1, 5, 2, 6, 3, 7, 4};
        int[][] commands={{2,5,3},{4,4,1},{1,7,3}};
        System.out.println(Arrays.toString(solution(array,commands)));
    }
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int tc=0;tc<commands.length;tc++){
            int[] tmp = new int[commands[tc][1]-commands[tc][0]+1];
            int idx=0;
            for(int i=commands[tc][0]-1;i<commands[tc][1];i++){
                tmp[idx++]=array[i];
            }
            Arrays.sort(tmp);
            answer[tc]=tmp[commands[tc][2]-1];
        }

        return answer;
    }
}

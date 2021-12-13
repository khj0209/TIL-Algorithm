package programmers;

public class DFS_타겟넘버 {
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;

        //필요한 매개변수 - 뎁스, 현재까지 값
        makeNum(0,0,numbers,target);

        return answer;
    }
    static void makeNum(int deps, int num, int[] numbers, int target){
        if(deps==numbers.length){
            if(num==target) answer++;
            return;
        }
        makeNum(deps+1,num+numbers[deps],numbers,target);
        makeNum(deps+1,num-numbers[deps],numbers,target);
    }
}

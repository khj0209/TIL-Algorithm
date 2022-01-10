package programmers.Level1;

public class Test2 {
    public static void main(String[] args){
        int[][] size = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};

        System.out.println(solution(size));
    }
    public static int solution(int[][] sizes) {
        int hMax=0,wMax=0;

        for(int i=0;i< sizes.length;i++){
            int min=Math.min(sizes[i][0],sizes[i][1]);
            int max=Math.max(sizes[i][0],sizes[i][1]);
            wMax=wMax<max?max:wMax;
            hMax=hMax<min?min:hMax;
        }

        return hMax*wMax;
    }
}

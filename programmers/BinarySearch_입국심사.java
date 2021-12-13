package programmers;
import java.util.*;

public class BinarySearch_입국심사 {
    long answer;
    public long solution(int n, int[] times) {
        answer = 0;
        Arrays.sort(times);
        int m=times.length;
        long small = times[0], big = times[m-1];
        answer = bSearch(n,times,0,big*n);

        return answer;
    }
    static long bSearch(int n, int[] times, long start, long end){
        if(start>=end) return end;

        long num=0, mid = (start+end)/2;

        for(int i=0;i<times.length;i++){
            num+=mid/times[i];
        }
        // System.out.println(start+" "+mid+" "+end+" "+num);
        if(num==n)
            return bSearch(n,times,start,mid);
        else if(num>n)
            return bSearch(n,times,start,mid);
        else
            return bSearch(n,times,mid+1,end);

    }
}

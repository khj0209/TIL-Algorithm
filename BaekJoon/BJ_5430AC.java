package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_5430AC {
    static int cnt;
    static int[] input_num;
    static String func;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());
        for (int i = 0; i < TC; i++) {
            StringBuilder sb;

            func = br.readLine();
            st = new StringTokenizer(br.readLine());
            cnt = Integer.parseInt(st.nextToken());
            String input = br.readLine();
            input_num = new int[cnt];
            for (int j = 0; j < cnt; j++) {
                input_num[j] = input.charAt(j*2+1)-'0';
            }

            for (int j = 0; j < func.length(); j++) {
                if (func.indexOf(j) == 'D' && !delete()) {
                    System.out.println("error");
                    break;
                } else if (func.indexOf(j) == 'R') {
                    reverse();
                }
            }

            print();
        }
    }

    static boolean delete() {
        if (input_num[0] == 0) {
            return false;
        }
        for (int i = 0; i < cnt; i++) {
            input_num[i] = input_num[i + 1];
            if (i == cnt - 1 || input_num[i] == 0) {
                input_num[i] = 0;
                break;
            }
        }
        return true;
    }

    static void reverse() {

    }

    static void print() {
        System.out.print("[");
        for(int i=0;i<cnt;i++){
            if(input_num[i]==0) break;
            System.out.print(input_num[i]+",");
        }
        System.out.print("\b");
        System.out.print("]");
    }
}
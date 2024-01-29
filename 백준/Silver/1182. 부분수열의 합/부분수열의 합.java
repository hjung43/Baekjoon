import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,s, result;
    static boolean[] sel;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        sel = new boolean[n];

        st = new StringTokenizer(br.readLine());
        num = new int[n];
        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        result = 0;

        powerset(0);

        System.out.println(result);

    }
    static void powerset(int idx) {
        if(idx == n){
            int sum = 0;
            int isFalse = 0;
            for(int i=0; i<n; i++){
                if(sel[i]){
                    sum += num[i];
                }else{
                    isFalse++;
                }
            }
            if(sum==s && isFalse!=n){
                result++;
            }
            return;
        }
        sel[idx] = false;
        powerset(idx +1);

        sel[idx]=true;
        powerset(idx+1);
    }
}
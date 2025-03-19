import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] time = new int[100001];


        Queue<Integer>q = new LinkedList<>();
        q.offer(n);
        //time[n] = 0;

        loop :
        while (!q.isEmpty()) {
            int t = q.poll();
            int[] next = {t+1, t-1, t*2};
            for (int i = 0; i < 3; i++) {
                int nt = next[i];
                if(nt>=0 && nt<100001 && time[nt] == 0 && nt!=n){
                    q.offer(nt);
                    time[nt] = time[t]+1;
                    if(nt == m) {
                        break loop;
                    }
                }

            }
        }
        System.out.println(time[m]);
    }
}
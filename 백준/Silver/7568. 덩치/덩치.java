import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dungchi = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dungchi[i][0] = Integer.parseInt(st.nextToken());
            dungchi[i][1] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int rank = 0;
            for (int j = 0; j < n; j++) {
                if(i!=j){
                    if (dungchi[i][0] < dungchi[j][0] && dungchi[i][1] < dungchi[j][1]) {
                        rank++;
                    }
                }
            }
            sb.append(rank+1).append(" ");
        }
        System.out.println(sb);


    }
}
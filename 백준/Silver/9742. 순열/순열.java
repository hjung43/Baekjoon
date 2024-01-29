import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, num, cnt;
    static boolean exist;
    static String str;
    static  int[] index;
    static boolean[] visited;
    static int[] result;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        while(input != null){
            StringTokenizer st = new StringTokenizer(input);
            str = st.nextToken();
            num = Integer.parseInt(st.nextToken());
            n = str.length();
            index = new int[n];
            visited = new boolean[n];
            result = new int[n];

            for(int i=0; i< n; i++){
                index[i] = i;
            }
            cnt = 0;
            exist = false;
            System.out.print(str+" "+num+" "+'='+" ");
            perm(0);
            if(!exist){
                System.out.print("No permutation");
            }
            System.out.println();



            input = br.readLine();
        }


    }
    static void perm(int idx){
        if(idx == n){
            cnt++;
            if(cnt == num){
                exist = true;
                for(int i=0; i<n; i++){
                    System.out.print(str.charAt(result[i]));
                }
            }
                return;
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                result[idx] = index[i];
                visited[i]=true;
                perm(idx+1);
                visited[i] = false;
            }
        }

    }
}
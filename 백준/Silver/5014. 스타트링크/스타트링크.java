import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        if(s==g){
            System.out.println("0");
            return;
        }

        int[] visited = new int[f+1];

        int[] move = {u,d*-1};

        Queue<Integer> q = new LinkedList<>();
        q.add(s);

        while(!q.isEmpty()) {
            int t = q.poll();
            if(t==g){
                System.out.println(visited[g]);
                return;
            }
            for(int i=0; i<2; i++){
                int nt = t +move[i];
                if(nt>=1 && nt<=f && visited[nt]==0 && nt!=s){
                    q.offer(nt);
                    visited[nt] = visited[t]+1;
                }
            }
        }

            System.out.println("use the stairs");



    }
}
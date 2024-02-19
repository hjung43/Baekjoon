import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m,start,end;
    static int[] dist;
    static List<int[]>[] bus;
    static StringTokenizer st;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dist = new int[n+1];
        for(int i=0; i<n+1; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        bus = new ArrayList[n+1];
        for(int i=0; i<n+1; i++){
            bus[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            bus[a].add(new int[]{b, w});

        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());



        dijkstra(start);
        System.out.println(dist[end]);

    }
    static void dijkstra(int st){
        visited = new boolean[n+1];
        dist[st] = 0;

        for(int i=0; i<n; i++){
            int min = Integer.MAX_VALUE;
            int idx = -1;

            for(int j=0; j<n+1; j++){
                if(!visited[j] && min>dist[j]){
                    min = dist[j];
                    idx = j;
                }
            }

            if(idx ==-1){
                break;
            }
            visited[idx] = true;

            for(int j=0; j<bus[idx].size(); j++){
                int[] tmp = bus[idx].get(j);


                if(!visited[tmp[0]] && dist[tmp[0]]>dist[idx]+tmp[1]){
                    dist[tmp[0]]=dist[idx]+tmp[1];
                }
            }
        }
    }
}
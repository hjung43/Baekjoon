import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, k;
    static boolean[][] visited;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

//        int[][] virus = new int[k][2];
        List<int[]>[] virus = new ArrayList[k];

        for(int i=0; i<k; i++){
            virus[i] = new ArrayList<>();
        }

        int[][] test = new int[n][n];
        Queue <int[]> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                test[i][j] = Integer.parseInt(st.nextToken());
                if(test[i][j]!=0){
                   virus[test[i][j]-1].add(new int[] {i,j,0});
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        for(int i=0; i<k; i++){
            for(int j=0; j<virus[i].size(); j++){
                q.add(virus[i].get(j));
            }

        }





        loop: while(!q.isEmpty()){
            int[] temp = q.poll();


            if(temp[2]==s){
                continue;
            }
            for(int i=0; i<4; i++){
                int nr = temp[0]+dr[i];
                int nc = temp[1]+dc[i];
//                int nt = temp[2];

                if(nr>=0 && nr <n && nc>=0 && nc <n && test[nr][nc]==0){
                    test[nr][nc] = test[temp[0]][temp[1]];
                    q.add(new int[] {nr, nc, temp[2]+1});
                }
            }
        }


        System.out.println(test[x-1][y-1]);



    }
}
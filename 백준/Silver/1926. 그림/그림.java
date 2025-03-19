import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] picture = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                picture[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        int maxSize = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && picture[i][j]==1){
                    cnt++;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[] {i, j});
                    visited[i][j] = true;
                    int size = 1;

                    while(!q.isEmpty()){
                        int[] t = q.poll();
                        for(int k=0; k<4; k++){
                            int nx = t[0] + dx[k];
                            int ny = t[1] + dy[k];
                            if(nx>=0 && nx<n && ny>=0 && ny< m && picture[nx][ny]==1 && !visited[nx][ny]){
                                q.add(new int[]{nx,ny});
                                visited[nx][ny] = true;
                                size++;
                            }
                        }
                    }
                    maxSize = Math.max(maxSize, size);
                }
            }
        }
        System.out.println(cnt);
        System.out.println(maxSize);
    }
}
import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        for(int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][] map = new int[m][n];
            for(int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }
            int ans = 0;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(map[i][j] == 1) {
                        ans++;
                        Queue<int[]> q = new LinkedList<>();
                        q.offer(new int[]{i, j});
                        while(!q.isEmpty()) {
                            int[]now = q.poll();
                            for(int l = 0; l < 4; l++) {
                                int nx = now[0] + dx[l];
                                int ny = now[1] + dy[l];
                                if(nx>=0 && nx<m && ny>=0 && ny<n && map[nx][ny] == 1) {
                                    q.offer(new int[]{nx, ny});
                                    map[nx][ny] = 0;
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
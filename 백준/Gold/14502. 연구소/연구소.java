import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n,m,cntZ,result;
    static int[][]arr;
    static boolean[][]visited;
    static Queue<int[]>q;
    

    public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          StringTokenizer st = new StringTokenizer(br.readLine());
          n = Integer.parseInt(st.nextToken());
          m = Integer.parseInt(st.nextToken());
          
          arr = new int[n][m];
          cntZ=0;
          result = 0;
          
          for(int i=0; i<n; i++) {
              st = new StringTokenizer(br.readLine());
              for(int j=0; j<m; j++) {
                  arr[i][j] = Integer.parseInt(st.nextToken());
                  if(arr[i][j]==0) {
                      cntZ++;
                  }
              }
          }
          comb(0,0,0);
          System.out.println(result);

    }  
    public static void comb(int r, int c, int cnt) {
        if(cnt==3) {
            bfs(cntZ-3); //벽을 3개 세워서 가니까
            return;
        }
        if(c==m) {
            r=r+1;
            c = 0;
        }
        if(r==n) {
            return;
        }
        if(arr[r][c]==0) {
            arr[r][c]=1;
            comb(r,c+1,cnt+1);
            arr[r][c]=0;
        }
        comb(r,c+1,cnt);
    }
    
    static int[]dr = {-1,0,1,0};
    static int[]dc = {0,1,0,-1};
    
    static void bfs(int cz) {
        visited = new boolean[n][m];
        q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(arr[i][j]==2) {
                    q.add(new int[] {i,j});
                    visited[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()) {
            int[]t = q.poll();
            for(int i=0; i<4; i++) {
                int nr = t[0]+dr[i];
                int nc = t[1]+dc[i];
                if(nr>=0&& nr<n && nc>=0 && nc<m && arr[nr][nc]==0 && !visited[nr][nc]) {
                    q.add(new int[] {nr,nc});
                    visited[nr][nc]=true;
                    cz--;
                }
            }
        }
        if(result<cz) {
            result = Math.max(result, cz);
        }
    }

}
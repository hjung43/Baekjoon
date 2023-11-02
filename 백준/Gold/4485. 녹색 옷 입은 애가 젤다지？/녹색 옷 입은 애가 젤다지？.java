import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[]dr = {-1,0,1,0};
        int[]dc = {0,1,0,-1};
        int n = Integer.parseInt(br.readLine());
        int t = 1;
        while (n != 0) {
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            boolean[][]visited = new boolean[n][n];
            int[][]narr = new int[n][n];
            for(int i=0; i<n; i++) {
                Arrays.fill(narr[i], Integer.MAX_VALUE);
            }
            
            narr[0][0] = arr[0][0];
            
            for(int i=0; i<n*n-1; i++) {
                int min = Integer.MAX_VALUE;
                int idxr = -1;
                int idxc = -1;
                for(int j=0; j<n; j++) {
                    for(int k=0; k<n; k++) {
                        if(!visited[j][k] && narr[j][k]<min) {
                            min = narr[j][k];
                            idxr = j;
                            idxc = k;
                        }
                    }
                }
                if(idxr == -1 && idxc==-1) {
                    break;
                }
                visited[idxr][idxc] = true;
                
                for(int j=0; j<4; j++) {
                    int nr = idxr + dr[j];
                    int nc = idxc + dc[j];
                    if(nr>=0 && nr<n && nc>=0 && nc<n && !visited[nr][nc]) {
                        int np = narr[idxr][idxc]+arr[nr][nc];
                        if(np<narr[nr][nc]) {
                            narr[nr][nc] = np;
                        }
                    }
                }
                
            }
            System.out.println("Problem "+t+": "+narr[n-1][n-1]);
            
            
            t++;
            n = Integer.parseInt(br.readLine());
        }
    }
}
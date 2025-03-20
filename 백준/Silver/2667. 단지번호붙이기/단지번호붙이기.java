import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] apt = new int[n][n];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                apt[i][j] = str.charAt(j)-'0';
            }
        }
        int[] dh = {0,1,0,-1};
        int[] dw = {1,0,-1,0};
        int cnt = 0;
        List<Integer>list = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(apt[i][j]==1){
                    cnt++;
                    Queue<int[]>q = new LinkedList<>();
                    int size = 1;
                    q.offer(new int[]{i,j});
                    apt[i][j] = 0;
                    while(!q.isEmpty()){
                        int[] now = q.poll();
                        for(int k=0; k<4; k++){
                            int nh = now[0]+dh[k];
                            int nw = now[1]+dw[k];
                            if(nh>=0 && nh<n && nw>=0 && nw<n && apt[nh][nw]==1){
                                q.offer(new int[]{nh,nw});
                                apt[nh][nw] = 0;
                                size++;
                            }
                        }
                    }
                    list.add(size);
                }
            }
        }
        System.out.println(cnt);
        Collections.sort(list);
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
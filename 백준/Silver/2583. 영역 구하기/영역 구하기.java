import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] map = new int[h][w];
        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int h1 = Integer.parseInt(st.nextToken());
            int w1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int w2 = Integer.parseInt(st.nextToken());
            for(int j=h1; j<h2; j++) {
                for(int l=w1; l<w2; l++) {
                    map[j][l] = 1;
                }
            }
        }

        int[] dh = {0,1,0,-1};
        int[] dw = {1,0,-1,0};
        int cnt = 0;
        List<Integer>list = new ArrayList<>();

        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                if(map[i][j] == 0) {
                    cnt++;
                    Queue<int[]>q = new LinkedList<>();
                    q.add(new int[] {i,j});
                    map[i][j] = 1;
                    int size = 1;
                    while(!q.isEmpty()) {
                        int[] now = q.poll();
                        for(int l=0; l<4; l++){
                            int nh = now[0]+dh[l];
                            int nw = now[1]+dw[l];
                            if(nh>=0 && nh<h && nw >=0 && nw<w && map[nh][nw]==0){
                                q.offer(new int[]{nh,nw});
                                map[nh][nw] = 1;
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
        for(int i=0; i<list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }

    }
}
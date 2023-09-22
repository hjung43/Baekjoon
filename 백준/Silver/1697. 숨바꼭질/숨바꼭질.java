import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Queue<int []> q = new LinkedList<>();
		
		Set<Integer>set = new HashSet<>();
		
		q.add(new int[] {n,0});
		set.add(n);
		
		while(!q.isEmpty()) {
			int[] t = q.poll();
			
			if(t[0]==k) {
				System.out.println(t[1]);
				return;
			}
			if(!set.contains(t[0]+1)) {
				q.add(new int[] {t[0]+1,t[1]+1});
				set.add(t[0]+1);
			}
			if(!set.contains(t[0]-1)) {
				q.add(new int[] {t[0]-1,t[1]+1});
				set.add(t[0]-1);
			}
			if(!set.contains(t[0]*2) && t[0] <= k) {
				q.add(new int[] {t[0]*2,t[1]+1});
				set.add(t[0]*2);
			}
		}
	}
}
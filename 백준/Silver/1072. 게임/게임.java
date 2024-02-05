import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long x = Integer.parseInt(st.nextToken());
		long y = Integer.parseInt(st.nextToken());
		long z = (y*100)/x;
		int ans = 0;
		
		int start = 0;
		int end = 1000000000;
		while(start<=end) {
			int mid = (start+end)/2;
			long nz = (y+mid)*100/(x+mid);
						
			if(z!=nz) {
				end = mid-1;
				ans = mid;
			}else {
				start = mid+1;
			}
		}
		if(ans == 0) {
			System.out.println(-1);
		}else {		
			System.out.println(ans);
		}
	}
}
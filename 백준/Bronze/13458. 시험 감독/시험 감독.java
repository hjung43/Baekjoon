import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static char[][][] buliding;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //시험장의 개수
		int[]arr = new int[n]; //시험장 배열
		StringTokenizer st = new StringTokenizer(br.readLine());
		//각 시험장에 응시자수 담기
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int b = Integer.parseInt(st.nextToken()); //총감독관이 감시할 수 있는 응시자 수
		int c = Integer.parseInt(st.nextToken()); //부감독관이 감시할 수 있는 응시자 수
		
		long result = 0;
		for(int i=0; i<n; i++) {
			if(arr[i]<=b ) {
				result++;
			}else {
				int t = arr[i]-b;
				int r = t/c;
				if(t%c==0) {
					result += r+1;
				}else {
					result += r+2;
				}
			}
		}
		System.out.println(result);
	}
}
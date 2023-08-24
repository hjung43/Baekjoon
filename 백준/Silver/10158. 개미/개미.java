import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		String str2 = bf.readLine();
		StringTokenizer st2 = new StringTokenizer(str2);
		int p = Integer.parseInt(st2.nextToken());
		int q = Integer.parseInt(st2.nextToken());
		int t = Integer.parseInt(bf.readLine());
		
		if(((t+p)/w)%2==1) {
			p = w-(t+p)%w;
		}else {
			p = (t+p)%w;
		}
		if(((t+q)/h)%2==1) {
			q = h-(t+q)%h;
		}else {
			q = (t+q)%h;
		}
		System.out.println(p+" "+q);
	}
}
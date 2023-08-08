import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //전체 학생수
		double k = sc.nextInt(); //방 당 수용인원수
		double result = 0;
		int[]g= new int[7];
		int[]b= new int[7];
		
		for(int i=0; i<n; i++) {
			int s = sc.nextInt(); //성별
			int y = sc.nextInt(); //학년
			if(s==0) {
				g[y]++;
			}else {
				b[y]++;
			}
		}
		for(int i=1; i<=6; i++) {
			result += Math.ceil(g[i]/k);
			result += Math.ceil(b[i]/k);
		}
		
		System.out.println((int)result);
	}
}
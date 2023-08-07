import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int l = sc.nextInt();
		int result=0;
		
		int[] p = new int[n+1];
		int i=1;
		p[i] = 1;
		
		while(p[i]!=m) {
			result++;
			if(p[i]%2==1) {
				if(i+l<=n) {
					i += l;
					p[i] += 1;
				}else {
					i = i+l-n;
					p[i] +=1;
				}
			}else {
				if(i-l>0) {
					i -=l;
					p[i] +=1;
				}else {
					i = n+(i-l);
					p[i]+=1;
				}
			}
		}
		System.out.println(result);
	}
}
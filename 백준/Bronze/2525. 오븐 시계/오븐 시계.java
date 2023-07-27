import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		int t = sc.nextInt();
		
		int th = t/60;
		int tm = t-(t/60)*60;
		
		if(m+tm>=60) {
			if(h+th+1 >23) {
				System.out.print(h+th+1-24);
				System.out.print(" "+(m+tm-60));
			}else {
				System.out.print(h+th+1);
				System.out.print(" "+(m+tm-60));
			}
		}else {
			if(h+th>23) {
				System.out.print(h+th-24);
				System.out.print(" "+(m+tm));
			}else {
				System.out.print(h+th);
				System.out.print(" "+(m+tm));
			}
		}
	}
}
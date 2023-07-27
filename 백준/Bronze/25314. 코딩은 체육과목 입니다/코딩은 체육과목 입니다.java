import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = 0;
			
		for(int i = 1; i<=n; i++) {
			if(i%4==1) {
				l += 1;
			}
		}
		for(int i = 1; i<=l; i++) {
			System.out.print("long ");
		}
		System.out.print("int");
	}
}
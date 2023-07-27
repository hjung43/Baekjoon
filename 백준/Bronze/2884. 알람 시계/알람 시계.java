import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		
		
		if (h==0) {
			if(m<45) {
				System.out.print(23+" ");
				System.out.print(m+60-45);
			}else {
				System.out.print(h+" ");
				System.out.print(m-45);
			}
		}else {
			if(m<45) {
				System.out.print(h-1+" ");
				System.out.print(m+60-45);
			}else {
				System.out.print(h+" ");
				System.out.print(m-45);
			}
		}
	}
}
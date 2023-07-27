import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = B-((B/100)*100);
        int D = C-((C/10)*10);
        
        System.out.println(A*D);
        System.out.println(A*((C-D)/10));
        System.out.println(A*(B/100));
        System.out.println(A*B);

	}

}
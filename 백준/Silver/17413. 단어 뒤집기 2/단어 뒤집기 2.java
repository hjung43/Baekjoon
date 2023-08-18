import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		StringTokenizer st = new StringTokenizer(str, "<>", true);
		String nstr = "";
		
		while(st.hasMoreTokens()) {
			String a = st.nextToken();
			if(a.equals("<")) {
				while(!a.equals(">")) {
					nstr +=a;
					a = st.nextToken();
				}nstr +=a;
			} else { 
				StringTokenizer st2 = new StringTokenizer(a, " ", true);
				while(st2.hasMoreElements()) {
					StringBuilder sb = new StringBuilder();
					String b = st2.nextToken();
					sb.append(b);
					nstr +=sb.reverse();
				}
			}
		}System.out.println(nstr);
	}
}
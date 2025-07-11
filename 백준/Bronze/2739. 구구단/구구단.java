import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<10; i++){
            int prod = n * i;
            sb.append(n).append(" * ").append(i).append(" = ").append(prod).append("\n");
        }
        System.out.println(sb);
    }
}
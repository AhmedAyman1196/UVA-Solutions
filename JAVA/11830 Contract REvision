import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	static PrintWriter pw = new PrintWriter(System.out);
	static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) throws IOException {
		while (true) {
			String s = sc.next();
			char c = s.charAt(0);
			s = sc.next();
			if (c == '0' && s.equals("0"))
				break;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < s.length(); i++)
				if (s.charAt(i) != c)
					sb.append(s.charAt(i));
			if (sb.toString().length() == 0)
				pw.println(0);
			else {
				BigInteger x = new BigInteger(sb.toString());
				pw.println(x);
			}
		}
		pw.flush();
		pw.close();
	}
}

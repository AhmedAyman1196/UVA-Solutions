import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);

	public static void main(String[] args) throws Exception {
		int n = sc.nextInt();
		while (n-- > 0) {
			frac left = new frac(0, 1), mid = new frac(1, 1), right = new frac(1, 0);
			String s = sc.next();
			for (int i = 0; i < s.length(); i++)
				if (s.charAt(i) == 'R') {
					left = mid;
					mid = new frac(left.num + right.num, left.den + right.den);
				} else {
					right = mid;
					mid = new frac(left.num + right.num, left.den + right.den);
				}
			pw.println(mid.toString());
		}

		pw.flush();
		pw.close();

	}

	public static class frac {
		long num, den;

		public frac(long n, long d) {
			num = n;
			den = d;
		}

		public String toString(){
			return num+"/"+den ;
		}
	}
}

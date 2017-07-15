import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), curryear, currmonth, currday, maxyear = 0, maxmonth = 0, maxday = 0, minyear = 10000000,
				minmonth = 10000000, minday = 10000000;
		String young = "", old = "", s;
		while (n-- > 0) {
			s = sc.next();
			currday = sc.nextInt();
			currmonth = sc.nextInt();
			curryear = sc.nextInt();
			if (curryear > maxyear) {
				maxyear = curryear;
				maxmonth = currmonth;
				maxday = currday;
				old = s;
			} else if (curryear == maxyear) {
				if (currmonth > maxmonth) {
					maxyear = curryear;
					maxmonth = currmonth;
					maxday = currday;
					old = s;
				} else if (currmonth == maxmonth) {
					if (currday > maxday) {
						maxyear = curryear;
						maxmonth = currmonth;
						maxday = currday;
						old = s;
					}
				}
			}
			// -----------------------------------------------------------
			if (curryear < minyear) {
				minyear = curryear;
				minmonth = currmonth;
				minday = currday;
				young = s;
			} else if (curryear == minyear) {
				if (currmonth < minmonth) {
					minyear = curryear;
					minmonth = currmonth;
					minday = currday;
					young = s;
				} else if (currmonth == minmonth) {
					if (currday < minday) {
						minyear = curryear;
						minmonth = currmonth;
						minday = currday;
						young = s;
					}
				}
			}
		}
		System.out.println(old+"\n"+young);
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}

}

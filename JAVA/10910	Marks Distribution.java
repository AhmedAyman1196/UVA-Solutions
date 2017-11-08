import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);
	static int k, n, total, min;
	static int memo[][];

	static int solve(int idx, int have) {
		if (idx == n) {
			if (have == total)
				return 1;
			return 0;
		}
		if (have > total)
			return 0;
		if (memo[idx][have] != -1)
			return memo[idx][have];
		int res = 0;
		for (int i = min; i <= total; i++) {
			res += solve(idx + 1, have + i);
		}
		return memo[idx][have] = res;
	}

	public static void main(String[] args) throws Exception {
		k = sc.nextInt();
		memo = new int[100][100];
		while (k-- > 0) {
			for (int i = 0; i < 100; i++) {
				Arrays.fill(memo[i], -1);
			}
			n = sc.nextInt();
			total = sc.nextInt();
			min = sc.nextInt();
			pw.println(solve(0, 0));
		}

		pw.close();
	}
}

class Scanner {
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
}

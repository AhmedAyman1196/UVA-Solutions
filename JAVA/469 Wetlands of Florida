import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;



// This is wet lands of florida save it !!!!!!!!!!!!!!!





public class Main {
	static PrintWriter pw = new PrintWriter(System.out);
	static Scanner sc = new Scanner(System.in);
	static char grid[][];
	static int i;
	static int[] dx = { 1, 1, 0, -1, -1, -1, 0, 1 }, dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

	static int floodfill(int x, int y, char c1, char c2) {
		if (x < 0 || y < 0 || x >= i || y >= grid[0].length)
			return 0;
		if (grid[x][y] != c1)
			return 0;
		int ans = 1;
		grid[x][y] = c2;
		for (int t = 0; t < 8; t++)
			ans += floodfill(x + dx[t], y + dy[t], c1, c2);
		return ans;
	}

	static void repaint(int x, int y) {
		if (x < 0 || y < 0 || x >= i || y >= grid[0].length)
			return;
		if (grid[x][y] != '.')
			return;
		grid[x][y] = 'W';
		for (int t = 0; t < 8; t++)
			repaint(x + dx[t], y + dy[t]);

	}

	public static void main(String args[]) throws IOException {
		int tc = sc.nextInt();
		String s = "" ; 
		
		while (tc-- > 0) {
			while(s.equals(""))s = sc.next() ;
			grid = new char[101][s.length()];
			i = 0;
			while (!Character.isDigit(s.charAt(0))) {
				for (int j = 0; j < s.length(); j++)
					grid[i][j] = s.charAt(j);
				s = sc.nextLine();
				i++;
			}
			while (!s.equals("")) {
				String tmp[] = s.split(" ");
				int x = Integer.parseInt(tmp[0]) - 1, y = Integer.parseInt(tmp[1]) - 1;
				pw.println(floodfill(x, y, 'W', '.'));
				repaint(x, y);
				if (!sc.ready())
					break;
				else
					s = sc.nextLine();
			}
			if (tc != 0)
				pw.println();
		}
		pw.flush();
		pw.close();
	}

	static public class Scanner {
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

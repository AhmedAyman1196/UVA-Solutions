import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	static Scanner sc = new Scanner(System.in);

	static String s;
	static Pair[] map;

	static boolean check(Pair p1, Pair p2) {
		return p1.c == p2.r;
	}

	static Result solve(int start, int end) {
		ArrayList<Pair> list = new ArrayList<>();
		long mult = 0;
		for (int i = start; i <= end; i++) {
			if (s.charAt(i) != '(') {
				list.add(map[s.charAt(i) - 'A']);
			} else {
				int counter = 1, og = i;
				i++;
				while (counter > 0) {
					if (s.charAt(i) == '(')
						counter++;
					else if (s.charAt(i) == ')')
						counter--;
					if (counter == 0) {
						Result x = solve(og + 1, i - 1);
						if (x.mult == -1) // invalid matrices
							return x;
						mult += x.mult;
						list.add(x.p);
						break;
					}
					i++;
				}
			}
		}
		Result r = null;
		if (list.size() > 1) {
			Pair p1 = list.get(0), p2 = list.get(1);
			if (check(p1, p2)) {
				r = new Result(p1, p2);
				mult += r.mult;
			} else
				return new Result();
		} else
			return new Result(list.get(0), mult);

		for (int i = 2; i < list.size(); i++) {
			if (check(r.p, list.get(i))) {
				r = new Result(r.p, list.get(i));
				mult += r.mult;
			} else
				return new Result();
		}
		return new Result(r.p, mult);
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = sc.nextInt();

		map = new Pair[26];
		for (int i = 0; i < n; i++) {
			s = sc.next();
			map[s.charAt(0) - 'A'] = new Pair(sc.nextInt(), sc.nextInt());
		}
		while (true) {
			s = sc.nextLine();
			Result r = solve(0, s.length() - 1);
			if (r.mult == -1)
				pw.println("error");
			else
				pw.println(r.mult);
			if (!sc.ready())
				break;
		}
		pw.flush();
	}

	static class Pair {
		long r, c;

		public Pair(long row, long col) {
			// TODO Auto-generated constructor stub
			r = row;
			c = col;
		}

		public Pair copy(Pair p) {
			return new Pair(r, c);
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "["+r+" ," +c+"]";
		}
	}

	static class Result {
		Pair p;
		long mult;

		public Result() { // for invalid case
			mult = -1;
		}

		public Result(Pair p, long mult) {
			this.p = p;
			this.mult = mult;
		}

		public Result(Pair p1, Pair p2) {
			p = new Pair(p1.r, p2.c);
			mult = p1.r * p2.c * p1.c;
		}
	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		public Scanner(InputStream s) {
			// TODO Auto-generated constructor stub
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public String next() throws IOException {
			if (st == null || !st.hasMoreElements())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}
}

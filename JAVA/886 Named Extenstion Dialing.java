import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);

	static HashSet<String> names;
	static String alpha[];

	static void init() {
		alpha = new String[10];
		alpha[0] = alpha[1] = "";
		alpha[2] = "abc";
		alpha[3] = "def";
		alpha[4] = "ghi";
		alpha[5] = "jkl";
		alpha[6] = "mno";
		alpha[7] = "pqrs";
		alpha[8] = "tuv";
		alpha[9] = "wxyz";
	}

	static boolean compare(String s, String press) {
		if (s.length() < press.length())
			return false;
		for (int i = 0; i < press.length(); i++) {
			String x = alpha[press.charAt(i) - '0'];
			if (!x.contains(s.charAt(i) + ""))
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		ArrayList<String> name = new ArrayList<>();
		ArrayList<String> code = new ArrayList<>();
		String first = sc.next().toLowerCase(), last;
		while (Character.isAlphabetic(first.charAt(0))) {
			last = sc.next().toLowerCase();
			name.add(first.charAt(0) + last);
			code.add(sc.next());
			first = sc.next().toLowerCase();
		}
		init(); // initialize alpha
		String press = first; // numbers pressed
		while (true) {
			boolean found = false;
			ArrayList<String> ans = new ArrayList<>();
			for (int i = 0; i < name.size() && !found; i++)
				if (code.get(i).equals(press))
					found = true;
				else if (compare(name.get(i), press))
					ans.add(code.get(i));

			if (found)
				pw.println(press);
			else if (ans.size() == 0)
				pw.println(0);
			else
				for (int i = 0; i < ans.size(); i++)
					if (i == ans.size() - 1)
						pw.println(ans.get(i));
					else
						pw.print(ans.get(i) + " ");

			if (!sc.isReady())
				break;
			press = sc.next();
		}
		pw.flush();
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

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public boolean isReady() throws IOException {
			return br.ready() || st.hasMoreElements();
		}
	}
}

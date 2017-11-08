import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static String s;
	static HashSet<String> articles, nouns, verbs;
	// THERE IS A MUCH MUCH MUCH MUCH MUCH MUCH MUCH
	// MUCH MUCH MUCH MUCH MUCH MUCH MUCH MUCH MUCH
	// MUCH MUCH MUCH MUCH MUCH MUCH MUCH MUCH MUCH
	// MUCH MUCH MUCH MUCH MUCH MUCH MUCH MUCH MUCH
	// MUCH MUCH MUCH MUCH MUCH MUCH MUCH MUCH MUCH
	// MUCH MUCH MUCH MUCH MUCH MUCH MUCH MUCH MUCH
	// MUCH MUCH MUCH MUCH MUCH MUCH MUCH MUCH MUCH
	// MUCH MUCH MUCH MUCH MUCH MUCH MUCH MUCH MUCH
	// MUCH MUCH MUCH MUCH MUCH MUCH MUCH MUCH MUCH
	// EASIER SOULTION!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	// USING REGULAR EXPERSSIONS
	static void generate() {
		articles = new HashSet<>();
		nouns = new HashSet<>();
		verbs = new HashSet<>();
		articles.add("a");
		articles.add("the");
		nouns.add("tom");
		nouns.add("jerry");
		nouns.add("goofy");
		nouns.add("mickey");
		nouns.add("jimmy");
		nouns.add("dog");
		nouns.add("cat");
		nouns.add("mouse");
		verbs.add("hate");
		verbs.add("love");
		verbs.add("know");
		verbs.add("like");
	}

	static boolean checkNoun(int start, int end) {
		if (end <= start)
			return false;
		for (int i = start; i <= end; i++)
			if (s.charAt(i) == ' ')
				return false;
		if (nouns.contains(s.substring(start, end + 1)))
			return true;
		else
			return false;
	}

	static boolean checkArticle(int start, int end) {
		if (end < start)
			return false;
		for (int i = start; i <= end; i++)
			if (s.charAt(i) == ' ')
				return false;
		if (articles.contains(s.substring(start, end + 1)))
			return true;
		else
			return false;
	}

	static boolean checkVerb(int start, int end) {
		if (end < start)
			return false;
		for (int i = start; i <= end; i++)
			if (s.charAt(i) == ' ')
				return false;
		if (s.charAt(end) == 's')
			return checkVerb(start, end - 1);
		if (verbs.contains(s.substring(start, end + 1)))
			return true;
		else
			return false;
	}

	static boolean checkActor(int start, int end) {
		if (end < start)
			return false;
		if (checkNoun(start, end))
			return true;
		for (int i = start; i <= end; i++) {
			if (s.charAt(i) == ' ') {
				boolean b1 = checkArticle(start, i - 1);
				boolean b2 = checkNoun(i + 1, end);
				if (b1 && b2)
					return true;
			}
		}
		return false;
	}

	static boolean checkList(int start, int end) {
		if (start > end)
			return false;
		if (checkActor(start, end))
			return true;
		for (int i = start; i <= end - 3; i++) {
			if (s.substring(i, i + 3).equals("and")) {
				boolean b1 = checkList(start, i - 2);
				boolean b2 = checkActor(i + 4, end);
				if (b1 && b2)
					return true;
			}
		}
		return false;
	}

	static boolean checkAction(int start, int end) {
		if (end < start)
			return false;
		String arr[] = s.substring(start, end + 1).split(" ");
		for (int i = 0, idx = start; i < arr.length; idx += arr[i].length() + 1, i++) {
			if (checkVerb(idx, idx + arr[i].length() - 1)) {
				boolean b1 = checkList(start, idx - 2);
				boolean b2 = checkList(idx + arr[i].length() + 1, end);
				if (b1 && b2)
					return true;
			}
		}
		return false;
	}

	static boolean checkStatment(int start, int end) {
		if (end < start)
			return false;
		if (checkAction(start, end))
			return true;
		for (int i = start; i <= end; i++) {
			if (s.charAt(i) == ',') {
				boolean b1 = checkStatment(start, i - 2);
				boolean b2 = checkAction(i + 2, end);
				if (b1 && b2)
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		generate();
		while (true) {
			s = sc.nextLine();
			boolean b1 = false;
			if (s.length() == 0)
				pw.println("NO I WON'T");
			else {
				if (s.charAt(s.length() - 1) == ' ')
					b1 = checkStatment(0, s.length() - 2);
				else
					b1 = checkStatment(0, s.length() - 1);
				if (b1)
					pw.println("YES I WILL");
				else
					pw.println("NO I WON'T");
			}
			if (!sc.ready())
				break;
		}
		pw.flush();
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

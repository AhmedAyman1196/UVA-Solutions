package UVA;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static PrintWriter out = new PrintWriter(System.out);
    static MyScanner in = new MyScanner(System.in);
    static String s;
    static int dp[][];

    static int solve(int i, int j) {
        if (i >= j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int res;
        if (s.charAt(i) == s.charAt(j))
            res = solve(i + 1, j - 1);
        else res = 1 + solve(i + 1, j - 1);
        res = Math.min(res, 1 + solve(i + 1, j));
        res = Math.min(res, 1 + solve(i, j - 1));
        return dp[i][j] = res;
    }

    public static void main(String[] args) throws IOException {
        int t = in.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            s = in.next();
            dp = new int[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++)
                Arrays.fill(dp[i], -1);
            out.printf("Case %d: %d\n", tc, solve(0, s.length() - 1));
        }

        out.flush();
    }

    static class MyScanner {
        StringTokenizer st;
        BufferedReader br;

        public MyScanner(InputStream s) {
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


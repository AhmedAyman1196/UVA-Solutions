// package UVA;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
// if you forget to put answer to long you will get a time limit exceed 

public class Main {
    static PrintWriter out = new PrintWriter(System.out);
    static MyScanner in = new MyScanner(System.in);
    static char[] s;
    static long memo[][];

    static long solve(int x, int y) {
        if (memo[x][y] != -1)
            return memo[x][y];
        long res = 0;
        for (int i = x + 1; i < y; i++)
            for (int j = i; j < y; j++)
                if (s[i] == s[j])
                    res += 1 + solve(i, j);


        return memo[x][y] = res;
    }

    public static void main(String[] args) throws IOException {
        int t = in.nextInt();
        while (t-- > 0) {
            s = in.next().toCharArray();
            memo = new long[s.length][s.length];
            for (int i = 0; i < s.length; i++)
                Arrays.fill(memo[i], -1);

            long ans = 0;
            for (int i = 0; i < s.length; i++)
                for (int j = i; j < s.length; j++)
                    if (s[i] == s[j])
                        ans += 1 + solve(i, j);

            out.println(ans);
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


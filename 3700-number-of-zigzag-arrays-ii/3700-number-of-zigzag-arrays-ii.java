class Solution {
    private static final long MOD = 1_000_000_007L;

    private long[][] multiply(long[][] a, long[][] b) {
        int size = a.length;
        long[][] c = new long[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (a[i][j] == 0) {
                    continue;
                }

                long cur = a[i][j];

                for (int k = 0; k < size; k++) {
                    if (b[j][k] == 0) {
                        continue;
                    }

                    c[i][k] = (c[i][k] + cur * b[j][k]) % MOD;
                }
            }
        }

        return c;
    }

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        int size = 2 * m;
        long[][] t = new long[size][size];

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                t[i][m + j] = 1;
            }

            for (int j = 0; j < i; j++) {
                t[m + i][j] = 1;
            }
        }

        long[][] result = new long[size][size];

        for (int i = 0; i < size; i++) {
            result[i][i] = 1;
        }

        long power = n - 1;

        while (power > 0) {
            if ((power & 1) == 1) {
                result = multiply(result, t);
            }

            t = multiply(t, t);
            power >>= 1;
        }

        long answer = 0;

        for (int i = 0; i < size; i++) {
            long rowSum = 0;

            for (int j = 0; j < size; j++) {
                rowSum = (rowSum + result[i][j]) % MOD;
            }

            answer = (answer + rowSum) % MOD;
        }

        return (int) answer;
    }
}

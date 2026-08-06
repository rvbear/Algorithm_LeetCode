class Solution {
    private int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    public int smallestNumber(int n, int t) {
        int q = n / 10, r = n % 10;

        int req = t / gcd(q + (10 - q) / 10, t);
        int next = ((r + req - 1) / req) * req;
        int x = next - (next - 10) * (next / 10);

        return q * 10 + x;
    }
}

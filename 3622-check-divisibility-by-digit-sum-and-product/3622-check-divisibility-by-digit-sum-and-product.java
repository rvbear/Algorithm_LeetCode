class Solution {
    public boolean checkDivisibility(int n) {
        int add = 0, mul = 1, total = n;

        while (n > 0) {
            int val = n % 10;
            
            add += val;
            mul *= val;

            n /= 10;
        }

        return total % (add + mul) == 0;
    }
}

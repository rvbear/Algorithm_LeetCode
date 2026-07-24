class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        boolean[] pairXor = new boolean[2048];
        boolean[] tripleXor = new boolean[2048];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                pairXor[nums[i] ^ nums[j]] = true;
            }
        }

        for (int x = 0; x < 2048; x++) {
            if (!pairXor[x]) {
                continue;
            }

            for (int v : nums) {
                tripleXor[x ^ v] = true;
            }
        }

        int count = 0;

        for (boolean exists : tripleXor) {
            if (exists) {
                count++;
            }
        }

        return count;
    }
}

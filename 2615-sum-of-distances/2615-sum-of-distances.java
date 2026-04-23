class Solution {
    private class Data {
        long s1, s2;
        int c1, c2;
    }

    public long[] distance(int[] nums) {
        int n = nums.length;
        Map<Integer, Data> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            Data d = map.get(nums[i]);
            
            if (d == null) {
                map.put(nums[i], d = new Data());
            }

            d.s2 += i;
            d.c2 += 1;
        }

        long[] answer = new long[n];
        
        for (int i = 0; i < n; i++) {
            Data x = map.get(nums[i]);
            answer[i] = x.s2 - x.s1 + 1L * x.c1 * i - 1L * i * x.c2;
            x.s1 += i;
            x.s2 -= i;
            x.c1 += 1;
            x.c2 -= 1;
        }

        return answer;
    }
}

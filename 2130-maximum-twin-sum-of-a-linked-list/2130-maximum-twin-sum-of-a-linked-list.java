class Solution {
    public int pairSum(ListNode head) {
        int max = Integer.MIN_VALUE;
        List<Integer> arr = new ArrayList<>();
        ListNode tail = head;

        while (tail != null) {
            arr.add(tail.val);
            tail = tail.next;
        }

        int n = arr.size();

        for (int i = 0; i < n / 2; i++) {
            max = Math.max(max, arr.get(i) + arr.get(n - 1 - i));
        }

        return max;
    }
}

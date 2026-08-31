class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head;
        ListNode cur = head.next;

        int index = 1;
        int firstCritical = -1;
        int lastCritical = -1;
        int minDist = Integer.MAX_VALUE;

        while (cur.next != null) {
            ListNode next = cur.next;

            boolean isMax = cur.val > prev.val && cur.val > next.val;
            boolean isMin = cur.val < prev.val && cur.val < next.val;

            if (isMax || isMin) {
                if (lastCritical == -1) {
                    firstCritical = index;
                } else {
                    minDist = Math.min(minDist, index - lastCritical);
                }

                lastCritical = index;
            }

            prev = cur;
            cur = next;
            index++;
        }

        if (firstCritical == -1 || firstCritical == lastCritical) {
            return new int[] { -1, -1 };
        }

        int maxDist = lastCritical - firstCritical;

        return new int[] { minDist, maxDist };
    }
}
